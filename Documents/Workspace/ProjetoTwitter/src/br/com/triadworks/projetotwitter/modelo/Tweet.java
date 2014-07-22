package br.com.triadworks.projetotwitter.modelo;

import java.util.Calendar;
import java.util.Date;

public class Tweet {

	private int id;
	private Usuario usuario;
	private String msg;
	private String resposta;
	private Calendar dataTweet;
	
	
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Calendar getDataTweet() {
		return dataTweet;
	}
	public void setDataTweet(Calendar dataDivida) {
		this.dataTweet = dataDivida;
	}
	
}
