package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Service.UserService;
import Entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Accueil");
        model.addAttribute("message", "Bienvenue sur notre site !");
        return "index";
    }
}