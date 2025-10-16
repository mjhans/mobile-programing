package com.bible.ch04.examples.BasicOOP.Polymorphism.Impl

import com.bible.ch04.examples.BasicOOP.Polymorphism.*

class EmailSender : INotificationSender {
    override fun send(message: String, recipient: String) {
        println("[EMAIL] To: $recipient")
        println("        Subject: 알림")
        println("        Body: $message")
        println("        ✅ 이메일 전송 완료")
    }
}