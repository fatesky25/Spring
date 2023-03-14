package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	@RequestMapping(value = "/insertBoard.do")
	// public void insertBoard(BoardVO vo,BoardDAO boardDAO) {
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리..");

		/*
		 * String title = request.getParameter("title"); 
		 * String writer = request.getParameter("writer"); 
		 * String content = request.getParameter("content");
		 */

		// DB
		// BoardVO vo = new BoardVO();
		
		 //vo.setTitle(title); 
		 //vo.setWriter(writer); 
		 //vo.setContent(content);
		 

		// BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}

}
