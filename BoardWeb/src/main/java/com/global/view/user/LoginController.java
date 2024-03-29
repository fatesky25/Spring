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
	public String loginView(UserVO vo) {//get 방식
		System.out.println("로그인 화면으로 이동 ....... ");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	
	
	
	@RequestMapping(value ="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {// post 방식
		System.out.println("로그인 인증 처리 ....... ");
		
		if(vo.getId() ==null || vo.getId().equals("")) {
		  throw new IllegalArgumentException("아이디는 반드시 입력하셔야 됩니다...");	
		}
		
		UserVO user =userDAO.getUser(vo);
 		 // 3. 화면 네비게이션
 		 if(user != null) {
 			 session.setAttribute("userName", user.getName());
 		    return "getBoardList.do";
 		 }else {
 		   return "login.jsp";
 		 }
			
	}

}
