package com.bible.ch04.examples.BasicOOP.Polymorphism.Impl
import  com.bible.ch04.examples.BasicOOP.Polymorphism.*

// 또 다른 새로운 요구사항: 슬랙 메시지
class SlackSender : INotificationSender {
    override fun send(message: String, recipient: String) {
        println("[SLACK] Channel: $recipient")
        println("        Message: $message")
        println("        ✅ 슬랙 메시지 전송 완료")
    }
}