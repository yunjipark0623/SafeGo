package capstone.safego.repository;

import capstone.safego.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository를 사용하는 이유: 개발자가 반복적인 CRUD를 안해도 된다.
public interface BoardRepository extends JpaRepository<Board, Integer> {
//    Board save(Board board);

    public default Board addBoard(Board board) {
        return save(board);
    }
}




