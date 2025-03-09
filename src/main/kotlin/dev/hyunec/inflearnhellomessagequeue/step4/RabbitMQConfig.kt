package dev.hyunec.inflearnhellomessagequeue.step4

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {
    @Bean
    fun javaQueue(): Queue {
        return Queue(JAVA_QUEUE, false)
    }

    @Bean
    fun springQueue(): Queue {
        return Queue(SPRING_QUEUE, false)
    }

    @Bean
    fun vueQueue(): Queue {
        return Queue(VUE_QUEUE, false)
    }

    @Bean
    fun fanoutExchange(): FanoutExchange {
        // 메시지를 수신하면 연결된 모든 큐로 브로드캐스트
        return FanoutExchange(FANOUT_EXCHANGE_FOR_NEWS)
    }

    @Bean
    fun javaBinding(javaQueue: Queue, fanoutExchange: FanoutExchange): Binding {
        return BindingBuilder.bind(javaQueue).to(fanoutExchange)
    }

    @Bean
    fun springBinding(springQueue: Queue, fanoutExchange: FanoutExchange): Binding {
        return BindingBuilder.bind(springQueue).to(fanoutExchange)
    }

    @Bean
    fun vueBinding(vueQueue: Queue, fanoutExchange: FanoutExchange): Binding {
        return BindingBuilder.bind(vueQueue).to(fanoutExchange)
    }

    companion object {
        // step4 예제 추가
        const val FANOUT_EXCHANGE_FOR_NEWS: String = "newsExchange"

        const val JAVA_QUEUE: String = "javaQueue"
        const val SPRING_QUEUE: String = "springQueue"
        const val VUE_QUEUE: String = "vueQueue"
    }
}
