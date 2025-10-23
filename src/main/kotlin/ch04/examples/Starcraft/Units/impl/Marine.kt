package com.bible.ch04.examples.Starcraft.Units.impl

import com.bible.ch04.examples.Starcraft.Units.AbstractUnit
import com.bible.ch04.examples.Starcraft.Units.IAttackable
import com.bible.ch04.examples.Starcraft.Units.IWalkable
import com.bible.ch04.examples.Starcraft.Util.Point
import com.bible.ch04.examples.Starcraft.Util.getPointInfo

/**
 * Marine - 원거리 보병 유닛
 *
 * "is a kind of Unit" + "be able to walk" + "be able to attack"
 *
 * 특징:
 * - 땅과 하늘 모두 공격 가능 (IAttackable)
 * - 이동속도가 Dropship보다 빠름
 * - 땅으로 걸어다님 (IWalkable)
 *
 * 구현:
 * - AbstractUnit: 공통 속성 (current, hp)
 * - IWalkable: 걷기 능력
 * - IAttackable: 공격 능력
 */
class Marine(current: Point, initHP: Int) :
    AbstractUnit(current, initHP), IWalkable, IAttackable {

    /**
     * 이동 구현 (IWalkable)
     * Marine의 빠른 걷기
     */
    override fun moveTo(x: Int, y: Int): Point {
        current = Point(x, y)
        println("Marine move to ${current.getPointInfo()}")
        return current
    }

    /**
     * 공격 구현 (IAttackable)
     * Marine의 원거리 공격
     */
    override fun attack() {
        println("marine shots!!")
    }
}
