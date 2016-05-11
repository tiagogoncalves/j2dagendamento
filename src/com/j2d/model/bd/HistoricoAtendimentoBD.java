package com.j2d.model.bd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.j2d.model.negocio.ItemHistoricoAtendimento;
import com.j2d.utils.Message;

public class HistoricoAtendimentoBD {

	BDMySql bdMySql = BDMySql.getInstance();
	
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
	
}
