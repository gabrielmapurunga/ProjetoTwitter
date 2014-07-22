package br.com.triadworks.projetotwitter.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.triadworks.projetotwitter.modelo.Tweet;
import br.com.triadworks.projetotwitter.modelo.Usuario;

public class TweetDAO {
	
	private Connection conexao;
	
	public TweetDAO(){
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void Twittar(Tweet tweet) {
		String sql = "insert into tweet" +
					"(usuario, msg, resposta, dataTweet)" +
					"values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, tweet.getMsg());
			pstmt.setInt(2, tweet.getUsuario().getId());
			pstmt.setString(3, tweet.getResposta());
			pstmt.setDate(4, new Date(tweet.getDataTweet().getTimeInMillis()));
			
			pstmt.execute();
			pstmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tweet> getLista(){
		try{
			PreparedStatement pstmt = this.conexao.prepareStatement("select * from tweet "
					+ "join usuario on tweet.usuario_id = usuario.idusuario");
			
			List<Tweet> tweets = new ArrayList<Tweet>();
			Tweet tweet = null;
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				String msg = rs.getString("msg");
				String usuario = rs.getString("usuario");
				String resposta = rs.getString("resposta");
				String login = rs.getString("login");
				
				Calendar dataTweet = Calendar.getInstance();
				dataTweet.setTime(rs.getDate("dataTweet"));
				
				tweet = new Tweet();
				tweet.setDataTweet(dataTweet);
				tweet.setMsg(msg);
				
			
			}

			rs.close();
			pstmt.close();
			return tweets;
			
			}catch(SQLException e){
				e.printStackTrace();
			}
	}	
}	