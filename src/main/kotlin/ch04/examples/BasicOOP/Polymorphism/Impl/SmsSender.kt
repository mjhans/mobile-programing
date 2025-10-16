package com.bible.ch04.examples.BasicOOP.Polymorphism.Impl

import com.bible.ch04.examples.BasicOOP.Polymorphism.*

class SmsSender : INotificationSender {
    override fun send(message: String, recipient: String) {
        println("[SMS] To: $recipient")
        println("      Message: $message")
        println("      ✅ SMS 전송 완료")
    }
}
