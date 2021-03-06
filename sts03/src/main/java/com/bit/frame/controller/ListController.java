package com.bit.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.frame.model.EmpDao;

public class ListController implements Controller {

	// type 매칭
	@Autowired
	EmpDao empDao;
	

//	public void setEmpDao(EmpDao empDao) {
//		this.empDao = empDao;
//	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new ModelAndView("list", "list", empDao.findAll());
	}

}
