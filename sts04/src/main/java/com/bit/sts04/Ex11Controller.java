package com.bit.sts04;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Ex11Controller {
	
	@RequestMapping(value = {"ex11","test11"}, method = RequestMethod.GET)
	public String ex11() {
		System.out.println(TestEnum.msg1);
		System.out.println(TestEnum.msg2);
		System.out.println(TestEnum.msg3);
		
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println(Calendar.getInstance().get(Calendar.MONTH));
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		System.out.println(Calendar.getInstance().get(0));
		System.out.println(Calendar.getInstance().get(1));
		System.out.println(Calendar.getInstance().get(2));
		return "ex01";
	}
	public TestEnum func() {
		return TestEnum.msg1;
	}
	@RequestMapping("ex12")
	public String ex12() {
		return "ex09";
	}
}
