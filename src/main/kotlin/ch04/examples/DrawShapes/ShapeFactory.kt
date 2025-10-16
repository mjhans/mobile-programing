package com.bible.ch04.examples.DrawShapes

/**
 * 도형 생성 팩토리 - Factory Pattern
 *
 * Enum 타입을 받아서 적절한 Sealed Class 객체를 생성
 * When 표현식에서 Exhaustive (완전 분기) 시연
 */
object ShapeFactory {

    /**
     * Enum 타입으로 도형 생성
     *
     * When 표현식이 Exhaustive (완전 분기):
     * - 모든 Enum 값을 처리하므로 else 분기 불필요
     * - 새로운 Enum 값 추가 시 컴파일 에러 발생 (안전성)
     */
    fun create(type: ShapeType): Shape = when (type) {
        ShapeType.TRIANGLE -> Shape.Triangle(5.0)
        ShapeType.RECTANGLE -> Shape.Rectangle(5.0, 3.0)
        ShapeType.CIRCLE -> Shape.Circle(3.0)
        ShapeType.PENTAGON -> Shape.Pentagon(4.0)
        ShapeType.HEXAGON -> Shape.Hexagon(4.0)
        // else 분기 불필요 - 모든 경우를 다룸 (Exhaustive!)
    }
}
