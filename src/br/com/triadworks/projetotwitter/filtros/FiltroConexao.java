package br.com.triadworks.projetotwitter.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.triadworks.projetotwitter.dao.ConnectionFactory;

@WebFilter(filterName="FiltroConexao", urlPatterns="/principal")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Connection conexao = new ConnectionFactory().getConnection();

		request.setAttribute("conexao", conexao);
		
		chain.doFilter(request, response);
		
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
