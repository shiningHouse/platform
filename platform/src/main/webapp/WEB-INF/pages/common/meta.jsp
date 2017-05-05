<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="defaultPageSize" value="15"/>
<c:set var="defaultPageList" value="[15,20,30]"/>
<%---设置ctx来设置请求页面的路径 --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>