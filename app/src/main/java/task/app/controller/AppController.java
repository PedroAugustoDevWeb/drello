package task.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import task.app.models.User;



@Controller
public class AppController {

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/cadastro")
    public String Cad() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String PostCad(@ModelAttribute User user) {

        System.out.println(user.getName());

        System.out.println(user.getPassword());

        System.out.println(user.getEmail());

        return "cadastro";
    }

    



    
}
