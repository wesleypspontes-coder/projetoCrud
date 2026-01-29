package main;

import controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {
		
		//Criando um objeto da classe de controle
		var produtoController = new ProdutoController();
		
		//Executar o cadastro do produto
		produtoController.cadastrarProduto();
	}
}
