package kr.or.board.board_test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.board_test.mapper.BoardMapper;
import kr.or.board.board_test.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	//리스트 전체 가져오기
	public List<Board> getBoardList() {
		List<Board> bl = boardMapper.getBoardList();
		return bl;
	}

}
