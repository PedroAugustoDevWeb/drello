package task.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.app.models.Lista;

public interface ListaRepository extends JpaRepository<Lista, Long> {

    
}
