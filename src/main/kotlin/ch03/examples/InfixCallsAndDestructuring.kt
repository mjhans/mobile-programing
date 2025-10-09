/**
 * 3.4.2 Infix calls와 destructuring declarations
 * 중위 호출과 구조 분해 선언으로 더 읽기 쉬운 코드
 */

fun main() {
    // Infix call 문법
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    // 실제로는 1.to("one")과 같음 - to는 infix 함수

    // Pair 생성의 두 가지 방법
    val pair1 = Pair(7, "seven")
    val pair2 = 7 to "seven"  // infix call

    println("pair1: $pair1")
    println("pair2: $pair2")

    // Destructuring declaration
    val (number, name) = 1 to "one"
    println("number: $number, name: $name")

    // for 루프에서 destructuring
    for ((index, element) in listOf("a", "b", "c").withIndex()) {
        println("$index: $element")
    }
}