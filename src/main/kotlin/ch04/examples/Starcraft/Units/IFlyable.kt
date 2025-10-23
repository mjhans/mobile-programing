package com.bible.ch04.examples.Starcraft.Units

/**
 * IFlyable - "be able to fly" (날 수 있다)
 *
 * IMovable을 상속하는 인터페이스
 * 하늘을 날아다니는 유닛의 능력
 *
 * 특징:
 * - 공중 유닛
 * - 상대적으로 느린 이동속도 (예: Dropship)
 * - 지형 무시 가능
 */
interface IFlyable : IMovable {
    // IMovable의 moveTo()를 상속
    // 구현 클래스에서 "비행" 방식으로 구현
}
