package com.bible.ch04.examples.BasicOOP.Polymorphism

// ============================================
// 공통 인터페이스
// ============================================

interface INotificationSender {
    fun send(message: String, recipient: String)
}
