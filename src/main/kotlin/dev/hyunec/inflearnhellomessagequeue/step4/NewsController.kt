package dev.hyunec.inflearnhellomessagequeue.step4

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class NewsController(private val newsPublisher: NewsPublisher) {
    private val log = KotlinLogging.logger {}

    @MessageMapping("/subscribe")
    fun handleSubscribe(@Header("newsType") newsType: String) {
        log.info { "[#] subscribe: $newsType" }

        val newsMessage = newsPublisher.publish(newsType)
        log.info { "[#] subscribe: $newsMessage" }
    }
}
