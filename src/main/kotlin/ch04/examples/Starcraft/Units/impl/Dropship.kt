package com.bible.ch04.examples.Starcraft.Units.impl

import com.bible.ch04.examples.Starcraft.Units.AbstractUnit
import com.bible.ch04.examples.Starcraft.Units.IFlyable
import com.bible.ch04.examples.Starcraft.Util.Point
import com.bible.ch04.examples.Starcraft.Util.getPointInfo

/**
 * Dropship - Marine을 수송하는 비행선
 *
 * "is a kind of Unit" + "be able to fly"
 *
 * 특징:
 * - 공격 능력 없음 (IAttackable 구현 안함!)
 * - Marine을 최대 8기까지 탑승 가능
 * - Marine보다 이동속도가 2배 느림
 * - 비행선 (IFlyable)
 *
 * 구현:
 * - AbstractUnit: 공통 속성 (current, hp)
 * - IFlyable: 비행 능력
 * - IAttackable 구현 안함 (공격 불가)
 */
class Dropship(current: Point, initHP: Int) :
    AbstractUnit(current, initHP), IFlyable {

    private val units: Array<Marine?> = arrayOfNulls(8)
    private var currentTakeUnit: Int = 0
    private val MAX_UNIT = 8

    /**
     * 현재 탑승한 Marine 수 반환
     * Extension function에서 사용하기 위한 getter
     */
    fun getMarineCount(): Int = currentTakeUnit

    /**
     * 이동 구현 (IFlyable)
     * Dropship의 느린 비행
     */
    override fun moveTo(x: Int, y: Int): Point {
        current = Point(x, y)
        println("Dropship slowly move to ${current.getPointInfo()}")
        return current
    }

    /**
     * Marine 탑승
     * @param unit 탑승할 Marine
     * @return 현재 탑승한 Marine 수
     */
    fun takeMarine(unit: Marine): Int {
        if (currentTakeUnit < MAX_UNIT) {
            units[currentTakeUnit++] = unit
            println("현재 탑승한 마린은 $currentTakeUnit 기 입니다")
        } else {
            println("더이상 탈수 없습니다.")
        }
        return currentTakeUnit
    }

}

/**
 * Extension Function: Dropship의 상태 정보를 출력
 *
 * Kotlin 관용구:
 * - 클래스 내부 메서드 대신 extension function 사용
 * - 출력 로직과 비즈니스 로직 분리
 * - DSL처럼 자연스러운 API 제공
 */
fun Dropship.showInfo() {
    val pos = getCurrentPosition().getPointInfo()
    val marines = getMarineCount()
    println("Dropship pos : $pos, marines: $marines")
}
