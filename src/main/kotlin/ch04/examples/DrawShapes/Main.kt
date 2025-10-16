package com.bible.ch04.examples.DrawShapes

/*
 * 도형 그리기 - Factory Pattern + Sealed Class
 *
 * 핵심 개념:
 * 1. Enum - 도형 타입을 명시적으로 정의
 * 2. Factory Pattern - Enum을 받아 Sealed Class 객체 생성
 * 3. Sealed Class - 제한된 타입 계층 구조
 * 4. Exhaustive When - 모든 경우를 다뤄야 함 (else 불필요)
 * 5. Smart Cast - is 체크 후 자동 타입 캐스팅
 */

fun main() {
    println("=".repeat(70))
    println("도형 그리기 - Factory Pattern + Sealed Class")
    println("=".repeat(70))

    // ============================================
    // 1. Factory Pattern - Enum → Sealed Class
    // ============================================
    println("\n[1. Factory를 통한 도형 생성]")
    println("-".repeat(70))

    val triangle = ShapeFactory.create(ShapeType.TRIANGLE)
    println(triangle.draw())

    val rectangle = ShapeFactory.create(ShapeType.RECTANGLE)
    println(rectangle.draw())

    val circle = ShapeFactory.create(ShapeType.CIRCLE)
    println(circle.draw())

    val pentagon = ShapeFactory.create(ShapeType.PENTAGON)
    println(pentagon.draw())

    val hexagon = ShapeFactory.create(ShapeType.HEXAGON)
    println(hexagon.draw())

    // ============================================
    // 2. Enum 순회 + Factory
    // ============================================
    println("\n[2. 모든 도형 타입 순회]")
    println("-".repeat(70))

    ShapeType.entries.forEach { type ->
        val shape = ShapeFactory.create(type)
        println("${type.name} → ${shape.draw()}")
    }

    // ============================================
    // 3. Exhaustive When - Sealed Class
    // ============================================
    println("\n[3. When 표현식 - Exhaustive (모든 케이스 처리)]")
    println("-".repeat(70))

    val shapes = listOf(
        triangle,
        rectangle,
        circle,
        pentagon,
        hexagon,
    )

    shapes.forEach { shape ->
        // When 표현식이 Exhaustive - else 분기 불필요!
        val description = when (shape) {
            is Shape.Triangle -> "삼각형 (변 ${shape.sideLength})"
            is Shape.Rectangle -> "직사각형 (${shape.width}x${shape.height})"
            is Shape.Circle -> "원 (반지름 ${shape.radius})"
            is Shape.Pentagon -> "오각형 (변 ${shape.sideLength})"
            is Shape.Hexagon -> "육각형 (변 ${shape.sideLength})"
            // else 불필요 - Sealed Class의 모든 하위 타입을 다룸
        }
        println("타입: $description")
    }

    // ============================================
    // 4. Smart Cast 시연
    // ============================================
    println("\n[4. Smart Cast - is 체크 후 자동 타입 변환]")
    println("-".repeat(70))

    shapes.forEach { shape ->
        when (shape) {
            is Shape.Triangle -> {
                // Smart Cast - shape가 자동으로 Shape.Triangle 타입
                // shape.sideLength 접근 가능!
                println("삼각형: 변 길이=${shape.sideLength}")
                println("  → ${shape.draw()}")
            }
            is Shape.Rectangle -> {
                // Smart Cast - shape가 자동으로 Shape.Rectangle 타입
                // shape.width, shape.height 접근 가능!
                println("직사각형: 너비=${shape.width}, 높이=${shape.height}")
                println("  → ${shape.draw()}")
            }
            is Shape.Circle -> {
                // Smart Cast - shape.radius 접근 가능
                println("원: 반지름=${shape.radius}")
                println("  → ${shape.draw()}")
            }
            is Shape.Pentagon -> {
                // Smart Cast - shape.sideLength 접근 가능
                println("오각형: 변 길이=${shape.sideLength}")
                println("  → ${shape.draw()}")
            }
            is Shape.Hexagon -> {
                // Smart Cast - shape.sideLength 접근 가능
                println("육각형: 변 길이=${shape.sideLength}")
                println("  → ${shape.draw()}")
            }
        }
    }

    // ============================================
    // 5. Factory + When 조합
    // ============================================
    println("\n[5. Factory와 When의 조합]")
    println("-".repeat(70))

    // Enum의 모든 값을 순회하며 Factory로 생성 후 처리
    ShapeType.entries.forEach { type ->
        val shape = ShapeFactory.create(type)

        // Sealed Class의 When (Exhaustive)
        when (shape) {
            is Shape.Triangle -> println("✦ 삼각형 생성 완료: 변 ${shape.sideLength}")
            is Shape.Rectangle -> println("▢ 직사각형 생성 완료: ${shape.width}x${shape.height}")
            is Shape.Circle -> println("◯ 원 생성 완료: 반지름 ${shape.radius}")
            is Shape.Pentagon -> println("⬠ 오각형 생성 완료: 변 ${shape.sideLength}")
            is Shape.Hexagon -> println("⬡ 육각형 생성 완료: 변 ${shape.sideLength}")
        }
    }

    println("\n" + "=".repeat(70))
    println("완료!")
    println("=".repeat(70))
}

/*
======================================================================
핵심 정리: Factory Pattern + Sealed Class
======================================================================

1. Enum (열거형)
---------------
enum class ShapeType {
    TRIANGLE, RECTANGLE, CIRCLE, PENTAGON, HEXAGON
}

→ 지원하는 도형 타입을 명시적으로 정의
→ 타입 안전성 보장

2. Sealed Class (봉인된 클래스)
------------------------------
sealed class Shape {
    object Triangle : Shape()
    data class Rectangle(...) : Shape()
    data class Circle(...) : Shape()
    ...
}

→ 제한된 타입 계층 구조
→ 모든 하위 타입이 같은 파일에 정의됨
→ When 표현식에서 Exhaustive 가능

3. Factory Pattern (팩토리 패턴)
-----------------------------
object ShapeFactory {
    fun create(type: ShapeType): Shape = when (type) {
        ShapeType.TRIANGLE -> Shape.Triangle
        ShapeType.RECTANGLE -> Shape.Rectangle(5.0, 3.0)
        ...
        // else 불필요 - Exhaustive!
    }
}

→ 객체 생성 로직을 한곳에 집중
→ Enum → Sealed Class 변환
→ When 표현식의 Exhaustive 활용

4. Exhaustive When (완전 분기)
----------------------------
when (shape) {
    is Shape.Triangle -> ...
    is Shape.Rectangle -> ...
    is Shape.Circle -> ...
    is Shape.Pentagon -> ...
    is Shape.Hexagon -> ...
    // else 불필요 - 모든 경우를 다룸!
}

→ Sealed Class의 모든 하위 타입을 처리
→ 새로운 타입 추가 시 컴파일 에러 발생
→ 안전성 보장

5. Smart Cast (스마트 캐스팅)
---------------------------
when (shape) {
    is Shape.Rectangle -> {
        // shape가 자동으로 Shape.Rectangle 타입으로 캐스팅됨
        println(shape.width)   // OK!
        println(shape.height)  // OK!
    }
}

→ is 체크 후 자동 타입 변환
→ 명시적 캐스팅 불필요
→ 타입 안전성 보장

6. 교육적 가치
-------------
🔷 OOP 패턴
   - Factory Method Pattern
   - Sealed Class 계층 구조
   - 다형성 (draw 메서드 오버라이드)

🔷 Kotlin 특징
   - Enum + 프로퍼티
   - Sealed Class + Exhaustive When
   - Smart Cast
   - Object (싱글톤)
   - Data Class

🔷 타입 안전성
   - 컴파일 타임 검증
   - Exhaustive When으로 누락 방지
   - Smart Cast로 안전한 타입 접근

======================================================================
결론: "Enum + Factory + Sealed Class = 타입 안전한 설계"
======================================================================
 */
