package br.com.ifsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifsp.model.entity.Produto;
import br.com.ifsp.model.jdbc.MercadoDbManager;

public class ProdutoDaoImpl implements ProdutoDAO{
	
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void gravar(Produto produto) {
		try {
		conexao = MercadoDbManager.obterConexao();
		//conexao = ConnectionManager.getInstance().getConnection();
		pstmt = conexao
				.prepareStatement("INSERT INTO T_PRODUTO"
						+ " (NM_PRODUTO, VL_PRODUTO, DT_VALIDADE ) "
						+ "VALUES (?, ?, ?)");

		pstmt.setString(1, produto.getNome());   // Primeiro parâmetro (nome)
		pstmt.setFloat(2, produto.getValor());		// Segundo parâmetro (valor)
		java.sql.Date dtVencimento = java.sql.Date.valueOf(produto.getDataValidade());
		pstmt.setDate(3, dtVencimento); //Terceiro parâmetro (data de validade)
		pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace(); 
		}finally {
			
		try {
			pstmt.close();
			conexao.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
			
		}
	}
		
	public List<Produto> buscarTodos(){
		//Cria uma lista de produtos
		List<Produto> produtos = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			conexao = MercadoDbManager.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_PRODUTO");
			rs = pstmt.executeQuery();
		
			//Percorre todo os registros encontrados
			while(rs.next()) {
				
				java.sql.Date data = rs.getDate("DT_VALIDADE");
				var dtValidade = new java.sql.Date(data.getTime()).toLocalDate();
				//Cria um objeto Produto com as informações encontradas
				Produto produto = new Produto(rs.getInt("CD_PRODUTO"), rs.getString("NM_PRODUTO"),
						rs.getFloat("VL_PRODUTO"), dtValidade);
				// Adiciona o produto na lista
				produtos.add(produto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return produtos;
	};
	
	public Produto buscarTodosPorCodigo(int codigo) {
		ResultSet rs = null;
		Produto produto = null;
		try {
			conexao = MercadoDbManager.obterConexao();
			pstmt = conexao.prepareStatement("SELECT * FROM T_PRODUTO WHERE CD_PRODUTO = ?");
			pstmt.setInt(1, codigo); // Primeiro parâmetro (codigo)
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			java.sql.Date data = rs.getDate("DT_VALIDADE");
			var dtValidade = new java.sql.Date(data.getTime()).toLocalDate();
			//Cria um objeto Produto com as informações encontradas
			 produto = new Produto(rs.getInt("CD_PRODUTO"), rs.getString("NM_PRODUTO"),
					rs.getFloat("VL_PRODUTO"), dtValidade);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return produto;
		
	}

	public void atualizar(Produto produto) {		
		try {
			conexao = MercadoDbManager.obterConexao();
			pstmt = conexao.prepareStatement(
					"UPDATE T_PRODUTO SET NM_PRODUTO = ?, VL_PRODUTO = ?, DT_VALIDADE = ? WHERE CD_PRODUTO = ?");
			pstmt.setString(1, produto.getNome());
			pstmt.setFloat(2, produto.getValor());
			java.sql.Date dtVencimento = java.sql.Date.valueOf(produto.getDataValidade());
			pstmt.setDate(3, dtVencimento);
			pstmt.setInt(4, produto.getCodigo());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remover(int codigo) {
		
		try {
			conexao = MercadoDbManager.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM T_PRODUTO WHERE CD_PRODUTO = ?");
			pstmt.setInt(1, codigo); //Primeiro par�metro (codigo)
			pstmt.executeUpdate();			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}