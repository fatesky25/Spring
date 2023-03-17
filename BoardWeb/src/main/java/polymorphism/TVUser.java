package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너를 구동함
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); 
		
		/*  GenericXmlApplicationContext
		 *     - 파일시스템이나 클래스 경로에 있는 xml 설정파일을 구동하는 컨테이너임
		 *    
		 *  XmlWebApplicationContext
		 *    - 웹 기반의 스프링 어플리케이션을 개발할때 사용하는 컨테이너임
		 */
		
		
		
		//BeanFactory factory = new BeanFactory();
		
		//2. Spring 컨테이너로 부터 필요한 객체를 요청(lookup)함
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		factory.close();
		//System.out.println();
	
		/*
		TV lgtv = new LgTV();
		lgtv.powerOn();
		lgtv.volumeUp();
		lgtv.volumeDown();
		lgtv.powerOff();
		*/

	}

}
