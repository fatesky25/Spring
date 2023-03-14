package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {

		System.out.println("글 상세 조회 처리..");

		/*
		 * // 검색할 게시글 번호를 추출함 String seq = request.getParameter("seq");
		 * // DB 가져오기 BoardVO vo = new BoardVO(); 
		 * vo.setSeq(Integer.parseInt(seq));
		 * BoardDAO boardDAO = new BoardDAO(); 
		 * BoardVO board = boardDAO.getBoard(vo);
		 */
		
		/*
		 * HttpSession session = request.getSession(); 
		 * session.setAttribute("board", board); 
		 * return "getBoard";
		 */

		// ModelAndView mav = new ModelAndView();
		mav.addObject("board", boardDAO.getBoard(vo));
		// Model 정보 저장
		mav.setViewName("getBoard.jsp"); // View 정보 저장

		return mav;

	}

}
