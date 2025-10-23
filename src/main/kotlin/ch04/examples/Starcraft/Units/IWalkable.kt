package com.bible.ch04.examples.Starcraft.Units

/**
 * IWalkable - "be able to walk" (걸을 수 있다)
 *
 * IMovable을 상속하는 인터페이스
 * 땅으로 걸어다니는 유닛의 능력
 *
 * 특징:
 * - 지상 유닛
 * - 상대적으로 빠른 이동속도
 */
interface IWalkable : IMovable {
    // IMovable의 moveTo()를 상속
    // 구현 클래스에서 "걷기" 방식으로 구현
}
