package com.j2d.model.bd;

import com.j2d.model.negocio.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.j2d.model.negocio.ItemHistoricoAtendimento;
import com.j2d.utils.Message;
import java.sql.ResultSet;
import java.util.Vector;

public class HistoricoAtendimentoBD {
    
        private static HistoricoAtendimentoBD singleton = null;

	BDMySql bdMySql = BDMySql.getInstance();
        
        public static HistoricoAtendimentoBD getInstance(){
		if(singleton==null){
			singleton = new HistoricoAtendimentoBD();
		}
		return singleton;
	}
	
	protected int insert(ItemHistoricoAtendimento i){
		try{
			
			PreparedStatement ps=bdMySql.getConnection().prepareStatement(
					"insert into historico_atendimento (relatorio,preco,idreserva) values(?,?,?)");

			ps.setString(1, i.getRelatorio());
			ps.setDouble(2, i.getPreco());
			ps.setInt(3, i.getReserva().getIdreserva());
			
			ps.execute();
			return Message.SUCCESS_MENSAGE;
		}catch(SQLException e){
			return Message.ERRO_MENSAGE;
		}
	}
	
	protected int delete(int id){
		try{
			PreparedStatement ps=bdMySql.getConnection().prepareStatement("delete from historico_atendimento where idhistorico_atendimento=?");
			
			ps.setInt(1, id);
			
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		}catch(SQLException e){
			return Message.ERRO_MENSAGE;
		}
		
		
	}
	
	protected int deleteByReserva(int id){
		try{
			PreparedStatement ps=bdMySql.getConnection().prepareStatement("delete from historico_atendimento where idreserva=?");
			
			ps.setInt(1, id);
			
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		}catch(SQLException e){
			return Message.ERRO_MENSAGE;
		}
		
		
	}
        
        public Vector<Cliente> getClientesAtendidos() {
		try {
			/*PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from cliente");
			ResultSet rs = ps.executeQuery*/
                        ResultSet rs = bdMySql.getStatement().executeQuery("select cliente.* from cliente, "
                                + "historico_atendimento as iha, reserva where reserva.idcliente = cliente.cpf "
                                + "and iha.idreserva = reserva.idreserva and reserva.atendido = 'true'");
			Vector<Cliente> all = new Vector<Cliente>();
                        //System.out.println("getAll()");
			while (rs.next()) {
				Cliente c = new Cliente();
				//c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
                                //System.out.println(c.getNome());
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getString("cpf"));
                                //System.out.println(rs.getString("data_nascimento"));
                                //System.out.println("-----");
                                //System.out.println(rs.getDate("data_nascimento")+""); 
				c.setData_nascimento(rs.getString("data_nascimento"));
                                //c.setData_nascimento(new Date(1230));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				
				all.add(c);

			}
                        //System.out.println("Terminou");
			return all;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Vector<Cliente>();
		}

	}
        
          public Vector<Cliente> getServicosRealizados() {
		try {
			/*PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from cliente");
			ResultSet rs = ps.executeQuery*/
                        ResultSet rs = bdMySql.getStatement().executeQuery("select distinct cliente.* from cliente,"
                                + "historico_atendimento as iha, reserva where reserva.idcliente = cliente.cpf "
                                + "and iha.idreserva = reserva.idreserva and reserva.atendido = 'true'");
			Vector<Cliente> all = new Vector<Cliente>();
                        //System.out.println("getAll()");
			while (rs.next()) {
				Cliente c = new Cliente();
				//c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
                                //System.out.println(c.getNome());
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getString("cpf"));
                                //System.out.println(rs.getString("data_nascimento"));
                                //System.out.println("-----");
                                //System.out.println(rs.getDate("data_nascimento")+""); 
				c.setData_nascimento(rs.getString("data_nascimento"));
                                //c.setData_nascimento(new Date(1230));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				
				all.add(c);

			}
                        //System.out.println("Terminou");
			return all;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Vector<Cliente>();
		}
	
}}
