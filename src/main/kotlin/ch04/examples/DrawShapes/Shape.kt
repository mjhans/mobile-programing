package com.bible.ch04.examples.DrawShapes

/**
 * 도형 - Sealed Class
 *
 * 제한된 타입 계층을 정의하여 타입 안전성을 보장
 * When 표현식에서 Exhaustive (완전 분기) 가능
 */
sealed class Shape {
    /**
     * 도형 그리기 - 각 도형별로 오버라이드
     */
    abstract fun draw(): String

    /**
     * 삼각형 - data class
     */
    data class Triangle(val sideLength: Double) : Shape() {
        override fun draw(): String =
            "삼각형을 그렸습니다: 변 길이=${"%.1f".format(sideLength)}"
    }

    /**
     * 직사각형 - data class (속성 포함)
     */
    data class Rectangle(val width: Double, val height: Double) : Shape() {
        override fun draw(): String =
            "직사각형을 그렸습니다: 너비=${"%.1f".format(width)}, 높이=${"%.1f".format(height)}"
    }

    /**
     * 원 - data class
     */
    data class Circle(val radius: Double) : Shape() {
        override fun draw(): String =
            "원을 그렸습니다: 반지름=${"%.1f".format(radius)}"
    }

    /**
     * 오각형 - data class
     */
    data class Pentagon(val sideLength: Double) : Shape() {
        override fun draw(): String =
            "오각형을 그렸습니다: 변 길이=${"%.1f".format(sideLength)}"
    }

    /**
     * 육각형 - data class
     */
    data class Hexagon(val sideLength: Double) : Shape() {
        override fun draw(): String =
            "육각형을 그렸습니다: 변 길이=${"%.1f".format(sideLength)}"
    }
}
