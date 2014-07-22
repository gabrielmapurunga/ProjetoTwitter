package br.com.triadworks.projetotwitter.modelo;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.projetotwitter.dao.TweetDAO;

public class ListaTweetsLogica implements Logica {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Connection conexao = (Connection) request.getAttribute("conexao");
		TweetDAO dao = new TweetDAO(conexao);
		List<Tweet> lista = dao.getListaTweets();
		request.setAttribute("lista", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaTweets.jsp");
			rd.forward(request, response);

	}

}
