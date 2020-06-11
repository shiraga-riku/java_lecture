package jp.co.aivick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/top")
public class TopController
{
    @RequestMapping
    public String show() {
        return "top";
    }
}
