package task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
}
