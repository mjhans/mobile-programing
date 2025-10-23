package com.bible.ch04.examples.BasicOOP.Polymorphism

import com.bible.ch04.examples.BasicOOP.Polymorphism.Impl.*
import com.bible.ch04.examples.BasicOOP.Polymorphism.Clients.*

fun main(){
    // 다양한 알림 전송 방식
    val emailSender = EmailSender()
    val smsSender = SmsSender()
    val pushSender = PushNotificationSender()
    val slackSender = SlackSender()

    println("1. 단일 알림 전송:")
    emailSender.send("회원가입을 환영합니다!", "user@example.com")

    println("\n2. 여러 채널로 동시 알림:")
    val notificationService = NotificationService(
        listOf(emailSender, smsSender, slackSender, pushSender),
    )
    notificationService.notifyAll("alert",
        recipients = listOf("user@example.com", "#general")
    )
}
