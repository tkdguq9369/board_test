package kr.or.board.board_test.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.board.board_test.vo.User;

@Mapper
public interface UserMapper {

	//아이디 중복확인처리
	public User idCheck(String uId);
	
	//회원 가입 처리
	public void signUp(User user);
	
	//DB 아이디 비밀번호 일치 확인후 로그인 처리로.
	public User userCheck(String uId, String uPw);
	
	//로그인 처리
	public User userLogin(String uId, String uPw);
}
