<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tweetar</title>
</head>
<body>
	<p>Digite sua mensagem de no máximo 140 caracteres: </p>
	
	<form action="principal" method="post">
				<input type="hidden" name="logica" value="Tweetar"/>
				
				<input type="text" maxlength="140" value="msg">
				
				<input type="submit" value="Salvar"/>
	</form>			
</body>
</html>