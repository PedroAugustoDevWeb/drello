package task.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.app.AppApplication;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import task.app.models.User;
import task.app.repository.UserRepository;

@Service
public class UserService {



    @Autowired 
    private UserRepository userRepository;



    public void createUser(User user) {

        if ( userRepository.findByEmail(user.getEmail()) != null) {

            throw new RuntimeException("email ja no sistema");

        }

        User user2 = new User();

        user2.setName(user.getName());

        user2.setEmail(user.getEmail());

        user2.setPassword(user.getPassword());

        userRepository.save(user2);



    }

    public Object loginUser(String email, String password, HttpServletResponse response) {

        if (userRepository.findByEmail(email) == null) {

            throw new RuntimeException("usuario não encontrado");

        }

        User user = userRepository.findByEmail(email);

        if (password.equals(user.getPassword()) != true) {

            throw new RuntimeException("senha errrada");

        }

        Cookie cookie = new Cookie("email", user.getEmail());
        
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 30);

        response.addCookie(cookie);

        return user;

    }    
}
