package capstone.safego.repository;

import capstone.safego.model.Board;
import capstone.safego.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByboardId(Integer board_id);

    public default Comment addComment (Comment comment) {
        return save(comment);
    }
}




