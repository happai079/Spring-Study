package com.aop.spring_aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

// 공통 기능에 사용할 클래스(Proxy에 해당)
public class PerformanceAspect {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("[Log]Before: " + methodName + "() 싫행 시작");
		System.out.println("--------------------------------------------------------");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		
		try {
			result = joinPoint.proceed();  // 핵심 기능 수행
		} catch (Exception e) {
			System.out.println("[Log]Exception: " + methodName);
		}
		
		long endTime = System.nanoTime();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("[Log]After: " + methodName + "() 싫행 종료");
		System.out.println("[Log]" + methodName + "() 싫행 시간: " + (endTime - startTime) + "ns");
		System.out.println("--------------------------------------------------------");
		
		return result;
	}
}
