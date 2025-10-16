package com.bible.ch04.examples.BasicOOP.Encapsulations

class TeamCollaborationExample {
    companion object {
        fun demonstrate() {
            println("\n" + "=".repeat(60))
            println("팀 협업 효율성")
            println("=".repeat(60))

            println("""
                캡슐화의 장점:

                1. 명확한 계약:
                   - 팀 A: BankAccount 클래스 개발
                   - 팀 B: deposit(), withdraw(), getBalance() 메서드만 사용
                   - 팀 A가 내부 구현을 바꿔도 팀 B 코드는 영향 없음

                2. 실수 방지:
                   - balance를 직접 수정하는 실수 방지
                   - 모든 변경이 검증을 거침

                3. 유지보수 용이:
                   - 로깅 추가: deposit/withdraw 메서드만 수정
                   - 검증 강화: 메서드 내부만 수정
                   - DB 연동: 메서드 내부만 수정
                   → 외부 코드는 전혀 영향 받지 않음
            """.trimIndent())
        }
    }
}