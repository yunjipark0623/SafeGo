package capstone.safego.vo;

import capstone.safego.model.Board;
import capstone.safego.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentVO {
    private Board board;
    private List<Comment> commentList;
}
