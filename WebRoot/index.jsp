<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    回话编号：<%= session.getId() %>
    
       <table>
    	<thead>
    		<tr>
    			<td>a</td>
    			<td>b</td>
    			<td>c</td>
    			<td>d</td>
    		</tr>
    	</thead>
    	
    	<tbody>
    	<c:forEach items="${list1}" var="item">
	    	<tr>
	    		<td>${item.id }</td>
    			<td>${item.DMXZWMC }</td>
    			<td>${item.DMXLX }</td>
    			<td>${item.DMXCD }</td>
	    	</tr>
    	</c:forEach>
    	</tbody>
    </table>
    
  </body>
</html>
