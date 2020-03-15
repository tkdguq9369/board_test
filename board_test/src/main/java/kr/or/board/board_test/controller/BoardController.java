package kr.or.board.board_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.board.board_test.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/boardList")
	public String boardList(@RequestParam(value = "pageNum", required = false)String pageNum ,Model model) {
		System.out.println(pageNum + " <== pageNum");
		model.addAttribute("board", boardService.getBoardList());
		return "board/boardList";
	}
	
	@GetMapping("/boardContent")
	public String boardContent(@RequestParam(value = "bCode") String bCode, Model model) {
		model.addAttribute("content", boardService.getBoardContent(bCode));
		return "board/boardContent";
	}
}
