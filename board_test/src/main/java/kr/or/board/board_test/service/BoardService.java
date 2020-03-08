package kr.or.board.board_test.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.board_test.mapper.BoardMapper;
import kr.or.board.board_test.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	//리스트 전체 가져오기
	public List<Board> getBoardList() {
		List<Board> bl = boardMapper.getBoardList();
		String date = "";
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date ymdTime = new Date();
		String today = format1.format(ymdTime).substring(0,10); // ex 2020-03-03 현재날짜를 뽑을것.
		
		String ymd = "";	// 연, 월, 일이 저장될곳
		String time = "";	// 시간이 저장될 곳
		String setTime = ""; // ex > 03:00 까지만 저장
		for(int i = 0; i < bl.size(); i++) { // 가져온 리스트만큼 반복
			
			date = bl.get(i).getbDate(); // i번째 게시글의 날짜만 빼옴
			
			ymd = date.substring(0, date.indexOf(" ")); 				//가져온 날짜에서 0~공백까지의 글자를 ymd에 저장함
			time = date.substring(date.indexOf(" "), date.length());	//가져온 날짜에서 공백~문자열의 끝까지를 time에 저장
			
			if(today.equals(ymd)) {				//저장한 값이 오늘날짜와 같으면
				setTime = time.substring(0, 6);
				bl.get(i).setbDate(setTime);	// 시간만 출력하기
			}else { 							// 저장한 값이 오늘날짜와 다르면
				bl.get(i).setbDate(ymd);		// 연월일 출력하기
			}
		}
		return bl;
	}

}
