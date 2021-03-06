package kr.or.board.board_test.vo;

public class Board {
	private String bCode; // 게시글 코드
	private String bCate; // 게시글 카테고리
	private String bTitle; // 게시글 제목
	private String bContent; // 게시글 내용
	private String bPw; // 게시글 비밀번호 (비회원 수정시)
	private String bNick; // 게시글 작성 닉네임
	private String bFileName; // 파일 이름
	private String bFileDir; // 파일 저장 경로
	private String bDate; // 게시글 작성일자
	private int bView; // 게시글 조회수
	private int bRecom; // 게시글 추천수
	public String getbCode() {
		return bCode;
	}
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public String getbCate() {
		return bCate;
	}
	public void setbCate(String bCate) {
		this.bCate = bCate;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbPw() {
		return bPw;
	}
	public void setbPw(String bPw) {
		this.bPw = bPw;
	}
	public String getbNick() {
		return bNick;
	}
	public void setbNick(String bNick) {
		this.bNick = bNick;
	}
	public String getbFileName() {
		return bFileName;
	}
	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}
	public String getbFileDir() {
		return bFileDir;
	}
	public void setbFileDir(String bFileDir) {
		this.bFileDir = bFileDir;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public int getbView() {
		return bView;
	}
	public void setbView(int bView) {
		this.bView = bView;
	}
	public int getbRecom() {
		return bRecom;
	}
	public void setbRecom(int bRecom) {
		this.bRecom = bRecom;
	}
	@Override
	public String toString() {
		return "Board [bCode=" + bCode + ", bCate=" + bCate + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bPw="
				+ bPw + ", bNick=" + bNick + ", bFileName=" + bFileName + ", bFileDir=" + bFileDir + ", bDate=" + bDate
				+ ", bView=" + bView + ", bRecom=" + bRecom + "]";
	}

	
}
