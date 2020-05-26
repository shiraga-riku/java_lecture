package jp.co.aivick.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstSpringBoot
{
    @GetMapping("/firstsb")
    public String hello() {
        return "Hello, world";
    }
}
