package polymorphism;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// <bean id="tv" class="polymorphism.LgTV"></bean>
@Component("tv")
public class LgTV implements TV{
     
	//@Resource(name = "apple")
	//@Qualifier("sony")
	
	@Autowired
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV----���� �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("LgTV----���� ����.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
		//System.out.println("LgTV----�Ҹ� �ø���.");
	}
	
	public void volumeDown() {
		 speaker.volumeDown();
		//System.out.println("LgTV----�Ҹ� ������.");
	}
}
