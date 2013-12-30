<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="WEB-INF/jsp/layout/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />">

<script src="<c:url value="/resources/js/jquery-2.0.3.min.js" />"></script>

<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>

<link rel="stylesheet"
	href="<c:url value="/resources/css/signin.css" />">

<form action='/j_spring_security_check' method='post' class="form-signin">
	<h2 class="form-signin-heading">Please Sign In:</h2>
	<input type='text' name='j_username' placeholder='Username' class="form-control" />
	<input type='password' name='j_password' placeholder="Password" class="form-control" />
	<input type='submit' class="btn btn-lg btn-primary btn-block" />
</form>

</div>
<!-- /container -->

</body>
</html>