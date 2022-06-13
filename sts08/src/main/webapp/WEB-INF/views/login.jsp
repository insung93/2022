<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../webjars/bootstrap/5.1.3/css/bootstrap.css">
<script type="text/javascript" src="../webjars/jquery/3.6.0/jquery.min.css"></script>
<script type="text/javascript" src="../webjars/bootstrap/5.1.3/js/bootstrap.min.css"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
  </div>
  <p class="navbar-text">
  	<a href="../">HOME</a>
  	<a href="../emp/">EMP</a>
  	<a href="../emp/add">EMP_ADD</a>
  	<a href="../login/">LOGIN</a>
  </p>
</nav>
<div class="container">
	<form action="./" method="post">
	  <div class="mb-3">
	    <label for="empno" class="form-label">empno</label>
	    <input type="text" class="form-control" id="empno" name="empno" placeholder="empno" value="${bean.empno }">
	  </div>
	  <div class="mb-3">
	    <label for="ename" class="form-label">ename</label>
	    <input type="text" class="form-control" id="ename" name="ename" placeholder="ename" value="${bean.ename }">
	  </div>
	  <button type="submit" class="btn btn-primary">Login</button>
	  <button type="reset" class="btn btn-default">Reset</button>
	  <button type="button" class="btn btn-default" onclick="history.back();">Back</button>
	</form>
</div>
</body>
</html>