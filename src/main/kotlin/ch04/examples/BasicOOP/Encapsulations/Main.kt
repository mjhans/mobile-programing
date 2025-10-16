package com.bible.ch04.examples.BasicOOP.Encapsulations

fun main() {
    println("=" .repeat(60))
    println("Encapsulation (캡슐화) - 데이터 은닉과 접근 제어")
    println("=" .repeat(60))

    // ============================================
    // 올바른 캡슐화 예제
    // ============================================
    println("\n[올바른 캡슐화 - BankAccount]")
    println("-".repeat(60))

    val account = BankAccount(10000.0)
    println("초기 잔액: ${account.getBalance()}원")

    println("\n[입금 테스트]")
    account.deposit(5000.0)
    account.deposit(3000.0)

    println("\n[출금 테스트]")
    account.withdraw(2000.0)
    account.withdraw(20000.0)  // 잔액 부족
    account.withdraw(5000.0)

    println("\n[현재 잔액]")
    println("잔액: ${account.getBalance()}원")

    // 거래 내역 출력
    account.printTransactionHistory()

    // ============================================
    // 캡슐화가 없는 경우 (문제점 시연)
    // ============================================
    println("\n" + "=".repeat(60))
    println("[캡슐화가 없는 경우 - UnsafeBankAccount]")
    println("-".repeat(60))

    val unsafeAccount = UnsafeBankAccount()
    unsafeAccount.balance = 10000.0
    println("초기 잔액: ${unsafeAccount.balance}원")

    println("\n문제점:")
    println("1. 검증 없이 직접 수정 가능:")
    unsafeAccount.balance = -5000.0  // 음수 잔액!
    println("   음수 잔액: ${unsafeAccount.balance}원")

    println("\n2. 실수로 잘못된 값 설정:")
    unsafeAccount.balance = 1000000000.0  // 터무니없는 값
    println("   비정상적인 잔액: ${unsafeAccount.balance}원")

    println("\n3. 거래 내역 추적 불가:")
    println("   언제, 얼마가 입출금되었는지 알 수 없음")

    // ============================================
    // 팀 협업 설명
    // ============================================
    TeamCollaborationExample.demonstrate()

    /*
    ============================================================
    캡슐화의 핵심
    ============================================================
    ✅ private으로 내부 구현 숨김
    ✅ public 메서드로 안전한 인터페이스 제공
    ✅ 검증 로직을 메서드 안에 구현
    ✅ 내부 구현 변경 시 외부 코드에 영향 없음
    ✅ 팀 협업 시 명확한 계약 제공

    ❌ 캡슐화 없으면:
    ❌ 외부에서 직접 수정 가능
    ❌ 검증 로직 우회 가능
    ❌ 실수와 버그 발생 쉬움
    ❌ 유지보수 어려움
     */
}
