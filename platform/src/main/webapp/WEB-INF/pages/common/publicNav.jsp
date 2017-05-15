<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="light-blue lighten-1" role="navigation">
  <div class="nav-wrapper container">
  	<a id="logo-container" href="#" class="brand-logo">Logo</a>
    <ul class="right hide-on-med-and-down">
      <li><a href="#">展示信息</a></li>
      <li><a href="/">总览</a></li>
      <li><a href="/courses">课程</a></li>
      <li><a id="header_mailbox" href="/mailbox">信箱</a></li>
      <li><a href="/message">消息</a></li>
    </ul>
    
    <ul class="side-nav" id="mobile-side-nav">
       <li><a class="waves-effect" href="/">总览</a></li>
       <li><a class="waves-effect" href="/courses">课程</a></li>
       <li><a class="waves-effect" href="/mailbox">信箱</a></li>
       <li><a class="waves-effect" href="/message">消息</a></li>
       <li><a class="waves-effect" onclick="logout()">退出</a></li>
     </ul>
  </div>
</nav>
