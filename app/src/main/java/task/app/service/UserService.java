package task.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import task.app.models.User;
import task.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepository;




    public void createUser(User user) {

        if ( userRepository.findByEmail(user.getEmail()).size() != 0) {

            throw new RuntimeException("email ja no sistema");

        }

        User user2 = new User();

        user2.setName(user.getName());

        user2.setEmail(user.getEmail());

        user2.setPassword(user.getPassword());

        userRepository.save(user2);

    }

    public Object loginUser(String email, HttpServletResponse response) {

        User user = userRepository.findByEmail(email);



        return user;

    }    
}
