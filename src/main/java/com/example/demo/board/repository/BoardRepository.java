//package com.example.demo.board.repository;
//
//import com.example.demo.board.entity.Board;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface BoardRepository extends JpaRepository<Board, Long> {
//    List<Board> findByBoardIdAndWriter(Long boardId, String writer);
//
//    Long countBy();
//
//    Board findFirstByOrderByBoardIdDesc();
//}