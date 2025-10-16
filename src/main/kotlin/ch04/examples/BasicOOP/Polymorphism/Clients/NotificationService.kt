package com.bible.ch04.examples.BasicOOP.Polymorphism.Clients

import com.bible.ch04.examples.BasicOOP.Polymorphism.INotificationSender

// ============================================
// 클라이언트 코드는 수정 불필요
// ============================================
class NotificationService(private val senders: List<INotificationSender>) {
    fun notifyAll(message: String, recipients: List<String>) {
        println("\n[알림 전송 시작]")
        println("메시지: \"$message\"")
        println("수신자: ${recipients.joinToString(", ")}")
        println("-".repeat(60))

        recipients.forEach { recipient ->
            // 어떤 구현체든 동일하게 처리
            senders.forEach { sender ->
                sender.send(message, recipient)
                println()
            }
        }
    }

    fun notify(message: String, recipient: String, senderIndex: Int) {
        if (senderIndex in senders.indices) {
            senders[senderIndex].send(message, recipient)
        }
    }
}