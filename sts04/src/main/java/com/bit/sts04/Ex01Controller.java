package com.bit.sts04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex01Controller {

	public Ex01Controller() {
		System.out.println("Ex01 create...");
	}

	@RequestMapping(value = "/ex01", method = RequestMethod.GET)
	public ModelAndView ex01(HttpServletRequest req, HttpServletResponse res) {

		return new ModelAndView("ex01", "msg", "hello");
	}
}