package capstone.safego.repository;

import capstone.safego.model.Board;
import capstone.safego.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

public interface RepositoryService {

    Board addBoard(Board board);

    Comment addComment(Comment comment);
}
