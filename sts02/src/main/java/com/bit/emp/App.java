package com.bit.emp;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.emp.model.EmpVo;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = null;
		
		ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		EmpVo bean = (EmpVo) ac.getBean("bean");
		
//		long su = System.currentTimeMillis();
//		long su = new java.util.Date().getTime();
//		System.out.println(su);
//		Date hiredate = new Date(su);
//		bean.setHiredate(hiredate);
//		System.out.println(bean);

		System.out.println("-------------------------------------");
		System.out.println("arr1");
		System.out.println(bean.getArr1());
		System.out.println("-------------------------------------");
		System.out.println("arr2");
		System.out.println(bean.getArr2());
		System.out.println("-------------------------------------");
		System.out.println("arr3");
		System.out.println(bean.getArr3());
		System.out.println("-------------------------------------");
		System.out.println("arr4");
		System.out.println(bean.getArr4());
		System.out.println("-------------------------------------");
		System.out.println("arr5");
		System.out.println(Arrays.toString(bean.getArr5()));
		System.out.println("-------------------------------------");
		
		System.out.println(bean);
	}
}
