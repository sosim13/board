package kr.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.board.bean.BoardBean;
import kr.board.common.Paging;
import kr.board.service.BoardService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private BoardService boardService;
	
	//게시판 메인
	@RequestMapping("/board/boardMain")
	public ModelAndView main(HttpServletRequest request, @ModelAttribute Paging paging){
		ModelAndView mav = new ModelAndView("/board/boardList");
		int boardListCnt = boardService.getBoardListCnt();
		
		//페이징처리를 위한 게시판의 전체 데이터 수 조회
		paging.setTotalCnt(boardListCnt);
		ArrayList<BoardBean> boardList = new ArrayList<BoardBean>();
		
		if(boardListCnt > 0){
			boardList = boardService.getBoardList(paging);
		}
		mav.addObject("boardList", boardList);
		mav.addObject("paging", paging);
		return mav;
	}
	
	//글 쓰기 페이지
	@RequestMapping("/board/boardWrite")
	public ModelAndView boardWrite(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/board/boardCRUD");
		return mav;
	}
	
	//게시판 읽기/수정 페이지
	@RequestMapping("/board/boardView")
	public ModelAndView boardView(HttpServletRequest request, @ModelAttribute BoardBean boardBean){
		//ModelAndView mav = new ModelAndView("/board/boardView");
		ModelAndView mav = new ModelAndView("/board/boardCRUD");
		boardBean = boardService.getBoardDetail(boardBean);
		mav.addObject("boardBean", boardBean);
		return mav;
	}
	
	//글쓰기/수정 처리
	@RequestMapping("/board/editProcess")
	public String editProcess(HttpServletRequest request, @ModelAttribute BoardBean boardBean){
		String retPage = "";
		int result = 0;
		
		//삭제
		if("D".equals(boardBean.getBoardFlag())){
			result = boardService.deleteBoard(boardBean);
		}else{	//등록/수정
			result = boardService.insertUpdateBoard(boardBean);
		}
		
		if(result < 1){
			retPage = "/error/error";
			if("C".equals(boardBean.getBoardFlag())){
				request.setAttribute("errMsg", "글쓰기");
			}else if("U".equals(boardBean.getBoardFlag())){
				request.setAttribute("errMsg", "글수정");
			}
		}else{
			retPage = "/board/editSuccess";
		}
		
		return retPage;
	}
	
	//패스워드 일치 확인
	@RequestMapping("/board/passwordCheck")
	public String passwordCheck(HttpServletRequest request, @ModelAttribute BoardBean boardBean){
		int result = boardService.passwordCheck(boardBean);
		request.setAttribute("result", String.valueOf(result));
		return null;
	}
}
