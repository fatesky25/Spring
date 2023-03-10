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
		
		// 1. Spring �����̳ʸ� �����Ѵ�.
		
		/*  GenericXmlApplicationContext Ŭ����
		 *   - ���� �ý����̳� Ŭ������ο� �ִ� XML ���������� �ε��Ͽ� �����ϴ� �����̳���
		 *   
		 *   XmlWebApplicationContext Ŭ����
		 *   - �� ����� ������ ���ø����̼��� �����Ҷ� ����ϴ� �����̳���
		 */
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷ� ���� �ʿ��� ��ü�� ��û(lookup)�Ѵ�.
		TV tv =(TV)factory.getBean("tv");
		//TV tv1 =(TV)factory.getBean("tv");
		//TV tv2 =(TV)factory.getBean("tv");
		//TV tv3 =(TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
		

	}

}
