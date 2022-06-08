package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;

public class UserAfter {
	public void afterTargetMethod(JoinPoint thisJoinPoint) {
		System.out.println("** method after run.." + thisJoinPoint);
	}
	
    public void afterReturningTargetMethod(JoinPoint thisJoinPoint, Object retVal) {
    	System.out.println("after run value: " + retVal);
    	
    }
    
    public void afterThrowingTargetMethod(JoinPoint thisJoinPoint, Exception exception) throws Exception {
    	System.out.println(exception.toString());
    }
}
