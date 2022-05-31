<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<a href="${pageContext.servletContext.contextPath }/index.bit">HOME</a>
	<a href="${pageContext.servletContext.contextPath }/list.bit">EMP</a>
	<a href="${pageContext.servletContext.contextPath }/login.bit">LOGIN</a>
</nav>
	<h1>insert page</h1>
	<form method="post">
		<div>
			empno<input type="text" name="empno" id="empno">
		</div>
		<div>
			ename<input type="text" name="ename" id="ename">
		</div>
		<div>
			sal<input type="text" name="sal" id="sal">
		</div>
		<div>
			job<input type="text" name="job" id="job">
		</div>
		<button type="submit">입력</button>
	</form>

</body>
</html>