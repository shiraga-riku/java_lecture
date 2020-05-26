package jp.co.aivick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/firstform")
public class FirstFormController
{
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {

        model.addAttribute("num1", 0);
        model.addAttribute("num2", 0);
        model.addAttribute("sum", 0);

        return "form.html";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String request(@RequestParam Integer num1, @RequestParam Integer num2, Model model) {

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("sum", num1 + num2);

        return "form.html";
    }
}
