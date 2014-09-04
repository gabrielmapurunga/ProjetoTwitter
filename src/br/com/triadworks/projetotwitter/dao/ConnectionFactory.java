package br.com.triadworks.projetotwitter.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/projetotwitter", "root", "root");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
}
