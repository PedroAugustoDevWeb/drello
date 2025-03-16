package task.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import task.app.models.Board;
import task.app.repository.BoardRepository;
import task.app.repository.UserRepository;
import task.app.service.BoardService;

@Controller
public class FunController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;


    @PostMapping("/new/board")
    public String PostLista(@CookieValue(name = "email") String email, @ModelAttribute Board board) {

        boardService.newBoard(board.getName(), board.getDescription(), email);
        
        return "redirect:/das";
    }

    @GetMapping("/board/{id}")
    public String board(@PathVariable Long id, Model model) {

        model.addAttribute("board", boardRepository.findById(id).get());

        model.addAttribute("columns", boardRepository.findById(id).get().getColumns());

        return "board";
        
    }
    
}
