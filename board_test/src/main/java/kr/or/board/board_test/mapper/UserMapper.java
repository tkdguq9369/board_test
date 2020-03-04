package kr.or.board.board_test.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.board_test.vo.User;

@Mapper
public interface UserMapper {

	//아이디 중복확인처리
	public User idCheck(String uId);
}
