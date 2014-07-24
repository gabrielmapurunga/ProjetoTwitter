<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Acessar Projeto Twitter</title>
</head>
<body>
	<form action="principal?logica=AutenticaUsuario" method="post"
		id="formLogar">
		Login: <input type="text" name="login" value="" /> 
		Senha: <input type="password" name="senha" value="" /> 
		<input type="submit" value="Logar" />
	</form>
	<p>${msgUsuario}</p>
	
</body>
</html>