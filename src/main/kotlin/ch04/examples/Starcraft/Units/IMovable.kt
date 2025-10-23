package com.bible.ch04.examples.Starcraft.Units

import com.bible.ch04.examples.Starcraft.Util.Point

/**
 * IMovable - "be able to move" (이동할 수 있다)
 *
 * 능력(Capability)을 표현하는 인터페이스
 * 모든 이동 가능한 유닛이 구현해야 함
 */
interface IMovable {
    /**
     * 지정된 좌표로 이동
     * @param x 목표 x 좌표
     * @param y 목표 y 좌표
     * @return 이동한 좌표
     */
    fun moveTo(x: Int, y: Int): Point
}
