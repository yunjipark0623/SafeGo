package capstone.safego;

import capstone.safego.model.Board;
import capstone.safego.repository.BoardRepository;
import capstone.safego.repository.CommentRepository;
import capstone.safego.repository.RepositoryService;
//import capstone.safego.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SampleController {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Autowired
    private RepositoryService repositoryService;

//    첫 화면
    @GetMapping("/board")
    public ModelAndView getTitles() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Board> boardList = boardRepository.findAll();
//        Optional<Board> boardList = boardRepository.findAll();
        modelAndView.addObject("title", "첫 화면");
        modelAndView.addObject("list", boardList);
        return modelAndView;
    }

//    게시글 보기
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

//    게시글 쓰기
    @GetMapping("/write")
    public ModelAndView write() {
        ModelAndView modelAndView = new ModelAndView("write");
        modelAndView.addObject("title", "게시글 적기");
        return modelAndView;
    }

//    게시글 날리기
    @PostMapping("/insertContent")
    public String insertContent(@ModelAttribute Board board, Model model) {
        Board entity = repositoryService.addBoard(board);
        model.addAttribute("result", entity);
        return "result";
    }

//
//    @PostMapping(path = "/content", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public String postContent(@RequestBody Board board) {
//        System.out.println(board.getTitle());
//        boardRepository.save(board);
//        return "done";
//    }
}




