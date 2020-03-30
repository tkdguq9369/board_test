package kr.or.board.board_test.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.board.board_test.vo.User;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
		
	}
	
	
}
