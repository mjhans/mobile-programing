package com.bible.ch04.examples.Starcraft.Units

import com.bible.ch04.examples.Starcraft.Util.Point

/**
 * AbstractUnit - 모든 유닛의 추상 클래스
 *
 * "is a kind of Unit" (유닛의 일종이다)
 *
 * 책임:
 * - 모든 유닛의 공통 속성만 관리 (current, hp)
 * - 이동(moveTo), 공격(attack)은 인터페이스로 분리
 *
 * 공통 속성:
 * - current: 현재 위치
 * - hp: 체력
 *
 * Interface Segregation Principle (ISP) 적용:
 * - IMovable: 이동 능력
 * - IAttackable: 공격 능력 (선택적)
 */
abstract class AbstractUnit(
    protected var current: Point,
    initHP: Int
) : IUnit {
    protected var hp: Int = 0

    init {
        setHP(initHP)
    }

    /**
     * HP 설정 (누적 방식)
     * @param hp 추가할 HP
     */
    fun setHP(hp: Int) {
        this.hp += hp
    }

    /**
     * 현재 위치 반환 (public으로 접근 허용)
     */
    fun getCurrentPosition(): Point = current
}
