package com.bit.frame.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionMethod implements ThrowsAdvice{

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("exception");
	}
}
