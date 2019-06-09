package capstone.safego.repository;

import capstone.safego.model.Board;
import org.springframework.beans.factory.annotation.Autowired;

public interface RepositoryService {

    Board addBoard(Board board);
}
