package br.com.ifsp.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MercadoDbManager {
	
	
	static String dbUrl = "jdbc:mysql://localhost:3306/mercado?useSSL=false";
	static String user = "root";
	static String password = "";
	
	public static Connection conexao = null;
	
	public static Connection obterConexao() {
		try {
			// Define o Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			// Interface JDBC cuja implementao DriverManager abre uma conexão com um URL
			// definida pelo banco
			conexao = (Connection) DriverManager.getConnection(dbUrl, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Conectou");
		return conexao;
	}

}
