package kr.board.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("BoardBean")
public class BoardBean {
	/** 표시용 No */
	private int rNum;
	/** 고유번호 */
	private int boardNo = 0;
	/** 제목 */
	private String title;
	/** 내용 */
	private String contents;
	/** 작성자 ID */
	private String id;
	/** 작성자 이름 */
	private String name;
	/** 비밀번호 */
	private String password;
	/** 등록일 */
	private Date regdate;
	/** CRUD 구분값 */
	private String boardFlag;
	
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getBoardFlag() {
		return boardFlag;
	}
	public void setBoardFlag(String boardFlag) {
		this.boardFlag = boardFlag;
	}
}