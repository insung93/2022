package com.bit.sts05.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserBefore {
	
	@Before(value = "execution(* com.bit.sts05.service.MyModule.*(..))")
    public void beforeTargetMethod(JoinPoint thisJoinPoint) {
    	Class cls = thisJoinPoint.getSignature().getDeclaringType();
    	String name = thisJoinPoint.getSignature().getName();
    	Object[] args = thisJoinPoint.getArgs();
    	
    	System.out.println("** method before run..." + thisJoinPoint);
    	System.out.println("** method before run..." + cls);
    	System.out.println("** method before run..." + name);
    	System.out.println("** method before run..." + Arrays.toString(args));
    	
    }
}
