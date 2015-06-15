package kr.board.mapper;

import java.util.ArrayList;

import kr.board.bean.BoardBean;
import kr.board.common.Paging;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	
	@Select({
		"SELECT COUNT(0) FROM BOARD"
	})
	public int getBoardListCnt();
	
	public ArrayList<BoardBean> getBoardList(Paging paging);
	
	public BoardBean getBoardDetail(BoardBean boardBean);
	
	public int insertUpdateBoard(BoardBean boardBean);
	
	@Delete({
		"DELETE FROM BOARD WHERE BOARDNO = #{boardNo, jdbcType=INTEGER}"
	})
	public int deleteBoard(BoardBean boardBean);
	
	@Select({
		"SELECT COUNT(0) FROM BOARD WHERE BOARDNO = #{boardNo, jdbcType=INTEGER} AND PASSWORD = #{password, jdbcType=VARCHAR}"
	})
	public int passwordCheck(BoardBean boardBean);
}
