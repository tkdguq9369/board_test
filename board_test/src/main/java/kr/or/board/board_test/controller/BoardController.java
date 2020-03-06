package kr.or.board.board_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.board.board_test.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("board", boardService.getBoardList());
		System.out.println(boardService.getBoardList());
		return "board/boardList";
	}
}
