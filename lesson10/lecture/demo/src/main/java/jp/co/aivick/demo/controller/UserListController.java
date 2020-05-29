package jp.co.aivick.demo.controller;

import java.util.List;
import jp.co.aivick.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserListController
{
    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {

        List<User> users = List.of(
            new User("taro", 25),
            new User("hanako", 30),
            new User("ichiro", 40),
            new User("jon", 28),
            new User("takeru", 35)
        );

        model.addAttribute("users", users);

        return "users.html";
    }
}
