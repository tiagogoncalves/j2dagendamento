package com.j2d.model.negocio;


import java.sql.Date;
import java.sql.Time;

public class Reserva {
	
	private int idreserva;
	private Time hora;
	private Date data;
	private String idcliente;
	private int idtipo_servico;
	private boolean atendido;
	
	
	public int getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
        public void setHora(String hora){
            System.out.println(hora);
            if(hora.contains(":")){
                String h = hora.substring(0, hora.indexOf(":"));
                String m = hora.substring(hora.indexOf(":")+1, hora.lastIndexOf(":"));
                this.hora = new Time(Integer.parseInt(h),Integer.parseInt(m),0);
            }else{
                this.hora = new Time(Integer.parseInt(hora));
            }
        }
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
        public void setData(String data){
            //System.out.println("data = "+data);
            String ano = data.substring(0, 4);
            String mes = data.substring(5, 7);
            String dia = data.substring(8);   
            //System.out.println(data+"vira "+ano+"-"+mes+"-"+dia);
            java.util.Date d = new java.util.Date(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));

            this.data = new Date(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
            this.data = new Date(d.getTime());
        }
	
	public String getIdcliente() {
		return idcliente;
	}
	
	public void setIdcliente(String idcliente){
		this.idcliente = idcliente;
	}
	public void setIdtipo_servico(int idtipo_servico) {
		this.idtipo_servico = idtipo_servico;
	}
	public int getIdtipo_servico() {
		return idtipo_servico;
	}
	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}
	public boolean isAtendido() {
		return atendido;
	}

    @Override
    public String toString() {
        return "Reserva{" + "idreserva=" + idreserva + ", hora=" + hora + ", data=" + data + ", idcliente=" + idcliente + ", idtipo_servico=" + idtipo_servico + ", atendido=" + atendido + '}';
    }
        
        

}
