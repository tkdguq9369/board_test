package kr.or.board.board_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.board.board_test.service.BoardService;
import kr.or.board.board_test.vo.Board;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/boardList")
	public String boardList(@RequestParam(value = "pageNum", required = false) String pageNum,
			@RequestParam(value = "listNum", required = false) String listNum, Model model) {
		System.out.println(pageNum + " <== pageNum");
		System.out.println(listNum + " <== listNum");
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("listNum", listNum);

		if (pageNum == null && listNum == null) {
			model.addAttribute("board", boardService.getBoardList());
		} else {
			model.addAttribute("board", boardService.getBoardList(pageNum, listNum));
		}
		return "board/boardList";
	}

	@GetMapping("/boardContent")
	public String boardContent(@RequestParam(value = "bCode") String bCode, Model model) {
		model.addAttribute("content", boardService.getBoardContent(bCode));
		return "board/boardContent";
	}

	@PostMapping("/contentDel")
	public @ResponseBody String contentDel(@RequestParam(value = "bCode") String bCode) {
		boardService.delContent(bCode);
		return "게시글이 삭제되었습니다.";
	}

	@GetMapping("/boardWirte")
	public String boardWirte() {
		return "board/boardWirte";
	}

	@PostMapping("/boardWirte")
	public String contentInsert(Board board) {
		boardService.contentWrite(board);
		return "redirect:boardList";
	}

}
