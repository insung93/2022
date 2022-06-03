<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<div>
			<label for="empno">empno</label>
			<input type="text" name="empno">
		</div>
		<div>
			<label for="ename">ename</label>
			<input type="text" name="ename">
		</div>
		<div>
			<label for="sal">sal</label>
			<input type="text" name="sal">
		</div>
		<div>
			<label for="job">job</label>
			<input type="text" name="job">
		</div>
		<div>
			<button>입력</button>
		</div>
	</form>
</body>
</html>