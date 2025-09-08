package com.bible.week02.examples

fun main() {
    val name = "철수"
    val age = 20

    // 기본 방법 (+ 연산자 사용)
    println("안녕하세요. 제 이름은 " + name + "이고, 나이는 " + age + "세입니다.")

    // Kotlin 방법 (문자열 템플릿 사용) - 훨씬 쉽고 읽기 좋음!
    println("안녕하세요. 제 이름은 ${name}이고, 나이는 ${age}세입니다.")

    // 계산도 넣을 수 있음
    println("내년에는 ${age + 1}세가 됩니다.")

    val product = "노트북"
    val price = 1500000
    val discount = 10

    // 간단한 변수 삽입
    println("상품: $product")

    // 계산 결과 삽입
    println("원가: \$${price}") // 특수문자 \
    println("할인가: ${price * (100 - discount) / 100}원")

    // 함수 호출 결과 삽입
    println("상품명 길이: ${product.length}글자")

    // 조건문 결과 삽입
    println("가격 수준: ${if (price > 1000000) "고가" else "저가"}")
}