package br.com.triadworks.projetotwitter.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try{
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/projetotwitter", "root", "12345");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
}
