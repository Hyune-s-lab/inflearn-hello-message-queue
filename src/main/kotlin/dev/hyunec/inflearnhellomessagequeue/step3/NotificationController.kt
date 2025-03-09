package dev.hyunec.inflearnhellomessagequeue.step3

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

//@RestController
@RequestMapping("/notifications")
class NotificationController(private val publisher: NotificationPublisher) {
    @PostMapping
    fun sendNotification(@RequestBody message: String): String {
        publisher.publish(message)
        return "[#] Notification sent: $message\n"
    }
}
