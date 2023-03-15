package com.globalin.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardservice;

	//글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
	//public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리..");

		//2. DB 연동 처리
		boardservice.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
//	public String UpdateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
	public String UpdateBoard(@ModelAttribute("board") BoardVO vo) {
		
		System.out.println("글 수정 처리..");
		
		/*
		 * System.out.println("번호:"+vo.getSeq());
		 * System.out.println("제목:"+vo.getTitle());
		 * System.out.println("작성자 이름:"+vo.getWriter());
		 * System.out.println("내용:"+vo.getContent());
		 * System.out.println("등록일:"+vo.getRegDate());
		 * System.out.println("조회수:"+vo.getCnt());
		 */
		boardservice.updateBoard(vo);
	    return "getBoardList.do";
	}
	
	//글삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		System.out.println("글 삭제 처리..");

		boardservice.deleteBoard(vo);

		return "getBoardList.do";
	}

	/*
	 * @RequestMapping("/getBoard.do") public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
	 * 
	 * System.out.println("글 상세 조회 처리..");
	 * 
	 * mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
	 * mav.setViewName("getBoard.jsp"); // View 정보 저장
	 * 
	 * return mav;
	 * 
	 * }
	 */
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		System.out.println("글 상세 조회 처리..");

		//Model 정보 저장
		model.addAttribute("board", boardservice.getBoard(vo));

		return "getBoard.jsp";//View 이름을 리턴함

	}
	
	
	/*
	 * @RequestMapping("/getBoardList.do") public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
	 * 
	 * System.out.println("글 목록 검색 처리..");
	 * 
	 * mav.addObject("boardList", boardDAO.getBoardList());
	 * mav.setViewName("getBoardList.jsp");
	 * return mav;
	 * 
	 * }
	 */
	

	
	  @RequestMapping("/getBoardList.do") 
	  public String getBoardList(BoardVO vo, Model model) {

      System.out.println("글 목록 검색 처리..");
	  
      model.addAttribute("boardList", boardservice.getBoardList()); 
	  return "getBoardList.jsp";//View 이름을 리턴함
	  
	 }
	  
	//검색 조건 목록 설정
	  @ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		  
		  Map<String, String> ConditionMap = new HashMap<String,String>();
		  ConditionMap.put("제목", "TITLE");
		  ConditionMap.put("내용", "CONTENT");
		  return ConditionMap;

	  }
	 
	
	/*
	 * @RequestMapping("/getBoardList.do") public String getBoardList(
	 * 
	 * @RequestParam(value = "searchCondition",defaultValue = "TITLE",required =
	 * false) String condition,
	 * 
	 * @RequestParam(value = "searchKeyword",defaultValue = "",required = false)
	 * String Keyword ,BoardDAO boardDAO, Model model) {
	 * 
	 * System.out.println("글 목록 검색 처리.."); System.out.println("검색 조건:"+condition);
	 * System.out.println("검색 단어:"+Keyword);
	 * 
	 * model.addAttribute("boardList", boardDAO.getBoardList()); return
	 * "getBoardList.jsp";//View 이름을 리턴함
	 * 
	 * }
	 */
	
	
}
	
