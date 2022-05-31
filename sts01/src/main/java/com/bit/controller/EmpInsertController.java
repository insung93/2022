package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp03Dao;
import com.bit.model.EmpDao;
import com.bit.model.EmpVo;

public class EmpInsertController implements Controller {
	EmpDao dao = new Emp03Dao();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		EmpVo bean = new EmpVo(
				Integer.parseInt(request.getParameter("empno")),
				Integer.parseInt(request.getParameter("sal")),
				request.getParameter("ename"),
				request.getParameter("job")
				);
		if("POST".equals(request.getMethod())) {
			dao.insertOne(bean);
			
			mav.setViewName("redirect:list.bit");
		} else {
			mav.setViewName("emp/add");
		}
		
		return mav;
	}
	
}
