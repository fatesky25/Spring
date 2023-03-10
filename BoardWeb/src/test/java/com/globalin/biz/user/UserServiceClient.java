package com.globalin.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class UserServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		
		UserService userService =(UserService)container.getBean("userService");
		
		
		// �α��� ��ɱ���
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName()+"�� ����� ȯ���ϴ� ���Դϴ�.");
		}else {
			System.out.println("�α��� ���� !!! ..");
		}
		container.close();
		
	}

}
