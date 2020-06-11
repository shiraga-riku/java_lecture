package jp.co.aivick.demo.controller.admin;

import java.util.List;
import jp.co.aivick.demo.entity.User;
import jp.co.aivick.demo.form.UserForm;
import jp.co.aivick.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String list(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "admin/users/list";
    }
}
