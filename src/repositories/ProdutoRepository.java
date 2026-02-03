package repositories;

import entities.Produto;
import factories.ConnectionFactory;

/*
 * Classe para inserir, consultar, editar e excluir
 * produtos no banco de dados (CRUD)
 */
public class ProdutoRepository {
	/*
	 * Método para inserir um produto na tabela do banco de dados
	 */
	public void inserir(Produto produto) {
		try {
			// Abrir conexão com o banco de dados
			var factory = new ConnectionFactory();
			var connection = factory.obterConexao();
//Escrevendo comando SQL que será executado
//no banco de dados
			var sql = """
					INSERT INTO produtos (nome, preco, quantidade)
					VALUES(?, ?, ?)
					""";
//Preparando o comando SQL para ser executado no banco
			var statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setDouble(2, produto.getPreco());
			statement.setInt(3, produto.getQuantidade());
			statement.execute(); // Executando
			connection.close(); // Fechando a conexão com o banco
			System.out.println("\nProduto cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao inserir produto: " + e.getMessage());
		}
	}

	/*
	 * Método para atualizar um produto no banco de dados
	 */
	public void atualizar(Produto produto) {
		try {
			// Abrir conexão com o banco de dados
			var factory = new ConnectionFactory();
			var connection = factory.obterConexao();
			// Escrever o comando SQL para atualizar um produto
			var sql = """
					UPDATE produtos SET nome = ?, preco = ?,
					quantidade = ?
					WHERE id = ?
					""";
			// Executando o comando SQL no banco de dados
			var statement = connection.prepareStatement(sql);
			statement.setString(1, produto.getNome());
			statement.setDouble(2, produto.getPreco());
			statement.setInt(3, produto.getQuantidade());
			statement.setInt(4, produto.getId());
			var rowsAffected = statement.executeUpdate();

			// fechar a conexão
			connection.close();
			if (rowsAffected == 1) { // Se 1 produto foi modificado
				System.out.println("\nProduto atualizado com sucesso!");
			} else {

				System.out.println("\nNenhum produto foi atualizado.Verifique o ID informado.");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar produto: " + e.getMessage());
		}
	}

	/*
	 * Método para excluir um produto no banco de dados
	 */
	public void excluir(Integer id) {
		try {
			// Abrir conexão com o banco de dados
			var factory = new ConnectionFactory();
			var connection = factory.obterConexao();

			// Escrever o comando SQL que será executado
			// no banco de dados
			var sql = """
					DELETE FROM produtos WHERE id = ?
					""";
			// Executar o comando SQL no banco de dados
			var statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			var rowsAffected = statement.executeUpdate();
			// Fechar a conexão com o banco de dados
			connection.close();
			if (rowsAffected == 1) {
				System.out.println("\nProduto excluído com sucesso!");
			} else {
				System.out.println("\nNenhum produto foi excluído. Verifique o ID informado.");
			}
		} catch (Exception e) {
			System.out.println("\nFalha ao excluir produto: " + e.getMessage());
		}
	}

	/*
	 * Método para consultar e imprimir os dados de todos os produtos contidos no
	 * banco de dados
	 */
	public void consultar() {

		try {
			// Abrir conexão com o banco de dados
			var factory = new ConnectionFactory();
			var connection = factory.obterConexao();
			
			// Escrevendo o comando SQL que será executado
			// no banco de dados
			var sql = """
					SELECT * FROM produtos
					ORDER BY id
					""";
			// Executando o comando no banco de dados
			var statement = connection.prepareStatement(sql);
			var result = statement.executeQuery();
			
			// Percorrer cada registro obtido do banco de dados
			while (result.next()) {
				System.out.println("ID.........: " + result.getInt("id"));
				System.out.println("NOME.......: " + result.getString("nome"));
				System.out.println("PREÇO......: " + result.getDouble("preco"));
				System.out.println("QUANTIDADE.: " + result.getInt("quantidade"));
				System.out.println("...");
			}
			// Fechar a conexão com o banco de dados
			connection.close();
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar produtos: " + e.getMessage());
		}
	}
}