<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Menu sistema Caloteiro</title>
</head>
<body>
	
	<p>Seja bem vindo, ${usuarioLogado.login} ao Projeto Twitter:</p>
	<p>Menu</p>
	<p>
	<ol>
		<a href='<c:url value="/tweetar.jsp" />'> Tweetar! </a>
	</ol>
	<ol>
		<a href='<c:url value="/principal?logica=ListaTweets" />'>
			Listar Tweets </a>
	</ol>

	
</body>
</html>