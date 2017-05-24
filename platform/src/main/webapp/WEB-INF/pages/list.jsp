<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>List</title>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".delete").click(function(){
			var href = $(this).attr("name");
			console.log("href="+href);
			$("form").attr("action", href).submit();			
			return false;
		});
	})
</script>
</head>
<body>

	<!-- 将post请求转为delete请求参数 -->
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form> 
	
<!-- 	
	<form action="emp/1005" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="TesetREST DELETE"/>
	</form> -->
	
	
	<c:if test="${empty requestScope.employees}">
		没有任何员工信息
	</c:if>
	<c:if test="${! empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.employees}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>${emp.gender == 0 ? 'Female' : 'Male'}</td>
					<td>${emp.department.departmentName}</td>
					<td><a href="emp/${emp.id}">Edit</a>
					<button class="edit" name="emp/${emp.id}">Edit</button></td>
					<td><a href="emp/${emp.id}" class="delete">Delete</a>
					<button class="delete" name="emp/${emp.id}">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
		
	</c:if>
	
	<br><br>
	<a href="emp"> Add New Employee</a>
</body>
</html>