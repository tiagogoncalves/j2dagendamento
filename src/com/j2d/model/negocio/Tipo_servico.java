package com.j2d.model.negocio;

public class Tipo_servico {
	
	private int idtipo_servico;
	private String descricao;
	private double preco;
	
	
	public int getIdtipo_servico() {
		return idtipo_servico;
	}
	public void setIdtipo_servico(int idtipoServico) {
		idtipo_servico = idtipoServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

    @Override
    public String toString() {
        return "Tipo_servico{" + "idtipo_servico=" + idtipo_servico + ", descricao=" + descricao + ", preco=" + preco + '}';
    }

        
}
