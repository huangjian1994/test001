<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>01</h1>
	<!--  <%@include file="index.jsp"%>-->
	<jsp:useBean id="time" class="java.util.Date">
		<jsp:setproperty name="time" property="hours" param="hh"/>
		<jsp:setproperty name="time" property="minutes" param="mm"/>
		<jsp:setproperty name="time" property="seconds" param="ss"/>
		
	</jsp:useBean>
	<br> 
	设置属性的时间：${time} 
</body>
</html>