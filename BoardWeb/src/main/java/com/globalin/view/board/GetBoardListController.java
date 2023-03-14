package com.globalin.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		System.out.println("글 목록 검색 처리..");

		/*
		 * 데이터베이스 연동 // BoardVO vo = new BoardVO(); 
		 * BoardDAO boardDAO = new BoardDAO();
		 * List<BoardVO> boardList = boardDAO.getBoardList();
		 */
		
		// 검색 결과를 세션에 저장하고 목록 화면을 리턴함
		/*
		 * HttpSession session = request.getSession(); 
		 * session.setAttribute("boardList",boardList);
		 * return "getBoardList";
		 */
		// ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardDAO.getBoardList());
		mav.setViewName("getBoardList.jsp");

		return mav;

	}

}
