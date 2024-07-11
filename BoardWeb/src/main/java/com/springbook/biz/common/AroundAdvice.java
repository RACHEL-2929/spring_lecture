package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;



@Service
@Aspect
public class AroundAdvice {
		
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		
		
		String method = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println(method+"() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis()+ "(ms)초");
		return obj;

		
		// returnObj를 기준으로 앞에 쓰여진 것은 before과 같은 기능 후에 쓰여진 것은 after와 같은 기능
	}
	
	
}
