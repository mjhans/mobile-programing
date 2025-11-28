package com.bible.ch05.examples

data class Customer(
    val id: Int,
    var name: String,
    var age: Int,
    val tags: MutableList<String> = mutableListOf()
)

fun main() {
    // 1) 데이터 생성: apply로 객체 초기화, also로 생성 로그
    val customers: List<Customer> = (1..10).map { i ->
        Customer(
            id = i,
            name = " user-$i ",                 // 일부러 공백/소문자 포함
            age = 18 + (i % 7) + i              // 19~34 사이로 분포
        ).apply {
            // 초기 구성(빌더 스타일): 규칙 기반 태깅
            if (age >= 25) tags += "adult"
            if (i % 2 == 0) tags += "even-id"
        }.also { created ->
            // 부수효과(로그/디버깅/계측): 객체는 그대로 흘려보냄
            println("[CREATE] id=${created.id}, rawName='${created.name}', age=${created.age}, tags=${created.tags}")
        }
    }.also {
        println("==> 총 ${it.size}명 생성 완료\n")
    }

    // 2) 전처리: 이름 정규화 (apply로 객체 자체를 손보고, also로 단계 로그)
    val normalized: List<Customer> = customers.map { u ->
        u.apply {
            name = name.trim().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }
    }.also {
        println("==> 이름 정규화 완료 (trim + Titlecase)\n")
    }

    // 3) 필터링/정렬 파이프라인: also로 파이프라인 중간 상태 확인
    val adultsSorted = normalized
        .filter { it.age >= 25 }
        .also { println("필터: 25세 이상 ${it.size}명") }
        .sortedWith(compareBy<Customer> { it.age }.thenBy { it.name })
        .also { println("정렬: age ASC, name ASC 적용\n") }


    // 4) with로 "리스트 문맥"에서 리포트 문자열 생성 (리턴 값은 String)
    val report: String = with(adultsSorted) {
        val customerList = this
        val count = size
        val avgAge = if (isNotEmpty()) map { it.age }.average() else 0.0
        val tagHistogram: Map<String, Int> = flatMap { it.tags }.groupingBy { it }.eachCount()

        // buildString 대신 직접 StringBuilder 사용
        val sb = StringBuilder()
        with(sb) {
            appendLine("===== 사용자 리포트 =====")
            appendLine("대상 인원: $count 명")
            appendLine("평균 나이: ${"%.1f".format(avgAge)}")
            appendLine("태그 분포 : $tagHistogram")
            appendLine()
            appendLine("상세 목록 (age ↑, name ↑)")

            // 🔑 바깥 with(adultsSorted)의 리시버를 명시
            customerList.forEach { u ->
                appendLine(" - #${u.id} ${u.name} (${u.age}) tags=${u.tags}")
            }
        }
        // StringBuilder의 결과 반환
        sb.toString()

        //
//        buildString {
//            appendLine("===== 사용자 리포트 =====")
//            appendLine("대상 인원: $count 명")
//            appendLine("평균 나이: ${"%.1f".format(avgAge)}")
//            appendLine("태그 분포 : $tagHistogram")
//            appendLine()
//            appendLine("상세 목록 (age ↑, name ↑)")
//
//            // 🔑 바깥 with(adultsSorted)의 리시버를 명시
//            customerList.forEach { u ->
//                appendLine(" - #${u.id} ${u.name} (${u.age}) tags=${u.tags}")
//            }
//        }
    }

    // 5) 결과 출력
    println(report)
}