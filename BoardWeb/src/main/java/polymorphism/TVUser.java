package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring �����̳ʸ� ������
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); 
		
		/*  GenericXmlApplicationContext
		 *     - ���Ͻý����̳� Ŭ���� ��ο� �ִ� xml ���������� �����ϴ� �����̳���
		 *    
		 *  XmlWebApplicationContext
		 *    - �� ����� ������ ���ø����̼��� �����Ҷ� ����ϴ� �����̳���
		 */
		
		
		
		//BeanFactory factory = new BeanFactory();
		
		//2. Spring �����̳ʷ� ���� �ʿ��� ��ü�� ��û(lookup)��
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
