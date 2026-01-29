package controllers;

import java.util.Scanner;

import entities.Produto;
import repositories.ProdutoRepository;

/*
 * Classe para fazer as capturas dados
 * preenchidos pelo usuário do sistema
 */

public class ProdutoController {

	/*
	 * Método para fazer a captura do cadastro do produto
	 */
	public void cadastrarProduto() {

		var scanner = new Scanner(System.in);

		// Criando um objeto da classe Produto
		var produto = new Produto();

		// Capturando o nome
		System.out.print("NOME DO PRODUTO....: ");
		produto.setNome(scanner.nextLine());

		// Capturando o preço
		System.out.print("PREÇO..............: ");
		produto.setPreco(Double.parseDouble(scanner.nextLine()));

		// Capturando a quantidade
		System.out.print("QUANTIDADE.........: ");
		produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

		// Criando um objeto da classe ProdutoRepository
		var produtoRepository = new ProdutoRepository();

		// Inserindo o produto no banco de dados
		produtoRepository.inserir(produto);

		scanner.close();
	}

}
