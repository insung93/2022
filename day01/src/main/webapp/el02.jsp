<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>값의 전달</h1>
	<% 
		java.util.Date msg1 = new java.util.Date();
//		String msg1 = "ABCD";
		
		pageContext.setAttribute("msg2", "pageContext");
		request.setAttribute("msg3", "request");
		session.setAttribute("msg4", "session");
		application.setAttribute("msg5", "application");

		pageContext.setAttribute("msg6", "pageContext");
		request.setAttribute("msg6", "request");
		session.setAttribute("msg6", "session");
		application.setAttribute("msg6", "application");
		
		String[] arr1 = {"item1", "item2", "item3"};
		application.setAttribute("msg7", arr1);
		
		java.util.List<String> arr2 = new java.util.ArrayList<String>();
		arr2.add("list1");
		arr2.add("list2");
		arr2.add("list3");
		application.setAttribute("msg8", arr2);
		
		java.util.Set<String> arr3 = new java.util.HashSet<String>();	// JSTL
		arr3.add("set1");
		arr3.add("set2");
		arr3.add("set3");
		application.setAttribute("msg9", arr3);
		
		java.util.Map<String, String> arr4 = new java.util.HashMap<String, String>();
		arr4.put("key1","val1");
		arr4.put("key2","val2");
		arr4.put("key3","val3");
		application.setAttribute("msg10", arr4);
		
		com.bit.frame.controller.DeptVo bean = new com.bit.frame.controller.DeptVo();
		bean.setDeptno(1111);
		bean.setDname("test1");
		bean.setLoc("test2");
		application.setAttribute("msg11", bean);
	%>
	<p>msg1 = <%=msg1 %></p>
	<p>msg1 = ${msg1 }</p>
	<p>pageContext = <%=pageContext.getAttribute("msg2") %></p>
	<p>pageContext = ${msg2 }</p>
	<p>request = <%=request.getAttribute("msg3") %></p>
	<p>request = ${msg3 }</p>
	<p>session = <%=session.getAttribute("msg4") %></p>
	<p>session = ${msg4 }</p>
	<p>application = <%=application.getAttribute("msg5") %></p>
	<p>application = ${msg5 }</p>
	<hr>
	<p>pageContext = ${msg6 }</p>
	<p>request = ${msg6 }</p>
	<p>session = ${msg6 }</p>
	<p>application = ${msg6 }</p>
	<p>이름이 같으면</p>
	<p>page > request > session > application</p>
	<p>pageContext = ${pageScope.msg6 }</p>
	<p>request = ${requestScope.msg6 }</p>
	<p>session = ${sessionScope.msg6 }</p>
	<p>application = ${applicationScope.msg6 }</p>
	
	<hr>
	<p>Array = ${applicationScope.msg7 }</p>
	<p>Array = ${applicationScope.msg7[0] }</p>
	<p>Array = ${applicationScope.msg7[1] }</p>
	<p>Array = ${applicationScope.msg7[2] }</p>
	<p>Array = ${applicationScope.msg7[3] }</p>
	
	<hr>
	<p>List = ${applicationScope.msg8 }</p>
	<p>List = ${applicationScope.msg8[0] }</p>
	<p>List = ${applicationScope.msg8[1] }</p>
	<p>List = ${applicationScope.msg8[2] }</p>
	<p>List = ${applicationScope.msg8[3] }</p>
	
	<hr>
	<p>Set = ${applicationScope.msg9 }</p>
	
	<hr>
	<p>Map = ${applicationScope.msg10 }</p>
	<p>Map = ${applicationScope.msg10.get("key1") }</p>
	<p>Map = ${applicationScope.msg10.get("key2") }</p>
	<p>Map = ${applicationScope.msg10.get("key3") }</p>
	
	<hr>
	<p>Object = ${applicationScope.msg11 }</p>
	<p>Object = ${applicationScope.msg11.deptno }</p>
	<p>Object = ${applicationScope.msg11.dname }</p>
	<p>Object = ${applicationScope.msg11.loc }</p>
</body>
</html>