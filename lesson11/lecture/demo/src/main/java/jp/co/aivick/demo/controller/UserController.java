package jp.co.aivick.demo.controller;

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
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String list(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "users/list.html";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "users/create.html";
    }

    @PostMapping("/create")
    public String create(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "users/create.html";
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        User createdUser = userService.create(user);

        return "redirect:/users/update/" + createdUser.getId();
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") String id, Model model) {
        User user = userService.findBy(id);
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setName(user.getName());
        userForm.setEmail(user.getEmail());
        model.addAttribute("userForm", userForm);
        return "users/update.html";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, @Validated UserForm userForm,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/update.html";
        }

        User user = userService.findBy(id);
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());

        return "redirect:/users/update/" + id;
    }
}
