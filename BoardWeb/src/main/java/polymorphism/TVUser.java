package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		
		
		/*
		BeanFactory factory = new BeanFactory();
		//TV tv = new LgTV();
		TV tv =(TV)factory.getBean("samsung");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		LgTV tv = new LgTV();
		tv.trunOn();
		tv.soundUp();
		tv.soundDown();
		tv.trunOff();
		*/
		
		// 1. Spring 컨테이너를 구동한다.
		
		/*  GenericXmlApplicationContext 클래스
		 *   - 파일 시스템이나 클래스경로에 있는 XML 설정파일을 로딩하여 구동하는 컨테이너임
		 *   
		 *   XmlWebApplicationContext 클래스
		 *   - 웹 기반의 스프링 어플리케이션을 개발할때 사용하는 컨테이너임
		 */
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로 부터 필요한 객체를 요청(lookup)한다.
		TV tv =(TV)factory.getBean("tv");
		//TV tv1 =(TV)factory.getBean("tv");
		//TV tv2 =(TV)factory.getBean("tv");
		//TV tv3 =(TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
		

	}

}
