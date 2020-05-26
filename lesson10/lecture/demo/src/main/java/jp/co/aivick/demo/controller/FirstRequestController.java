package jp.co.aivick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstRequestController
{
    @GetMapping("/firstrequest")
    public String request(@RequestParam String name, @RequestParam String weight, Model model) {

        model.addAttribute("name", name);
        model.addAttribute("weight", weight);

        return "request.html";
    }
}
