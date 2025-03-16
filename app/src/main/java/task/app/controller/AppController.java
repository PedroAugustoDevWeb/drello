package task.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import task.app.models.User;
import task.app.repository.UserRepository;
import task.app.service.UserService;


@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;





    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String email, @RequestParam String password, HttpServletResponse response) {

        System.out.println(email);

        System.out.println(password);

        userService.loginUser(email, password , response);

        return "redirect:/das";

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

    @GetMapping("/das")
    public String das(@CookieValue(name = "email", defaultValue = "null") String email, Model model) {


        User user = userRepository.findByEmail(email);

        model.addAttribute("user", user);

        model.addAttribute("boards", user.getBoards());

        return "das";

    }

    



    
}
