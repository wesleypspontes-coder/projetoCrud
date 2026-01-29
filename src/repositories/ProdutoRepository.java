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

			// Escrevendo comando SQL que será
			// executado no banco de dados
			var sql = """
						INSERT INTO produtos(nome, preco, quantidade)
						VALUES(?, ?, ?)
				""";

			// Preparando o comando SQL para ser
			// executado no banco
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
}
