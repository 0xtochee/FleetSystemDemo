<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="style.css">
<s:head/>
</head>
<body>

	<div align="center">
		<h2>User Login</h2>
		<s:form action="loginAction" class="loginForm">
			<s:textfield name="userName" label="User Name" class="formTextField" />
			<s:password name="password" label="Password" class="formTextField" />
			<s:submit value="Login" class="actionBtn" />
		</s:form>
		<div class="forgot-link">
            <a href="#Forgot?">Forgot your Username or Password?</a>
        </div>
	</div>
</body>
</html>