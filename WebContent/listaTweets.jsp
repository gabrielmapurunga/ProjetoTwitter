<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.List" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Tweets</title>
</head>
<body>
	Lista de Tweets:
	
	<table border = "1">
		<c:forEach var="tweet" items="${lista}" varStatus="id">
			<tr  bgcolor="${id.count % 2 == 0 ? 'ff0000' : 'ffffff'}">
				<td>${tweet.usuario.login }</td>	
				
				<td>${tweet.msg}</td>
	
				<td>${tweet.dataTweet.time}</td>
			</tr>
		</c:forEach>			
	</table>
</body>
</html>