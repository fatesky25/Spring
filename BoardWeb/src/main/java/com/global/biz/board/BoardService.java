package com.global.biz.board;

import java.util.List;

public interface BoardService {

	// CRUD 기능의 메소드 정의
	void insertBoard(BoardVO vo);
	
	void updateBoard(BoardVO vo);
	
	void deleteBoard(BoardVO vo);
	
	BoardVO getBoard(BoardVO vo);
	
	List<BoardVO> getBoardList(BoardVO vo);
}
