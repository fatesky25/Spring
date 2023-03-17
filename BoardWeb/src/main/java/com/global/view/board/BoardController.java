package com.global.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// �� ���
	 @RequestMapping(value = "/insertBoard.do")
	  	public String insertBoard(BoardVO vo) throws IOException{
		 System.out.println("�� ��� ó��");
		 
		 // ���� ���ε� ó��
		 MultipartFile uploadFile = vo.getUploadFile();
		 if(!uploadFile.isEmpty()) {
			 String fileName = uploadFile.getOriginalFilename();
			 uploadFile.transferTo(new File("C:/aa/"+fileName));
		 }
		    // 2. DB ���� ó��
		 boardService.insertBoard(vo);
		 return "getBoardList.do";
	}
	 
	 // �� ����
	 @RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board")  BoardVO vo) {
			// TODO Auto-generated method stub
			 System.out.println("�� ���� ó��");
		    /*	 
			 System.out.println("��ȣ:"+vo.getSeq());
			 System.out.println("����:"+vo.getTitle());
			 System.out.println("�ۼ��� �̸�:"+vo.getWriter());
			 System.out.println("���� :"+vo.getContent());
			 System.out.println("�����:"+vo.getRegDate());
			 System.out.println("��ȸ��:"+vo.getCnt());
			 */
			 boardService.updateBoard(vo);
			 return "getBoardList.do";
		}
	 
	 // �ۻ���
	 @RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo) {
		
			 System.out.println("�� ���� ó��");
			 
			 boardService.deleteBoard(vo);
			  
			  return "getBoardList.do";
			
		}
	
	 // �� �� ��ȸ
	 /*
	 @RequestMapping("/getBoard.do")
		public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
			
			System.out.println("�� �� ��ȸ ó��");
			 
			 mav.addObject("board", boardDAO.getBoard(vo));
			 // View  ���� ����
			 mav.setViewName("getBoard.jsp");
			
			 return mav;
		}
	 */
	 @RequestMapping("/getBoard.do")
		public String getBoard(BoardVO vo, Model model) {
			
			System.out.println("�� �� ��ȸ ó��");
			 
			// Model ���� ����
			model.addAttribute("board", boardService.getBoard(vo));
			return "getBoard.jsp";//View �̸��� ������
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 // �� ��� ��ȸ
	 /*
	 @RequestMapping("/getBoardList.do")
		public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav){ 
			// TODO Auto-generated method stub
			
			 System.out.println("�� ��� �˻� ó��");
			 
	  		 // �˻� ����� ȭ�������� ModelAndView�� �����Ͽ� ������
	 		 mav.addObject("boardList", boardDAO.getBoardList(vo));
	 		 // View  ���� ����
	 		 mav.setViewName("getBoardList.jsp");
	 		 
			return mav;
		}
	 */
	
	 @RequestMapping("/getBoardList.do")
		public String getBoardList(BoardVO vo, Model model){ 
			// TODO Auto-generated method stub
			
			 System.out.println("�� ��� �˻� ó��");
			 
			 // Null Check
			 if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
			 if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
			  
			 // model 
			 model.addAttribute("boardList", boardService.getBoardList(vo));
				return "getBoardList.jsp";//View �̸��� ������
		}
	 
	 // �˻� ���� ��� ����
	 @ModelAttribute("conditionMap")
	 public Map<String, String> searchConditionMap(){
		 
		 Map<String, String> conditionMap = new HashMap<String,String>();
		 conditionMap.put("����", "TITLE");
		 conditionMap.put("����", "CONTENT");
		 return conditionMap;
	 }
	 
	 
	 
	 
	 
	
	 /*
	 @RequestMapping("/getBoardList.do")
		public String getBoardList(
				@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
				@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword		
				, BoardDAO boardDAO, Model model){ 
			// TODO Auto-generated method stub
		    System.out.println("�� ��� �˻� ó��");
			System.out.println("�˻� ����:"+condition);
			System.out.println("�˻� �ܾ�:"+keyword);
			 
			 model.addAttribute("boardList", boardDAO.getBoardList());
				return "getBoardList.jsp";//View �̸��� ������
		}
*/
	 
}