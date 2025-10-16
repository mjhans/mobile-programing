package com.bible.ch04.examples.BasicOOP.Encapsulations

class UnsafeBankAccount {
    // 모든 것이 public - 외부에서 직접 수정 가능
    var balance: Double = 0.0

    // 문제점: 외부에서 balance를 직접 수정할 수 있음
    // account.balance = -1000.0  // 음수 잔액 가능!
    // account.balance += 1000000.0  // 검증 없이 변경 가능!
}