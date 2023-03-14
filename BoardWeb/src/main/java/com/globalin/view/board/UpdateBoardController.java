package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {

	@RequestMapping("/updateBoard.do")
	public String UpdateBoard(BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 수정 처리..");
		
		//request.setCharacterEncoding("UTF-8");

		/*
		 * String title = request.getParameter("title"); 
		 * String content = request.getParameter("content"); 
		 * String seq = request.getParameter("seq");
		 * 
		 * // DB BoardVO vo = new BoardVO(); vo.setTitle(title); vo.setContent(content);
		 * vo.setSeq(Integer.parseInt(seq)); 
		 * BoardDAO boardDAO = new BoardDAO();
		 */
		boardDAO.updateBoard(vo);
	
		// 응답 화면
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("redirect:getBoardList.do");
		
		return "getBoardList.do";
	}

}
