package kr.board.service;

import java.util.ArrayList;

import kr.board.bean.BoardBean;
import kr.board.common.Paging;


public interface BoardService {
	
	public int getBoardListCnt();
	
	public ArrayList<BoardBean> getBoardList(Paging paging);
	
	public BoardBean getBoardDetail(BoardBean boardBean);
	
	public int insertUpdateBoard(BoardBean boardBean);
	
	public int deleteBoard(BoardBean boardBean);
	
	public int passwordCheck(BoardBean boardBean);
}
