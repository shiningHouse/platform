<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TestSpringMVC Home</title>
<script type="text/javascript" src="/platform/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#testJson").click(function(){
			console.log(" testJson click");
			var url = "http://localhost:8080/platform/testSpringMVC/testJson";
			var args = {};
			$.post(url, args, function(data, status){
				$("#testJsonResponse").text(JSON.stringify(data));
				console.log("getResponse, data="+JSON.stringify(data)+",status="+status);
			});
		});
		
	})

</script>
</head>
<body>


	<a href="testRedirect"> 重定向Redirect</a>
	<br><br>

	<a href="excelView"> 自定义视图Excel View</a>
	<br><br>
	

	<a href="helloView"> 自定义视图Hello View</a>
	<br><br>
	

	<fmt:message key="i18n.username"></fmt:message>
	<br><br>
	
	<fmt:message key="i18n.password"></fmt:message>
	<br><br>

	<!-- 
		关于国际化
		1. 首先可以根据浏览器语言，对文本，时间，数值进行本地化处理
		2. 可以在Bean中获取国际化资源文件
		3. 可以根据超链接切换Locale, 而不再依赖于浏览器的语言设置
		
		解决方法：
		1. 使用JSTL的fmt标签
		2. 在bean中注入ResourceBundleMessageSource的示例，使用其对应的getMessage犯法即可
		3. 配置LocalResolver和LocaleChangeInterceptor
		
	 -->

	<button id="testJson">testJson</button>
	<p id="testJsonResponse">testJsonResponse</p>
	<br><br>
	
	<a href="testSessionAttribute"> testSessionAttribute</a>
	<br><br>
	<a href="testMap"> testMap</a>
	<br><br>
	<a href="testModelAndView"> testModelAndView</a>
	<br><br>
	<form action="testPOJO" method="POST">
		username: <input type="text" name="username">
		<br>
		password: <input type="password" name="password">
		<br>
		province: <input type="text" name="address.province">
		<br>
		city: <input type="text" name="address.city">
		<br>
		<input type="submit" value="testPOJO">
	</form>
	
	<br>
	<a href="testRequestParam">testRequestParam</a>

	<br><br>
	<form action="testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="TesetREST DELETE"/>
	</form>
	
	<br><br>
	<form action="testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="TesetREST PUT"/>
	</form>
	
	<br><br>
		<form action="testRest/1" method="post">
		<input type="hidden" name="_method" value="GET">
		<input type="submit" value="TesetREST GET"/>
	</form>
	<br><br>
	
	<br><br>
		<form action="testRest" method="post">
		<input type="hidden" name="_method" value="POST">
		<input type="submit" value="TesetREST POST"/>
	</form>
	<br><br>
	
	<form action="testRequestMethod" method="POST">
		testRequestMethod POST REQ
		<input type="submit" value="submit"/>
	</form>
	<br><br>
	
	<a href="testRequestMethod">testRequestMethod</a>
	<br><br>
	
	<a href="testRequestMapping?username=hdy">testRequestMapping</a>
	<br><br>
http://localhost:8080/platform/testSpringMVC/testRequestParam
http://localhost:8080/platform/testSpringMVC/testRequestParam
http://localhost:8080/platform/testSpringMVC/testRequestMethod
</body>
</html>