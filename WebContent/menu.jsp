<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>In�cio Projeto Twitter</title>
</head>
<body>
	
	<p>Seja bem vindo, ${usuarioLogado.login}, ao Projeto Twitter:</p>
	
	<ol>
		<a href='<c:url value="/tweetar.jsp" />'> Tweetar! </a>
	</ol>

	Lista de Tweets:
	
	<table border = "1">
		<c:forEach var="tweet" items="${lista}" varStatus="id">
			<tr  bgcolor="${id.count % 2 == 0 ? 'ff0000' : 'ffffff'}">
				<td>${tweet.usuario.login }</td>	
				
				<td>${tweet.msg}</td>
	
				<td>${tweet.dataTweet.time}</td>
				
				<td>
				<form method="post" action="Retweetar">
						<input type="hidden" value="${tweet.idTweet }" id=idTweet name=idTweet>
						
				<a href='<c:url value="/principal?logica=Retweetar" />'> Retweetar! </a>
				</form>
				</td>
				
			</tr>
		</c:forEach>			
	</table>
	
</body>
</html>