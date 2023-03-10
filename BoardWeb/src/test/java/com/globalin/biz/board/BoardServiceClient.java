package com.globalin.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.globalin.biz.board.impl.BoardServiceImpl;

public class BoardServiceClient {

	public static void main(String[] args) {
	
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService boardService =(BoardService)container.getBean("boardService");
		//BoardServiceImpl boardService = new BoardServiceImpl();
		// �� ���
		BoardVO vo = new BoardVO();
		//vo.setSeq(100);
		vo.setTitle("�ӽ� ����");
		vo.setWriter("ȫ�浿");
		vo.setContent("�ӽ� ������Դϴ�. ......");
		//boardService.insertBoard(vo);
		
		// �� ��� �˻�
		List<BoardVO> boardList = boardService.getBoardList();
		
		for(BoardVO board : boardList) {
			System.out.println("----> "+board.toString());
		}
		
		container.close();
		
		
	}

}
