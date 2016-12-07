<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	

  </head>
  
  <body>
  <c:if test="${!empty error}">
      <c:out value="${error}"></c:out>
  </c:if>

  <form action="<c:url value="/loginCheck.html"/>" method="post">
  用户名：<input type="text" name="loginName"/>
  密码：  <input type="password" name="passWord"/>
  <input type="submit" value="登录"/>
  <input type="reset" value="重置"/>
  </form>
  </body>
</html>
