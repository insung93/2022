package com.bit.sts04.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts04.model.EmpDao;
import com.bit.sts04.model.EmpVo;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	
	@Autowired
	EmpDao<EmpVo> empDao;
	
	@RequestMapping("list")
	public void list(Model model) throws SQLException {
		model.addAttribute("list", empDao.findAll());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String insert(@RequestParam("empno") int empno,@RequestParam("ename") String ename,
						@RequestParam int sal, String job) throws SQLException {
		// 생략가능 @RequestParam("empno")
		// 넘어오는 name과 사용할 변수 이름이 틀리면 명시 해줘야함
		
		empDao.insertOne(new EmpVo(
				empno,sal,ename,job,null
				));
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public void detail(@RequestParam("idx") int empno, Model model) throws SQLException {
		model.addAttribute("readonly", "readonly");
		model.addAttribute("display_reset", "hidden");
		model.addAttribute("action", "edit");
		model.addAttribute("method", "get");
		model.addAttribute("bean", empDao.findOne(empno));
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(int empno,Model model) throws SQLException {
		model.addAttribute("bean", empDao.findOne(empno));
		model.addAttribute("action", "edit");
		model.addAttribute("method", "post");
		model.addAttribute("display_delete", "hidden");
		return "emp/detail";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(int empno, int sal, String ename, String job, Model model) throws SQLException {
		empDao.updateOne(new EmpVo(empno, sal, ename, job, null));
		return "redirect:detail?idx=" + empno;
	}
	
	@RequestMapping(value ="delete", method = RequestMethod.POST)
	public void delete(int empno, HttpServletResponse res) throws SQLException {
		try {
			empDao.deleteOne(empno);
			res.setStatus(HttpServletResponse.SC_OK);
		} catch(SQLException e) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
