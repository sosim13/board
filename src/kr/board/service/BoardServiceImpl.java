package kr.board.service;

import java.util.ArrayList;

import kr.board.bean.BoardBean;
import kr.board.common.Paging;
import kr.board.mapper.BoardMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int getBoardListCnt() {
		return boardMapper.getBoardListCnt();
	}
	
	@Override
	public ArrayList<BoardBean> getBoardList(Paging paging) {
		return boardMapper.getBoardList(paging);
	}
	
	@Override
	public BoardBean getBoardDetail(BoardBean boardBean) {
		return boardMapper.getBoardDetail(boardBean);
	}
	
	@Override
	public int insertUpdateBoard(BoardBean boardBean) {
		return boardMapper.insertUpdateBoard(boardBean);
	}
	
	@Override
	public int deleteBoard(BoardBean boardBean) {
		return boardMapper.deleteBoard(boardBean);
	}
	
	@Override
	public int passwordCheck(BoardBean boardBean) {
		return boardMapper.passwordCheck(boardBean);
	}
}
