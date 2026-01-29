package factories;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe para conexão com o banco de dados
 */

public class ConnectionFactory {

	/*
	 * Método destinado a abrir conexão com um banco de dados PostgreSQL
	 */
	public Connection obterConexao() {
		try {

			// Variáveis
			var host = "jdbc:postgresql://localhost:5432/bdaula03";
			var user = "postgres";
			var pass = "coti";

			// Retornar a conexão com o banco de dados
			return DriverManager.getConnection(host, user, pass);
		} 
		catch (Exception e) {
			System.out.println("\nFalha ao conectar com o PostgreSQL: " + e.getMessage());
			return null; // Retornar vazio
		}
	}
}
