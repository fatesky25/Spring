package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 삭제 처리..");
		
		/*
		 * String seq = request.getParameter("seq");
		 * 
		 * // DB BoardVO vo = new BoardVO(); vo.setSeq(Integer.parseInt(seq));
		 * 
		 * BoardDAO boardDAO = new BoardDAO();
		 */
		boardDAO.deleteBoard(vo);
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("redirect:getBoardList.do");
		
		return "deleteBoard.do";
	}

}
