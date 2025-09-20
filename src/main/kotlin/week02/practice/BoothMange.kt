package com.bible.week02.practice

val boothNames = ArrayList<String>()

fun assignBoothNumber(name: String, boothType: String = "체험"): String {
    // TODO: 부스 종류(boothType)에 따라 적절한 카테고리 코드를 결정하세요
    var boothCategory = ""
    when (boothType) {
        "음식" -> boothCategory = "F"
        "게임" -> boothCategory = "G"
        else -> boothCategory = "E"
    }
    // TODO: 100부터 999 사이의 랜덤한 3자리 숫자를 생성하세요
    val randomNumber = (100..999).random()

    // TODO: 카테고리 코드와 숫자를 조합하여 "코드-숫자" 형식의 부스 번호를 반환하세요
    //방법1 : 리스트에 생성된 값을 넣어서, 매번 비교
//    if (!boothNames.contains(randomNumber)){
//        boothNames.add(randomNumber)
//    }
    //방법2: 미리 100~999까지 범위를 만들고, 랜덤하게 리스트로 만들어둔다
    //      제일 앞에값을 꺼내오고, 리스트에서 삭제시킨다.

    return "${boothCategory}-${randomNumber}"
}

// 테스트 코드
fun main() {
    println(assignBoothNumber("떡볶이 천국", "음식"))  // F-XXX 형태
    println(assignBoothNumber("다트 게임", "게임"))     // G-XXX 형태
    println(assignBoothNumber("타로 점술"))            // E-XXX 형태 (기본값)
}