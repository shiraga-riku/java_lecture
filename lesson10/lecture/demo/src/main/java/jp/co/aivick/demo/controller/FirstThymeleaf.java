package jp.co.aivick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstThymeleaf
{
    @GetMapping("/firstthymeleaf")
    public String index() {
        return "thymeleaf.html";
    }
}
