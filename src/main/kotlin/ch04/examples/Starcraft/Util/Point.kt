package com.bible.ch04.examples.Starcraft.Util

/**
 * Point - 좌표를 나타내는 클래스
 *
 * Data class 특징:
 * - val로 불변 좌표 (게임에서 위치는 값 객체)
 * - equals, hashCode, toString 자동 생성
 * - copy() 메서드 자동 생성
 *
 * 기본값 (0, 0) 지원
 */
data class Point(val x: Int = 0, val y: Int = 0)

/**
 * Extension Function: Point의 정보를 문자열로 반환
 *
 * Kotlin 관용구:
 * - 클래스 내부 메서드 대신 extension function 사용
 * - 더 유연하고 재사용 가능
 *
 * @return "(x, y)" 형식의 문자열
 */
fun Point.getPointInfo(): String = "($x, $y)"
