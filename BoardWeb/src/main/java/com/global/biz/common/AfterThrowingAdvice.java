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
		
		//System.out.println("[예외 처리] "+method+"() 메소드 수행 중 발생된 예외 메시지 :" +exceptObj.getMessage());
		
		System.out.println(method+"()  메소드 수행 중 예외 발생 !!!!!!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력 되었습니다.");
		}else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		}else if(exceptObj instanceof Exception) {
			System.out.println("문제가 아주 크게 발생하였습니다.");
		}
		
		
	}
	
}
