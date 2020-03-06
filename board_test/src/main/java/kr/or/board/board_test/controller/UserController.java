package kr.or.board.board_test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	/* 로그인 페이지로 이동 */
	@GetMapping("/userLogin")
	public String login() {
		return "user/userLogin";
	}

	/* 로그인 폼 */
	@PostMapping("/userLogin")
	public String loginPro(@RequestParam(value = "uId") String uId, @RequestParam(value = "uPw") String uPw,
			HttpSession session) {
		User u = userService.userLogin(uId, uPw);
		session.setAttribute("SNICK", u.getuNick());
		return "index";
	}

	/* 회원가입 페이지로 이동 */
	@GetMapping("/signUp")
	public String signUp() {
		return "user/signUp";
	}

	/* 회원가입 폼 */
	@PostMapping("/signUp")
	public String signUpPro(User user) {
		return "/";
	}

	/* ajax 아이디 중복확인 */
	@PostMapping("/duplicateCheck")
	public @ResponseBody boolean duplicateCheck(@RequestParam(value = "uId") String uId) {
		boolean idExist = userService.idCheck(uId);
		return idExist;
	}

	/* ajax db 아이디 있는지 확인 */
	@PostMapping("/idCheck")
	public @ResponseBody boolean idCheck(@RequestParam(value = "uId") String uId,
			@RequestParam(value = "uPw") String uPw) {
		System.out.println(uId + " " + uPw);
		boolean idpw = userService.userCheck(uId, uPw);
		return idpw;
	}
	
	
	/* 유저 로그아웃 */
	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}
