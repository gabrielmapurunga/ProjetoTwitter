package br.com.triadworks.projetotwitter.modelo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	void executar( HttpServletRequest request, HttpServletResponse response) throws Exception;
}
