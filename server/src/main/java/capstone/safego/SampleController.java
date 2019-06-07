package capstone.safego;

import capstone.safego.model.Board;
import capstone.safego.model.Comment;
import capstone.safego.repository.BoardRepository;
import capstone.safego.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SampleController {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/board")
    public ModelAndView getTitles() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Board> boardList = boardRepository.findAll();
        modelAndView.addObject("title", "첫 화면");
        modelAndView.addObject("list", boardList);
        return modelAndView;
    }

    @GetMapping("/content/{board_id}")
    public ModelAndView getContent(@PathVariable Integer board_id) {
        ModelAndView modelAndView = new ModelAndView("content");
        Board board = boardRepository.findById(board_id).get();
//        List<Comment> commentList = commentRepository.findAllByboardId(board_id);
        modelAndView.addObject("title", "게시글 보기");
        modelAndView.addObject("contentTitle", board.getTitle());
        modelAndView.addObject("content", board.getContent());
        modelAndView.addObject("list", board.getCommentList());
        return modelAndView;
    }
}




