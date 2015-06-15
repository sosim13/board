package kr.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping("/")
	public void index(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("/board/boardMain.do");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

}
