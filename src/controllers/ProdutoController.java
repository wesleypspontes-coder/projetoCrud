package controllers;

import java.util.Scanner;

import entities.Produto;
import repositories.ProdutoRepository;

/*
 * Classe para fazer as capturas dados
 * preenchidos pelo usuário do sistema
 */

public class ProdutoController {

	// Atributos
	private Scanner scanner = new Scanner(System.in);

	/*
	 * Método para gerar um menu de opções
	 */
	public void gerenciarProdutos() {
		System.out.println("*** PROJETO CRUD DE PRODUTOS ***");
		System.out.println("(1) CADASTRAR PRODUTO");
		System.out.println("(2) ATUALIZAR PRODUTO");
		System.out.println("(3) EXCLUIR PRODUTO");
		System.out.println("(4) CONSULTAR PRODUTO");

		System.out.print("\nINFORME A OPÇÃO DESEJADA:");
		var opcao = scanner.nextLine();

		switch (opcao) {
		case "1":
			cadastrarProduto();
			break;
		case "2":
			atualizarProduto();
			break;
		case "3":
			excluirProduto();
			break;
		case "4":
			consultarProdutos();
			break;
		default:
			System.out.println("\nOPÇÃO INVALIDA!");
			break;
		}
	}

	/*
	 * Método para fazer a captura do cadastro do produto
	 */
	private void cadastrarProduto() {

		System.out.println("\nCADASTRO DE PRODUTO:\n");

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

	}

	/*
	 * Método para fazer a captura do cadastro do produto
	 */
	private void atualizarProduto() {

		System.out.println("\nATUALIZAÇÃO DE PRODUTO:\n");

		// Criando um objeto da classe Produto
		var produto = new Produto();

		// Capturando o id do produto
		System.out.print("ID DO PRODUTO......:");
		produto.setId(Integer.parseInt(scanner.nextLine()));

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

		// Atualizando o produto no banco de dados
		produtoRepository.atualizar(produto);

	}

	/*
	 * Método para fazer a captura do cadastro do produto
	 */

	private void excluirProduto() {

		System.out.println("\nEXCLUSÃO DE PRODUTO:\n");

		//Capturando o id do produto
		System.out.println("ID DO PRODUTO......:");
		var id = Integer.parseInt(scanner.nextLine());

		// Criando um objeto da classe ProdutoRepository
		var produtoRepository = new ProdutoRepository();

		//Atualizando o produto no banco de dados
		produtoRepository.excluir(id);

	}
	
	/*
	 * Método para fazer a consulta dos produtos
	 */
	private void consultarProdutos() {
		
		System.out.println("\nCONSULTA DE PRODUTOS:\n");
		
		//Criando um objeto da classe ProdutoRepository
		var produtoRepository = new ProdutoRepository();
		
		//Executar a consulta de produtos
		produtoRepository.consultar();
		
	}
	
}

