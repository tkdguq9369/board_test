package kr.or.board.board_test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.board_test.vo.Board;

@Mapper
public interface BoardMapper {

	// 보드 리스트 전체를 가져온다.
	public List<Board> getBoardList();
}
