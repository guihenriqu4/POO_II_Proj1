package br.com.numbersapp.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	private BancoDeDados() {}

	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/numbersapp", "", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
