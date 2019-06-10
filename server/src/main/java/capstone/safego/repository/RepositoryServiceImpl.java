package capstone.safego.repository;

import capstone.safego.model.Board;
import capstone.safego.model.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

//    생성자
    public RepositoryServiceImpl() {

    }

    @Override
    public Board addBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Comment addComment(Comment comment) { return commentRepository.save(comment); }
}
