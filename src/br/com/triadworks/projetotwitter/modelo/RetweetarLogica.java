package br.com.triadworks.projetotwitter.modelo;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.triadworks.projetotwitter.dao.TweetDAO;

public class RetweetarLogica implements Logica {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int idTweet = Integer.parseInt(request.getParameter("idTweet"));
		
		HttpSession sessao = request.getSession();
		Usuario usuarioRemetente = (Usuario) sessao.getAttribute("usuarioLogado");
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		TweetDAO dao = new TweetDAO(conexao);
		
		dao.Retweetar(idTweet, usuarioRemetente);
		
		List<Tweet> tweets = dao.getListaTweets();
		
		sessao.setAttribute("tweet", tweets);

	}

}
