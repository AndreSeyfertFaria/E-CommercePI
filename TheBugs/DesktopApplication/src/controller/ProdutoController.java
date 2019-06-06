package controller;
import java.util.List;

import entities.Produto;
import model.ProdutoModel;
public class ProdutoController {

	public static void cadastrarProduto(String codigoProduto, String descricao, String marca, String unidade, String nomeImagem ) {
		ProdutoModel.cadastrarProduto(codigoProduto, descricao, marca, unidade, nomeImagem);
	}
	
	public static List<Produto> listarProdutos() {
		return ProdutoModel.listarProdutos();
	}
}
