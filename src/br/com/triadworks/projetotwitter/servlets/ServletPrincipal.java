package br.com.triadworks.projetotwitter.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.triadworks.projetotwitter.modelo.Logica;

@WebServlet("/principal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,
			HttpServletResponse response){
			
			String acao = request.getParameter("logica");
			String nomeDaClasse = "br.com.triadworks.projetotwitter.modelo." +acao+ "Logica";
			
			try{
				Class classe = Class.forName(nomeDaClasse);
				Object obj = classe.newInstance();
				
				Logica logica = (Logica) obj;
				logica.executar(request, response);
				
			} catch (Exception e){
				e.printStackTrace();
			}
			
					
		}
	}
