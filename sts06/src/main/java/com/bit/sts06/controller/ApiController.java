package com.bit.sts06.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts06.domain.EmpDao;
import com.bit.sts06.domain.EmpVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api")
@Slf4j
public class ApiController {
	
	@Autowired
	EmpDao empDao;
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public void list(HttpServletResponse res) throws IOException, SQLException {
		res.setContentType("application/json; charset=utf-8");
		PrintWriter out = res.getWriter();
//		out.print("{\"root\":[");
//		boolean boo = true;
//		for(EmpVo bean : empDao.findAll()) {
//			if(boo) {
//				boo = false;
//			} else {
//				out.print(",");
//			}
//			out.print("{");
//			out.print("\"empno\": " + bean.getEmpno() +"," );
//			out.print("\"ename\": \"" + bean.getEname() +"\"," );
//			out.print("\"hiredate\": " + (bean.getHiredate()==null?null:bean.getHiredate().getTime()) +"" );
////			out.print("\"hiredate\": \"" + bean.getHiredate() +"\"" );
//			out.print("}");
//		}
//		out.print("]}");
		JsonArray arr = new JsonArray();
		for(EmpVo bean : empDao.findAll()) {
			JsonObject obj = new JsonObject();
			obj.addProperty("empno", bean.getEmpno());
			obj.addProperty("ename", bean.getEname());
			obj.addProperty("sal", bean.getSal());
			obj.addProperty("job", bean.getJob());
			arr.add(obj);
		}
		JsonObject json = new JsonObject();
		json.add("root", arr);
		out.print(json);
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public void add(HttpServletResponse res, @ModelAttribute EmpVo bean) throws Exception {
		log.info("add api param : " + bean);
		empDao.insertOne(bean);
		res.setStatus(HttpServletResponse.SC_OK);
	}
	@RequestMapping(value = "/emp/{empno}", method = RequestMethod.GET)
	public void detail(@PathVariable("empno") int empno ,HttpServletResponse res) throws Exception{
		EmpVo bean = empDao.findOne(empno);
		res.setContentType("application/json; charset=utf-8");
		res.setStatus(HttpServletResponse.SC_OK);
//		res.getWriter().print(
//				"{\"empno\": " + bean.getEmpno() +
//				",\"ename\": \"" + bean.getEname() +"\""+
//				",\"sal\": \"" + bean.getSal() +"\""+
//				",\"job\": \"" + bean.getEname() +"\"}");
		
//		JsonObject json = new JsonObject();
//		json.addProperty("empno",bean.getEmpno());
//		json.addProperty("ename",bean.getEname());
//		json.addProperty("sal",bean.getSal());
//		json.addProperty("job",bean.getJob());
//		res.getWriter().print(json.toString());
		
		Gson gson = new Gson();
		String msg = gson.toJson(bean);
		res.getWriter().print(msg);
	}
	
	@RequestMapping(value = "/emp/{idx}", method = RequestMethod.PUT)
	public void update(@PathVariable int idx, HttpServletRequest req, HttpServletResponse res) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String msg = br.readLine();
		log.info(msg);
		Gson gson = new Gson();
		EmpVo bean = gson.fromJson(msg, EmpVo.class);
		empDao.updateOne(bean);
		res.setStatus(HttpServletResponse.SC_OK);
	}
	
	@RequestMapping(value = "/testget", method = RequestMethod.GET)
	public void testApi(HttpServletResponse res) throws IOException {
//		Gson gson = new Gson();
//		String msg = gson.toJson(new EmpVo(1111,1000,"test","tester",null));
//		res.getWriter().print(msg);
		
		JsonArray arr = new JsonArray();
		JsonObject json = new JsonObject();
		json.addProperty("empno", 1111);
		arr.add(json);
		
		json = new JsonObject();
		json.addProperty("empno", 2222);
		arr.add(json);
		res.setStatus(HttpServletResponse.SC_OK);
		res.getWriter().print(arr.toString());
	}
	
	@RequestMapping(value = "/testput", method = RequestMethod.PUT)
	public void testApiPut(HttpServletResponse res) throws IOException {
//		Gson gson = new Gson();
//		String msg = gson.toJson(new EmpVo(1111,1000,"test","tester",null));
//		res.getWriter().print(msg);
		
		JsonArray arr = new JsonArray();
		JsonObject json = new JsonObject();
		json.addProperty("empno", 1111);
		arr.add(json);
		
		json = new JsonObject();
		json.addProperty("empno", 2222);
		arr.add(json);
		res.setStatus(HttpServletResponse.SC_OK);
		res.getWriter().print(arr.toString());
	}
}
