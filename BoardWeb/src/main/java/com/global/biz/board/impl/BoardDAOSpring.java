package com.global.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.global.biz.board.BoardVO;


// DAO
@Repository
public class BoardDAOSpring {
	//public class BoardDAOSpring extends JdbcDaoSupport{
	// SQL 관련 명령어
		//private final String BOARD_INSERT =
		//"insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?) ";
	    private final String BOARD_INSERT ="insert into board(seq, title, writer, content) values(?,?,?,?)";	
	    private final String BOARD_UPDATE ="update board set title=?, content=? where seq=?";
		private final String BOARD_DELETE ="delete board where seq=?";
		private final String BOARD_GET ="select * from board where seq=?";
		private final String BOARD_LIST ="select * from board order by seq desc";
		private final String BOARD_LIST_T ="select * from board where title like '%'||?||'%' order by seq desc";  
		private final String BOARD_LIST_C ="select * from board where content like '%'||?||'%' order by seq desc";
	
	
		@Autowired
		private JdbcTemplate jdbcTemplate;
		/*
		 * public void setSuperDataSource(DataSource dataSource) {
		 * super.setDataSource(dataSource); }
		 */
		
		
		// CRUD 기능의 메소드 구현
		// 글등록
		public void insertBoard(BoardVO vo) {
			System.out.println("====> Spring JDBC로 insertBoard() 기능 처리 .....");
			//getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
			jdbcTemplate.update(BOARD_INSERT, vo.getSeq(),vo.getTitle(), vo.getWriter(), vo.getContent());
		}
		
		
		// 글 수정 
        public void updateBoard(BoardVO vo) {
        	System.out.println("====> Spring JDBC로 updateBoard() 기능 처리 .....");
        	//getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
        	jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		}
		
		// 글 삭제
        public void deleteBoard(BoardVO vo) {
        	System.out.println("====> Spring JDBC로 deleteBoard() 기능 처리 .....");
        	//getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
        	jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		}
		
		
		// 글 상세 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("====> Spring JDBC로 getBoard() 기능 처리 .....");
			Object[] args = {vo.getSeq()};
			//return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
			return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
			// queryForObject : select 구문의 실행결과를 특정 자바 객체(vo) 매핑하여 리턴받을때 사용함
		}
		
		// 글 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("====> Spring JDBC로 getBoardList() 기능 처리 .....");
			Object[] args = {vo.getSearchKeyword()};
			
			if(vo.getSearchCondition().equals("TITLE")) {
				return jdbcTemplate.query(BOARD_LIST_T,args, new BoardRowMapper());
			}else if(vo.getSearchCondition().equals("CONTENT")) {
				return jdbcTemplate.query(BOARD_LIST_C,args, new BoardRowMapper());
			}
			return null;
			//return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
			//return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
			// query : select 문의 실행결과가 목록일때  
		}
	
}
