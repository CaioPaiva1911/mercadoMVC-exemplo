package br.com.ifsp.model.dao;

import java.util.List;
import br.com.ifsp.model.entity.Produto;

public interface ProdutoDAO {
	
	void gravar(Produto produto);
	
	List<Produto> buscarTodos();
	
	Produto buscarTodosPorCodigo(int codigo);
	
	void atualizar(Produto produto);
	
	void remover(int codigo);
}