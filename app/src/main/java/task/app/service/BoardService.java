package task.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import task.app.models.Board;
import task.app.models.User;
import task.app.repository.BoardRepository;
import task.app.repository.UserRepository;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

public void newBoard(String name, String desc, String email) {
    // Criação de um novo quadro
    Board board = new Board();
    board.setName(name);
    board.setDescription(desc);

    // Encontrar o usuário pelo e-mail
    User user = userRepository.findByEmail(email);
    if (user == null) {
        throw new EntityNotFoundException("Usuário com e-mail " + email + " não encontrado.");
    }

    board.setOwner(user);

    user.getBoards().add(board);

    board.getUsers().add(user);

    boardRepository.save(board);

    userRepository.save(user);
}


}
