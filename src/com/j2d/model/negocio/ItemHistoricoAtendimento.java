package com.j2d.model.negocio;

public class ItemHistoricoAtendimento {

	private Reserva reserva;
	private String relatorio;
	private double preco;
	private int id;
	
	
	public String getRelatorio() {
		return relatorio;
	}
	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public Reserva getReserva() {
		return reserva;
	}

    @Override
    public String toString() {
        return "ItemHistoricoAtendimento{" + "reserva=" + reserva + ", relatorio=" + relatorio + ", preco=" + preco + ", id=" + id + '}';
    }
        
        
	
}
