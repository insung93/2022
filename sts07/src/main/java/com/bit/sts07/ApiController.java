package com.bit.sts07;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts07.domain.EmpDao;
import com.bit.sts07.domain.EmpVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api")
//@Controller
//@ResponseBody
@RestController
public class ApiController {
	
	@Autowired
	EmpDao empDao;
	
	@RequestMapping("/test")
	public Object test() {
		List list = new ArrayList();
		list.add(1111);
		list.add(2222);
		list.add(3333);
		list.add(4444);
//		return list;

		Map<String, Object> map = new HashMap<>();
		map.put("empno", 1111);
		map.put("ename","tester");
		map.put("arr", list);
		
		return new EmpVo();
	}
//	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	@GetMapping("/emp")
	public List<EmpVo> list() throws SQLException {
		List<EmpVo> list = empDao.findAll();
		return list;
	}
	
	@PostMapping("/emp")
	public void add(EmpVo bean) throws SQLException {
		log.info(bean.toString());
		empDao.insertOne(bean);
	}
	
	@GetMapping("/emp/{empno}")
	public EmpVo detail(@PathVariable int empno) throws SQLException {
		EmpVo bean = empDao.findOne(empno);
		return bean;
	}
	
	@PutMapping("/emp/{empno}")
	public void update(@RequestBody EmpVo bean) {
		log.info("update:" + bean);
		int result = 0;
		try {
			result = empDao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 에러가 필요할때에는 throw
		// else try-catch
		if(result == 0) {
			throw new IllegalArgumentException();
		}
		
	}
}
