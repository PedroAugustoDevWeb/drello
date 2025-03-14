package task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.app.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    
}
