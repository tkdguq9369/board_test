package kr.or.board.board_test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.board_test.vo.Board;

@Mapper
public interface BoardMapper {

	// 보드 리스트 전체를 가져온다.
	public List<Board> getBoardList();
	
	// 보드 리스트 전체를 가져온다. (pageNum, listNum)
	public List<Board> getBoardList(String pageNum, String listNum);
	
	// 보드 게시글 한개를 가져온다.
	public Board getBoardContent(String bCode);
	
	// 보드 게시글 한개를 제거한다.
	public void delContent(String bCode);
	
	// 게시글 등록하기.
	public void contentWrite(Board board);
}
