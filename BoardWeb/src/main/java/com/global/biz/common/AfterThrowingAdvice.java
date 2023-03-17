package com.global.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  // Aspect = Pointcut + Advice
public class AfterThrowingAdvice {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}

	@AfterThrowing(pointcut="allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
	
		String method = jp.getSignature().getName();
		
		//System.out.println("[���� ó��] "+method+"() �޼ҵ� ���� �� �߻��� ���� �޽��� :" +exceptObj.getMessage());
		
		System.out.println(method+"()  �޼ҵ� ���� �� ���� �߻� !!!!!!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("�������� ���� �Է� �Ǿ����ϴ�.");
		}else if(exceptObj instanceof NumberFormatException) {
			System.out.println("���� ������ ���� �ƴմϴ�.");
		}else if(exceptObj instanceof Exception) {
			System.out.println("������ ���� ũ�� �߻��Ͽ����ϴ�.");
		}
		
		
	}
	
}
