package dev.hyunec.inflearnhellomessagequeue.step1

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

//@RestController
@RequestMapping("/api/messages")
class MessageController(private val sender: Sender) {
    @PostMapping("/send")
    fun sendMessage(@RequestBody message: String): String {
        sender.send(message)
        return "[#] Message sent successfully! $message"
    }
}
