package com.j2d.model.bd;

import java.sql.Date;
import java.util.Vector;

import com.j2d.model.negocio.Cliente;
import com.j2d.model.negocio.ItemHistoricoAtendimento;
import com.j2d.model.negocio.Reserva;
import com.j2d.model.negocio.Tipo_servico;

public class GerenteBD {
	
	public final static int NUM_REG=40; 
	private static GerenteBD singleton;
	private ClienteBD clienteBD;
	private Tipo_servicoBD tiposervicoBD;
	private ReservaBD reservaBD;
	private HistoricoAtendimentoBD historicoAtendimentoBD;
	
	public static GerenteBD getInstance(){
		if(singleton==null)
			singleton=new GerenteBD();
		
		return singleton;
	}
	
	private GerenteBD(){
		clienteBD=new ClienteBD();
		tiposervicoBD=new Tipo_servicoBD();
		reservaBD=new ReservaBD();
		historicoAtendimentoBD=new HistoricoAtendimentoBD();
	}
	
	public int insert(Cliente c){
		return clienteBD.insert(c);
	}
	
	 public Cliente getOneCliente(String idcliente){
		 return clienteBD.getOne(idcliente);
	 }
	 
	 public int update(Cliente c){
		 return clienteBD.update(c);
	 }
	
	 public Vector<Cliente> getPage(int i,String like){
		 return clienteBD.getPage(i,like);
	 } 
	 
	 public Vector<Cliente>getPageAniversariantes(){
		 return clienteBD.getPageAniversariantes();
	 }
	 
	 public int getCountClientes(String like){
		 return clienteBD.getCount(like);
	 }
	 
	 public int insert(Tipo_servico ts){
		 return tiposervicoBD.insert(ts);
	 }
	 
	 public int update(Tipo_servico ts){
		 return tiposervicoBD.update(ts);
	 }
	 
	 public Tipo_servico getOneTipoServico(int id){
		 return tiposervicoBD.getOne(id);	 
	 }
	 
	 public Vector<Tipo_servico> getPageServico(int i,String like){
		 return tiposervicoBD.getPage(i, like);
	 }
	 
	 public int getCountServico(String like){
		 return tiposervicoBD.getCount(like);
	 }
	 
	 public int deleteServico(int idservico){
		 return tiposervicoBD.delete(idservico);
	 } 
	 
	 public int insert(Reserva r){
		 return reservaBD.insert(r);
	 }
	 
	 public int update(Reserva r){
		 return reservaBD.update(r);
	 }
	 
	 public Reserva getOneReserva(int idreserva){
		 return reservaBD.getOne(idreserva);
	 }
	 
	 public Vector<Reserva> getNextReserva(String like,int i,boolean atendido,Date data){
		 return reservaBD.getNext(like, i, atendido,data);
	 }
	 
	 public int getCountReserva(String like,boolean atendido,Date data){
		 return reservaBD.getCount(like, atendido,data);
	 }
	 
	 public int insert(ItemHistoricoAtendimento i){
		 return historicoAtendimentoBD.insert(i);
	 }
	 
	 public int deleteItemHistoricoAtendimento(int id){
		 return historicoAtendimentoBD.delete(id);
	 }
	 
	 public int deleteItemHistoricoAtendimentoByReserva(int id){
		 return historicoAtendimentoBD.deleteByReserva(id);
	 }
         
         public void deleteReserva(int idReserva){
             reservaBD.delete(idReserva);
         }
         
         public Vector<Reserva> getReservas(Cliente c){
             Vector<Reserva> v = reservaBD.getAll();
             Vector<Reserva> res = new Vector<Reserva>();
             int i;
             for(i = 0; i < v.size(); i++){
                 if(v.get(i).getIdcliente().equals(c.getCPF()))
                     res.add(v.get(i));
             }
             return res;
         }
}
