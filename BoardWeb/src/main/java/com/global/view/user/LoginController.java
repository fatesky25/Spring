package com.global.view.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	
	@RequestMapping(value ="/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {//get ���
		System.out.println("�α��� ȭ������ �̵� ....... ");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	
	
	
	@RequestMapping(value ="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {// post ���
		System.out.println("�α��� ���� ó�� ....... ");
		
		if(vo.getId() ==null || vo.getId().equals("")) {
		  throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ϼž� �˴ϴ�...");	
		}
		
		UserVO user =userDAO.getUser(vo);
 		 // 3. ȭ�� �׺���̼�
 		 if(user != null) {
 			 session.setAttribute("userName", user.getName());
 		    return "getBoardList.do";
 		 }else {
 		   return "login.jsp";
 		 }
			
	}

}
