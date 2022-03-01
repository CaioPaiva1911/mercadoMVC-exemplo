package br.com.ifsp.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private float valor;
	private LocalDate dataValidade;
	
	public Produto(String nome, float valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Produto(String nome, float valor, LocalDate dataValidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.dataValidade = dataValidade;
	}
	
	public Produto(int codigo, String nome, float valor, LocalDate dataValidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dataValidade = dataValidade;
	}
	
	public Produto () {};

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	};
	
	@Override
	public String toString() {
		Date date = Date.valueOf(getDataValidade());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String data = format.format(date);
		return "Produto [codigo=]" + codigo
			+ ", nome=" + nome
			+ ", valor=" + valor
			+ ", dataValidade="
			+ data + "]";
	}
	
	
	public static void main(String[] args) {
		
		Produto p = new Produto();
		var data = LocalDate.of(2022, 02, 28);
		
		p.setCodigo(1);
		p.setDataValidade(data);
		p.setNome("Avocado");
		p.setValor(serialVersionUID);
		
	System.out.println(p.toString());	
	}
	

	
}
