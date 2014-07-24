package br.com.triadworks.projetotwitter.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.triadworks.projetotwitter.dao.UsuarioDAO;

public class AutenticaUsuarioLogica implements Logica {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Usuario usuarioAutenticado = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Connection connection = (Connection) request.getAttribute("conexao");
		
		UsuarioDAO dao = new UsuarioDAO(connection);
		usuarioAutenticado = dao.autentica(login, senha);

		if (usuarioAutenticado != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("msgUsuario", "Login ou senha inválidos!");
			rd.forward(request, response);
		}

	}

}
