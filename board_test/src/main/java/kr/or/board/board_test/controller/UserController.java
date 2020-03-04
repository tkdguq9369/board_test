package kr.or.board.board_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.board.board_test.service.UserService;
import kr.or.board.board_test.vo.User;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/userLogin")
	public String login() {
		return "userLogin";
	}

	@PostMapping("/userLogin")
	public String loginPro(User user) {
		return "";
	}

	@PostMapping("/duplicateCheck")
	public @ResponseBody boolean duplicateCheck(@RequestParam(value = "uId") String uId) {
		boolean idExist = userService.idCheck(uId);
		return idExist;
	}
}
