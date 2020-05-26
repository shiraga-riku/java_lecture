package jp.co.aivick.demo.controller;

import java.util.List;
import javax.swing.DefaultBoundedRangeModel;
import jp.co.aivick.demo.model.User;
import jp.co.aivick.demo.service.DefaultUserService;
import jp.co.aivick.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/firstdi")
public class FirstDIContainer
{
    @Autowired
    private UserService userService;

    private DefaultUserService defaultUserService;

    @Autowired
    public FirstDIContainer(DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        List<User> users = this.userService.findAll();

        model.addAttribute("users", users);

        return "di.html";
    }

    @RequestMapping("/constructordi")
    public String users2(Model model) {
        List<User> users = this.defaultUserService.findAll();

        model.addAttribute("users", users);

        return "di.html";
    }
}
