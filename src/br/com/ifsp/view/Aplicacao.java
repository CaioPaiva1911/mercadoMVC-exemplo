package br.com.ifsp.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.ifsp.controller.ControllerProduto;

import br.com.ifsp.model.entity.Produto;


public class Aplicacao {
	public static void main(String[] args) {
		
		ControllerProduto cp = new ControllerProduto();
		
		List<Produto> produtos = new ArrayList<>();
		
		var tangerina = new Produto("Tangerina", 20, LocalDate.of(2022, 02, 28));
		
		cp.cadastrarProduto(tangerina);
		
		cp.excluirProduto(6);
		
		Produto laranja = new Produto();
		
		laranja = cp.listarProdutoPorId(3);
		
		laranja.setDataValidade(LocalDate.of(2022, 03, 01));
		
		cp.atualizarProduto(laranja);
		
		System.out.println(laranja.toString()); 
		
		produtos = cp.listarTodosProdutos();
		
		produtos.forEach(produto -> System.out.println(produto.toString()));
		
	}
}
