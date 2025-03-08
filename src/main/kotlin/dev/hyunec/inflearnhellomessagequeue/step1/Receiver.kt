package dev.hyunec.inflearnhellomessagequeue.step1

import io.github.oshai.kotlinlogging.KotlinLogging

//@Component
class Receiver {
    private val log = KotlinLogging.logger {}

    fun receiveMessage(message: String) {
        log.info { "[#] Received: $message" }
    }
}
