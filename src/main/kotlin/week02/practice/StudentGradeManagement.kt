package com.bible.week02.practice
//
//// TODO: Student 클래스를 완성하세요
class Student(
    val name: String,
    val studentId: String,
    private var totalScore: Int = 0,  // 비공개: 직접 수정 방지
    private var subjectCount: Int = 0
) {

    // 성적 추가 (유효성 검사 포함)
    fun addScore(score: Int) {
        // 0-100 범위 검사 후 추가
        // 유효하면 totalScore에 더하고 subjectCount 증가
        // 무효하면 오류 메시지 출력
    }

    // 평균 점수 계산
    fun getAverageScore(): Double {
        // subjectCount가 0이면 0.0 반환
        // 아니면 평균 계산해서 반환
        return 0.0
    }

    // 등급 계산 (when 표현식 활용)
    fun getGradeLevel(): String {
        val average = getAverageScore()
        // 90 이상: "A", 80-89: "B", 70-79: "C", 60-69: "D", 60 미만: "F"
        return ""
    }

    // 장학금 대상 여부 (조건 없는 when 활용)
    fun getScholarshipStatus(): String {
        val average = getAverageScore()
        val subjects = subjectCount

        return when {
            // 평균 95 이상 + 과목 5개 이상: "전액 장학금"
            // 평균 90 이상 + 과목 3개 이상: "반액 장학금"
            // 평균 85 이상: "성적 우수상"
            // 그 외: "해당 없음"

            else -> {""}
        }
    }

    // 학습 진행 상황 리포트
    fun getProgressReport(): String {
        // "[이름] ([학번]): 평균 [점수], 등급 [등급], [장학금상태]"
        // 형태로 반환
        return ""
    }
}

fun main() {
    val student = Student("김코틀린", "2024001")

    // 성적 추가
    student.addScore(95)
    student.addScore(87)
    student.addScore(92)
    student.addScore(88)
    student.addScore(93)

    // 잘못된 성적 시도
    student.addScore(105)  // 오류 메시지 출력
    student.addScore(-10)  // 오류 메시지 출력

    // 결과 출력
    println("평균: ${student.getAverageScore()}")
    println("등급: ${student.getGradeLevel()}")
    println("장학금: ${student.getScholarshipStatus()}")
    println("전체 리포트: ${student.getProgressReport()}")
}