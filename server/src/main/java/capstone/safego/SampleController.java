package capstone.safego;

import capstone.safego.model.Board;
import capstone.safego.model.Comment;
import capstone.safego.repository.BoardRepository;
import capstone.safego.repository.CommentRepository;
import capstone.safego.repository.RepositoryService;
//import capstone.safego.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SampleController {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Autowired
    private RepositoryService repositoryService;
//    private Integer board_id;
    private Board board;

    //    첫 화면
    @GetMapping("/board")
    public ModelAndView getTitles() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Board> boardList = boardRepository.findAll();
//        Optional<Board> boardList = boardRepository.findAll();
        modelAndView.addObject("title", "첫 화면");
        modelAndView.addObject("list", boardList);
//        modelAndView.addObject("link", "content/" + board_id);
        return modelAndView;
    }

//    게시글 보기
    @GetMapping("/content/{board_id}")
    public ModelAndView getContent(@PathVariable Integer board_id) {
        ModelAndView modelAndView = new ModelAndView("content");
        Board board = boardRepository.findById(board_id).get();
//        List<Comment> commentList = commentRepository.findAllByboardId(board_id);
        modelAndView.addObject("boardId", board_id);
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
    public ModelAndView insertContent(@ModelAttribute Board board) {
        Board entity = repositoryService.addBoard(board);
        ModelAndView modelAndView = new ModelAndView("index");
        List<Board> boardList = boardRepository.findAll();
        modelAndView.addObject("title", "첫 화면");
        modelAndView.addObject("list", boardList);
//        modelAndView.addObject("link", )
        return modelAndView;
//        model.addAttribute("result", entity);
//        return "result";
    }

    @PostMapping("/insertComment")
    public String insertComment(@RequestParam Integer board_id, @RequestParam String content, Model model) {
        Comment comment = Comment.builder()
                .content(content)
                .board(boardRepository.findById(board_id).get())
                .build();
        Comment entity = repositoryService.addComment(comment);
        model.addAttribute("commentResult", entity);
        return "redirect:/content/" + board_id;
    }
}




