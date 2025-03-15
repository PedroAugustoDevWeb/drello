package task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.app.models.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);    
}
