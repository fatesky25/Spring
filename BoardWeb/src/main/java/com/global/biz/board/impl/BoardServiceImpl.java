package com.global.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
//import com.global.biz.common.Log4jAdvice;
//import com.global.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	//private BoardDAOSpring boardDAO;
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	/*
	public BoardServiceImpl() {
	
		//log = new LogAdvice();
		log = new Log4jAdvice();
	}
	*/
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		
		/*
		if(vo.getSeq() == 0) { 
			  throw new IllegalArgumentException("0�� ���� ����Ҽ� �����ϴ�."); 
		}
		*/
		boardDAO.insertBoard(vo);
		//boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();		
		//log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {

		//log.printLog();
		//log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
