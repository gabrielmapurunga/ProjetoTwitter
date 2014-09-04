package br.com.triadworks.projetotwitter.modelo;

import java.util.Calendar;

import br.com.triadworks.projetotwitter.modelo.Usuario;

public class Tweet {

	private int id;
	private Usuario usuario;
	private boolean respondendo;
	private int idTweetRespondido;
	private String msg;
	private Calendar dataTweet;
	
	public Tweet(Usuario usuario, String msg, Calendar dataTweet) {
		super();
		this.usuario = usuario;
		this.msg = msg;
		this.setDataTweet(dataTweet);
		this.setRespondendo(false);
		setIdTweetRespondido(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isRespondendo() {
		return respondendo;
	}

	public void setRespondendo(boolean respondendo) {
		this.respondendo = respondendo;
	}

	public int getIdTweetRespondido() {
		return idTweetRespondido;
	}

	public void setIdTweetRespondido(int idTweetRespondido) {
		this.idTweetRespondido = idTweetRespondido;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Calendar getDataTweet() {
		return dataTweet;
	}

	public void setDataTweet(Calendar dataTweet) {
		this.dataTweet = dataTweet;
	}
}


	
	