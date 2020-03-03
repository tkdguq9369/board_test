package kr.or.board.board_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.board_test.mapper.UserMapper;

@Service
public class UserService {
	@Autowired UserMapper userMapper;
	
}
