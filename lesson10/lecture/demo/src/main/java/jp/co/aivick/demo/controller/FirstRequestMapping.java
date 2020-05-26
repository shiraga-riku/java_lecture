package jp.co.aivick.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requestmapping")
public class FirstRequestMapping
{
    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "Hello, world";
    }

    @RequestMapping(value = "/nest", method = RequestMethod.GET)
    public String nest() {
        return "nest mapping";
    }

    @GetMapping("/getmapping")
    public String nest2() {
        return "nest mapping2";
    }
}
