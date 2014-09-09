package br.com.triadworks.projetotwitter.modelo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import br.com.triadworks.projetotwitter.dao.TweetDAO;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



public class TweetarLogica implements Logica {
	

	private String getData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		String dataTweet = getData();
		Calendar dataTweetConvertida = null;
		
		try{
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTweet);
			dataTweetConvertida = Calendar.getInstance();
			dataTweetConvertida.setTime(data);
		} catch (ParseException e){
			out.println("Erro de conversão de data");
		}
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		
		String msg = request.getParameter("msg");
		
		Tweet tweet = new Tweet(usuario, msg, dataTweetConvertida);
		
		Connection conexao = (Connection) request.getAttribute("conexao");
		TweetDAO dao = new TweetDAO(conexao);
		dao.Tweetar(tweet);
		
		RequestDispatcher rd = request.getRequestDispatcher("/tweet-enviado.jsp");
		rd.forward(request, response);
	}

}
