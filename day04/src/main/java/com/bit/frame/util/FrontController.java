package com.bit.frame.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	String prefix, suffix;
	
	Map<String, MyController> handlerMapping = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		prefix = "/WEB-INF/views/";
		suffix = ".jsp";
//		handlerMapping.put("/index.bit", new IndexController());
//		handlerMapping.put("/list.bit", new ListController());
//		handlerMapping.put("/login.bit", new LoginController());
//		handlerMapping.put("/add.bit", new AddController());
		
		Map<String, String> mapping = new HashMap<>();
		Enumeration<String> names = getInitParameterNames();
		while(names.hasMoreElements()) {
			String url = names.nextElement();
			mapping.put(url, getInitParameter(url));
		}
//		mapping.put("/index.bit", "com.bit.frame.controller.IndexController");
//		mapping.put("/list.bit", "com.bit.frame.controller.ListController");
//		mapping.put("/login.bit", "com.bit.frame.controller.LoginController");
//		mapping.put("/add.bit", "com.bit.frame.controller.AddController");
		
//		try {
//			handlerMapping.put("/index.bit", (MyController)(Class.forName(mapping.get("/index.bit")).newInstance()));
//			handlerMapping.put("/list.bit", (MyController)(Class.forName(mapping.get("/list.bit")).newInstance()));
//			handlerMapping.put("/login.bit", (MyController)(Class.forName(mapping.get("/login.bit")).newInstance()));
//			handlerMapping.put("/add.bit", (MyController)(Class.forName(mapping.get("/add.bit")).newInstance()));
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
		Set<String> keys = mapping.keySet();
		try {
			for(String key : keys) {
				handlerMapping.put(key, (MyController) (Class.forName(mapping.get(key)).newInstance()));
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req,resp);
	}

	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI().substring(req.getContextPath().length());
		String path = "";
		
		MyController controller = handlerMapping.get(url);
		
//		if(url.equals("/index.bit")) {
//			controller = handlerMapping.get("/index.bit");
//		} else if (url.equals("/list.bit")) {
//			controller = handlerMapping.get("/list.bit");
//		} else if (url.equals("/login.bit")) {
//			controller = handlerMapping.get("/login.bit");
//		} else if (url.equals("/add.bit")) {
//			controller = handlerMapping.get("/add.bit");
//		}
		
		if(controller == null) {
			resp.sendError(404);
			return;
		}
		path += controller.execute(req, resp);
		
		if(path.startsWith("redirect:")) resp.sendRedirect(path.substring("redirect:".length()));
		else {
			path = prefix + path + suffix;
		
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
		}
	}
}
