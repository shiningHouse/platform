<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Success Page</title>
</head>
<body>
	time: ${requestScope.time}
	<br><br>
	names: ${requestScope.names} 
	<br><br>
	<h1>Success!</h1>
	<br><br>
	Request user: ${requestScope.user}
	<br><br>
	Session user: ${sessionScope.user}
	<br><br>
	Request name: ${requestScope.name}
	<br><br>
	Session name: ${sessionScope.name}
	<br><br>
	
		
	<fmt:message key="i18n.username"></fmt:message>
	<br><br>
	
	<fmt:message key="i18n.password"></fmt:message>
	<br><br>
</body>
</html>