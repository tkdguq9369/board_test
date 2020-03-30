package kr.or.board.board_test.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public String contentInsert(Board board, @RequestPart MultipartFile file) throws IOException {
		if (file.isEmpty()) { // 파일이 비어있다면 그대로 db등록
			boardService.contentWrite(board);
		} else { // 파일이 비어있지 않다면 ~ 다 처리후 등록
			String saveDir = "C:\\Users\\kim\\git\\board_test\\board_test\\src\\main\\resources\\static\\images\\";
			String fileName = file.getOriginalFilename(); // 게시판만들기.txt
			board.setbFileDir(saveDir + fileName); // board객체에 경로 setting
			board.setbFileName(fileName); // board객체에 파일 이름 setting
			File saveFile = new File(saveDir, fileName); // 경로와 파일명을 객체화
			FileCopyUtils.copy(file.getBytes(), saveFile);// 객체를 복사.
			boardService.contentWrite(board);
		}
		return "redirect:boardList";
	}
	
}
