package br.com.ifsp.controller;

import java.util.List;

import br.com.ifsp.model.dao.ProdutoDAO;
import br.com.ifsp.model.dao.ProdutoDaoImpl;
import br.com.ifsp.model.entity.Produto;

public class ControllerProduto {
	public List<Produto> produtos;
	public Produto produto;

	private ProdutoDAO dao = new ProdutoDaoImpl();
	
	public void cadastrarProduto(Produto produto) {
	
		dao.gravar(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}
	
	public List<Produto> listarTodosProdutos(){

		produtos = dao.buscarTodos();
		
		return produtos;
	}
	
	public Produto listarProdutoPorId(int id) {
		
		produto = dao.buscarTodosPorCodigo(id);
		
		return produto;
		
	}
	
	public void atualizarProduto(Produto prod) {
		dao.atualizar(prod);
		System.out.println("Produto atualizado com sucesso!");
	}
	
	public void excluirProduto(int codigo) {
		dao.remover(codigo);
		System.out.println("Produto excluído com sucesso!");
	}
	
	
	
}
