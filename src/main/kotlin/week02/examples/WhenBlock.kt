package com.bible.week02.examples

// 블록을 사용한 복잡한 when 처리
fun complexWhen(input: String) {
    when (input.lowercase()) {
        "start" -> {
            println("시스템을 시작합니다...")
            println("초기화 중...")
            val startTime = System.currentTimeMillis()
            println("시작 시간: $startTime")
        }

        "stop" -> {
            println("시스템을 종료합니다...")
            println("데이터 저장 중...")
            println("안전하게 종료되었습니다.")
        }

        "reset" -> {
            println("시스템 리셋 중...")
            for (i in 3 downTo 1) {
                println("$i 초 후 리셋...")
                Thread.sleep(1000)  // 1초 대기
            }
            println("리셋 완료!")
        }

        in listOf("help", "도움말", "?") -> {
            println("=== 사용 가능한 명령어 ===")
            println("start  - 시스템 시작")
            println("stop   - 시스템 종료")
            println("reset  - 시스템 리셋")
            println("help   - 도움말 표시")
        }

        else -> {
            println("알 수 없는 명령어: $input")
            println("'help'를 입력하면 사용법을 확인할 수 있습니다.")
        }
    }
}

// when 표현식과 블록의 조합
fun getSystemStatus(status: String): String = when (status) {
    "healthy" -> {
        val uptime = System.currentTimeMillis() % 100000
        "시스템 정상 (가동시간: ${uptime}ms)"
    }

    "warning" -> {
        val memoryUsage = (50..80).random()
        "주의 필요 (메모리 사용률: $memoryUsage%)"
    }

    "error" -> {
        val errorCode = (1000..9999).random()
        "오류 발생 (에러코드: $errorCode)"
    }

    else -> "알 수 없는 상태: $status"
}

fun main() {
    println("=== 명령어 처리 시스템 ===")

    // 여러 명령어 테스트
    complexWhen("start")
    println()

    complexWhen("help")
    println()

    complexWhen("unknown")
    println()

    // 상태 확인
    println("=== 시스템 상태 ===")
    println(getSystemStatus("healthy"))
    println(getSystemStatus("warning"))
    println(getSystemStatus("error"))
}