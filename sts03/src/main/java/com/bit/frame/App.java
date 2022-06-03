package com.bit.frame;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.frame.service.UserService;

public class App {
	static Logger logger = Logger.getLogger(App.class);
	public static void main(String[] args) throws Exception {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		
		UserService service = (UserService) context.getBean("proxy");
//		System.out.println(" 123   "+service);
//		service.setMsg("수정");
		service.printMsg();
//		service.setSu(3);
//		service.printSu();
	}
}
