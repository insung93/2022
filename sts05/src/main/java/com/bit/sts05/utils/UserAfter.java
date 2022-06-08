package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UserAfter {
	
//	@After(value = "execution(* com.bit.sts05.service.MyModule.*(..))")
	public void afterTargetMethod(JoinPoint thisJoinPoint) {
		System.out.println("** method after run.." + thisJoinPoint);
	}
	
//	@AfterReturning(value = "execution(* com.bit.sts05.service.MyModule.*(..))", returning = "retVal")
    public void afterReturningTargetMethod(JoinPoint thisJoinPoint, Object retVal) {
    	System.out.println("after run value: " + retVal);
    	
    }
    
//	@AfterThrowing(value = "execution(* com.bit.sts05.service.MyModule.*(..))", throwing = "exception")
    public void afterThrowingTargetMethod(JoinPoint thisJoinPoint, Exception exception) throws Exception {
    	System.out.println(exception.toString());
    }
}
