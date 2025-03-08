package dev.hyunec.inflearnhellomessagequeue.step1

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate

//@Component
class Sender(
    private val rabbitTemplate: RabbitTemplate,
    rabbitMQConfig: RabbitMQConfig
) {
    private val log = KotlinLogging.logger {}
    private val queueName = rabbitMQConfig.queueName

    fun send(message: String) {
        val safeMessage = message
        rabbitTemplate.convertAndSend(queueName, safeMessage)
        log.info { "[#] Sent: $safeMessage" }
    }
}
