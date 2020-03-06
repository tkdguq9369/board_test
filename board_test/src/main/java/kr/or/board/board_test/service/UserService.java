package kr.or.board.board_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.board_test.mapper.UserMapper;
import kr.or.board.board_test.vo.User;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	// 아이디 중복확인처리
	public boolean idCheck(String uId) {

		User u = userMapper.idCheck(uId);
		boolean idExist = false;
		if (u == null) {
			return idExist; // id가 없으면 false 리턴
		} else {
			idExist = true;
			return idExist; // id가 있으면 true 리턴
		}

	}

	// 회원 가입 처리
	public void signUp(User user) {
		userMapper.signUp(user);
	}

	// DB 아이디 비밀번호 일치 확인후 로그인 처리로.
	public boolean userCheck(String uId, String uPw) {
		User u = userMapper.userCheck(uId, uPw);
		boolean idpw = true;
		if(u == null) { // id pw 일치하지 않음
			idpw = false;
			return idpw;
		}else { //id pw 일치
			return idpw;
		}
	}

	// 로그인 처리
	public User userLogin(String uId, String uPw) {
		return userMapper.userLogin(uId, uPw);
	}
}
