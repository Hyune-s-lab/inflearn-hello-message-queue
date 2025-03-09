package dev.hyunec.inflearnhellomessagequeue.step4

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/news/api")
class NewsRestController(private val newsPublisher: NewsPublisher) {
    @PostMapping("/publish")
    fun publishNews(@RequestParam newsType: String): String {
        val result = newsPublisher.publishAPI(newsType)
        return "# Message published to RabbitMQ: $result"
    }
}
