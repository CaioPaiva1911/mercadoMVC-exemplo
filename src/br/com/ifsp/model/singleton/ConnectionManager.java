package br.com.ifsp.model.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	//Atributo que armazena a unica instancia de ConnectionManager
	private static ConnectionManager instance;
	static String dbUrl = "jdbc:mysql://localhost:3306/mercado";
	static String user = "root";
	static String password = "";
	
	//Construtor privado
	private ConnectionManager() {}

	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public Connection getConnection() {
		//Implementação
		Connection conexao = null;
		try {
			conexao = (Connection) DriverManager.getConnection(dbUrl, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
