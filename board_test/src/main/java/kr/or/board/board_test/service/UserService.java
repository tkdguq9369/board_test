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
		System.out.println(u);
		boolean idExist = false;
		if (u == null) {
			return idExist; // id가 없으면 false 리턴
		} else {
			idExist = true;
			return idExist;  // id가 있으면 true 리턴
		}

	}
}
