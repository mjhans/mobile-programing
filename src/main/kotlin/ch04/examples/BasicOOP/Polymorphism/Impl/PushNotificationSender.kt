package com.bible.ch04.examples.BasicOOP.Polymorphism.Impl

import  com.bible.ch04.examples.BasicOOP.Polymorphism.*

// 새로운 요구사항: 푸시 알림 추가
class PushNotificationSender : INotificationSender {
    override fun send(message: String, recipient: String) {
        println("[PUSH] To: $recipient")
        println("       Notification: $message")
        println("       ✅ 푸시 알림 전송 완료")
    }
}