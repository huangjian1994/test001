<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>主页</title>
  </head>
  
  <body>
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
    	<c:forEach items="${list}" var="item">
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
