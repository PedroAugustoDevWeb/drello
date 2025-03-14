package task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.app.models.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

    
}
