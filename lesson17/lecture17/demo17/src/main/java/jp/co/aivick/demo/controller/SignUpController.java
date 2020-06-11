package jp.co.aivick.demo.controller;

import jp.co.aivick.demo.entity.User;
import jp.co.aivick.demo.form.UserForm;
import jp.co.aivick.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController
{
    @Autowired
    UserService userService;

    @GetMapping
    public String showSignup(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "signup/index";
    }

    @PostMapping
    public String register(@Validated UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup/index";
        }

        User user = new User();
        user.setPassword(userForm.getPassword());
        user.setLoginId(userForm.getLoginId());
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setRole("USER");
        User createdUser = userService.create(user);

        return "redirect:/login" + createdUser.getId();
    }
}
