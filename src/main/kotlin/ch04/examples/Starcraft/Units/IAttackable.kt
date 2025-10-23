package com.bible.ch04.examples.Starcraft.Units

/**
 * IAttackable - "be able to attack" (공격할 수 있다)
 *
 * 능력(Capability)을 표현하는 인터페이스
 * 공격 가능한 유닛이 구현해야 함
 *
 * 주의:
 * - Dropship은 이 인터페이스를 구현하지 않음 (공격 불가)
 * - Marine은 이 인터페이스를 구현 (공격 가능)
 */
interface IAttackable {
    /**
     * 공격 수행
     */
    fun attack()
}
