package com.bit.frame.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class AroundMethod implements MethodInterceptor {
	Logger log = Logger.getLogger(getClass());
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.debug("around...before");
		Object obj = null;
		try {
			obj = invocation.proceed();
			// returning advice 처럼 동작
			// System.out.println("around...after");
		} catch(Exception e) {
			// Exception advice 처럼 동작
			// System.out.println("around...after");
			
		}
		log.debug("around...after" + obj );
		return obj;
	}

}
