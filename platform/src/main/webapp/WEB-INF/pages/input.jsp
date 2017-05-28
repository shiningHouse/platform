<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 使用SpringMVC的form标签：
	1. WHY 使用form表单？
		可以更快速地开发出表单页面，同时可以进行表单回显

 -->
 <%@ include file="/WEB-INF/pages/common/meta.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增员工</title>
</head>
<body>

	<form:form action="${ctx}/employee/emp" method="POST" modelAttribute="employee">
		<!-- path属性对应html表单中name属性值 -->
		<c:if test="${employee.id == null}">
			LastName: <form:input path="lastName"/>
		</c:if>
		
		<c:if test="${ employee.id != null}">
			<form:hidden path="lastName"/>
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
		<br>
		Email: <form:input path="email"/>
		<br>
		<%
			Map<String, String> genders = new HashMap<>();
			genders.put("1","Male");
			genders.put("0","Female");
			request.setAttribute("genders", genders);
		%>
		Gender: <form:radiobuttons path="gender" items="${genders}"/>
		<br>
		Department: <form:select path="department.id"
			items="${departments}" itemLabel="departmentName" 
			itemValue="id"></form:select>
		<br>
		<input type="submit" value="submit"/>
	</form:form>

</body>
</html>