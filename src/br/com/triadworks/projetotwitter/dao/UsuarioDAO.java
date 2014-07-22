package br.com.triadworks.projetotwitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.triadworks.projetotwitter.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	public UsuarioDAO(Connection connection){
		this.connection = connection;
	}
	
	public Usuario autentica(String login, String senha){
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where login=? and senha=?");
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			Usuario usuario = null;
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				int id = rs.getInt("id");
				String uLogin = rs.getString("login");
				String uSenha = rs.getString("senha");
				
				usuario = new Usuario();
				usuario.setId(id);
				
				usuario.setLogin(uLogin);
				usuario.setSenha(uSenha);
			}
			
			rs.close();
			stmt.close();
			return usuario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

