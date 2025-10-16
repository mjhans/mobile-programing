package com.bible.ch04.examples.BasicOOP.Encapsulations

class BankAccount (initialBalance: Double) {
    // private: 외부에서 직접 접근 불가 - 내부 구현 은닉
    private var balance = initialBalance
    private val transactionHistory = mutableListOf<String>()

    // public: 외부에 제공하는 안전한 인터페이스
    fun deposit(amount: Double) {
        require(amount > 0) { "입금액은 양수여야 합니다" }

        balance += amount
        val transaction = "입금: ${amount}원 (잔액: ${balance}원)"
        transactionHistory.add(transaction)

        println("✅ $transaction")
    }

    fun withdraw(amount: Double): Boolean {
        require(amount > 0) { "출금액은 양수여야 합니다" }

        return if (amount <= balance) {
            balance -= amount
            val transaction = "출금: ${amount}원 (잔액: ${balance}원)"
            transactionHistory.add(transaction)

            println("✅ $transaction")
            true
        } else {
            println("❌ 출금 실패: 잔액 부족 (현재 잔액: ${balance}원)")
            false
        }
    }

    fun getBalance(): Double = balance

    fun printTransactionHistory() {
        println("\n[거래 내역]")
        if (transactionHistory.isEmpty()) {
            println("  거래 내역이 없습니다")
        } else {
            transactionHistory.forEachIndexed { index, transaction ->
                println("  ${index + 1}. $transaction")
            }
        }
    }

    // 내부 구현을 자유롭게 변경 가능
    // 예: 거래 내역을 DB에 저장, 로깅 추가, 검증 로직 강화 등
    // 외부 코드(deposit, withdraw, getBalance 사용하는 코드)는 영향 받지 않음
}