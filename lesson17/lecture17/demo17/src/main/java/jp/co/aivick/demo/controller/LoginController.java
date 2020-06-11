package jp.co.aivick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController
{
    @RequestMapping
    public String showLoginForm() {
        return "login";
    }
}
