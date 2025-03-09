package dev.hyunec.inflearnhellomessagequeue.step4

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("/home")
    fun home(model: Model): String {
        model.addAttribute("message", "Welcome to RabbitMQ Sample!")
        return "home" // src/main/resources/templates/home.html 파일을 찾음
    }

    @GetMapping("/news")
    fun news(model: Model): String {
        model.addAttribute("message", "Welcome to RabbitMQ News Sample!")
        return "news"
    }
}
