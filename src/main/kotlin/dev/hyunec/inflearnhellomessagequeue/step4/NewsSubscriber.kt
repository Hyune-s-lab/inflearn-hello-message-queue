package dev.hyunec.inflearnhellomessagequeue.step4

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class NewsSubscriber(private val messagingTemplate: SimpMessagingTemplate) {
    @RabbitListener(queues = [RabbitMQConfig.JAVA_QUEUE])
    fun javaNews(message: String) {
        messagingTemplate.convertAndSend("/topic/java", message) // 뉴스 브로드캐스트
    }

    @RabbitListener(queues = [RabbitMQConfig.SPRING_QUEUE])
    fun springNews(message: String) {
        messagingTemplate.convertAndSend("/topic/spring", message) // 기술 뉴스 브로드캐스트
    }

    @RabbitListener(queues = [RabbitMQConfig.VUE_QUEUE])
    fun vueNews(message: String) {
        messagingTemplate.convertAndSend("/topic/vue", message) // 일반 뉴스 브로드캐스트
    }
}
