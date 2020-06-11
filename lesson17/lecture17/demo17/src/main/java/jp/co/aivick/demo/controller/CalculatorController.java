package jp.co.aivick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calculator")
class CalculatorController
{
    @RequestMapping
    public String show() {
        return "calculator.html";
    }

    @GetMapping("/calc")
    @ResponseBody
    public Integer calculate(@RequestParam Integer num1, @RequestParam Integer num2) {
        return num1 + num2;
    }
}
