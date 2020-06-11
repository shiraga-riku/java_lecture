package jp.co.aivick.demo.controller.admin;

import groovy.transform.Generated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminTopController")
@RequestMapping("/admin/top")
public class TopController
{
    @RequestMapping
    public String show() {
        return "admin/top";
    }
}
