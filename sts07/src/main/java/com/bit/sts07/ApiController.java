package com.bit.sts07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts07.domain.EmpDao;
import com.bit.sts07.domain.EmpVo;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	EmpDao empDao;
	
	@RequestMapping("/test")
	@ResponseBody
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
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	@ResponseBody
	public List<EmpVo> list() {
		
	}
}
