package capstone.safego.repository;

import capstone.safego.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//JpaRepository를 사용하는 이유: 개발자가 반복적인 CRUD를 안해도 된다.
public interface BoardRepository extends JpaRepository<Board, Integer> {

    public default Board addBoard(Board board) {
        return save(board);
    }

//    @Override
//    Optional<Board> findById(Integer board_id);
//    Optional<Board> findByboardId(Integer board_id);
}




