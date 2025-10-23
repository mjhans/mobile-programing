package com.bible.ch04.examples.Starcraft

import com.bible.ch04.examples.Starcraft.Units.impl.*
import com.bible.ch04.examples.Starcraft.Util.Point

/**
 * ============================================
 * Starcraft Unit 데모
 * ============================================
 *
 * 시나리오:
 * 1. Marine 5기를 생성
 * 2. Dropship 1기를 생성
 * 3. Marine 5기를 (3,4) 좌표로 이동
 * 4. Dropship을 (3,4) 좌표로 이동
 * 5. Marine 5기를 Dropship에 탑승
 * 6. Dropship 정보 출력
 *
 * 학습 목표:
 * - 상속: AbstractUnit → Marine, Dropship
 * - 오버라이딩: moveTo(), attack()
 * - 다형성: AbstractUnit 타입으로 통일된 처리
 * - 객체 배열: Marine 배열 관리
 */
fun main() {
    // 1. Marine 5기 생성
    val marines = Array(10) { Marine(Point(1, 1), 100) }

    // 2. Dropship 1기 생성
    val dropship = Dropship(Point(1, 1), 200)

    // 3. Marine들을 목표 지점으로 이동
    for (marine in marines) {
        marine.moveTo(3, 4)
    }

    // 4. Dropship을 목표 지점으로 이동
    dropship.moveTo(3, 4)

    // 5. Marine들을 Dropship에 탑승
    for (marine in marines) {
        dropship.takeMarine(marine)
    }

    // 6. Dropship 정보 출력
    dropship.showInfo()

    marines.forEach { marine ->
        marine.attack()
    }
}
