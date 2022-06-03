<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>hiredate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.empno }</td>
				<td>${bean.ename }</td>
				<td>${bean.hiredate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>