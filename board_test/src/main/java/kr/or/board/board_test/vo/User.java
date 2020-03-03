package kr.or.board.board_test.vo;

public class User {
	private String uId;		// 아이디
	private String uPw;		// 패스워드
	private String uName;	// 이름
	private String uBirth;	// 생년월일
	private String uNick;	// 닉네임
	private String uDate;	// 가입일자

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuBirth() {
		return uBirth;
	}

	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}

	public String getuNick() {
		return uNick;
	}

	public void setuNick(String uNick) {
		this.uNick = uNick;
	}

	public String getuDate() {
		return uDate;
	}

	public void setuDate(String uDate) {
		this.uDate = uDate;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uBirth=" + uBirth + ", uNick=" + uNick
				+ ", uDate=" + uDate + "]";
	}

}
