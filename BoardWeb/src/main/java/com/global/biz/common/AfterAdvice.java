package com.global.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect  // Aspect = Pointcut + Advice
public class AfterAdvice {
	
	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	
	@After("allPointcut()")
 public void finallyLog() {
	 System.out.println("[���� ó��] ����Ͻ� ���� ���� �� ������ ���۵�.....");
 }
}
