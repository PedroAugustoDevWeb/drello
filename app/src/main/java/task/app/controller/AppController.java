package task.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import task.app.models.User;
import task.app.service.UserService;


@Controller
public class AppController {

    @Autowired
    private UserService userService;





    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, HttpServletResponse response) {

        userService.loginUser(user.getEmail(), response);

        return "login";

    }

    @GetMapping("/cadastro")
    public String Cad() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String PostCad(@ModelAttribute User user, Model model) {


        userService.createUser(user);

        return "redirect:/login";

    





    }

    



    
}
