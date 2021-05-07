<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

 <P>  The time on the server is ${serverTime}. </P>
 <h2> 서버형태 : <spring:message code="Globals.serverType" /></h2>
 
</body>
</html>
