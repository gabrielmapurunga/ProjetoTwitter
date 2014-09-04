package br.com.triadworks.projetotwitter.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.triadworks.projetotwitter.modelo.Tweet;
import br.com.triadworks.projetotwitter.modelo.Usuario;

public class TweetDAO {
	
	private Connection conexao;
	
	public TweetDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public void Tweetar(Tweet tweet) {
		String sql = "insert into tweet" +
					"(msg, resposta, idUsuario, idTweetRespondido, dataTweet)" +
					"values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, tweet.getMsg());
			pstmt.setBoolean(2, tweet.isRespondendo());
			pstmt.setInt(3, tweet.getUsuario().getId());
			pstmt.setInt(4, tweet.getIdTweetRespondido());
			pstmt.setDate(5, new Date(tweet.getDataTweet().getTimeInMillis()));
			
			pstmt.execute();
			pstmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List <Tweet> getListaTweets(){
		
			PreparedStatement pstmt;
			List<Tweet> tweets = new ArrayList<Tweet>();
			
			try {
				pstmt = this.conexao.prepareStatement("select * from tweet, usuario "
						+ "where tweet.idUsuario = usuario.id order by tweet.dataTweet desc");
				
				Usuario usuario = null;
				Tweet tweet = null;
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
					String msg = rs.getString("msg");
					Calendar dataTweet = Calendar.getInstance();
					dataTweet.setTime(rs.getDate("dataTweet"));
					
					usuario = new Usuario();
					usuario.setLogin(rs.getString("login"));
					
					tweet = new Tweet(usuario, msg, dataTweet);
					tweet.setId(rs.getInt("idTweet"));
					tweet.setRespondendo(rs.getBoolean("resposta"));
					tweet.setIdTweetRespondido(rs.getInt("idTweetRespondido"));
					
					tweets.add(tweet);
				}
				
				rs.close();
				pstmt.close();
				return tweets;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	public void Retweetar(int idTweet, Usuario usuarioRemetente){
	
		try{
			PreparedStatement pstmt = this.conexao.prepareStatement("select * from tweet, usuario"
					+ " where tweet.idUsuario = usuario.id and tweet.idTweet ="+idTweet+ " order  by tweet.dataTweet desc");
			
			ResultSet rs = pstmt.executeQuery();
			
			String msg = rs.getString("msg");
			Calendar dataTweet = Calendar.getInstance();
			dataTweet.setTime(rs.getDate("dataTweet"));
			
			Usuario usuarioOriginal = new Usuario();
			usuarioOriginal.setLogin(rs.getString("login"));
			
			Tweet tweet = new Tweet(usuarioOriginal, msg, dataTweet);
			tweet.setId(rs.getInt("idTweet"));
			tweet.setRespondendo(rs.getBoolean("resposta"));
			tweet.setIdTweetRespondido(rs.getInt("idTweetRespondido"));
			
			tweet.setMsg("RT> @"+ tweet.getUsuario().getLogin() + " / " + tweet.getMsg());
			tweet.setUsuario(usuarioRemetente);
			Tweetar(tweet);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}	