package com.j2d.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.j2d.model.negocio.Cliente;
import com.j2d.utils.Message;
import java.sql.Date;

public class ClienteBD {

	BDMySql bdMySql = BDMySql.getInstance();
	
	protected int insert(Cliente c) {

		try {            
                    bdMySql.getStatement().executeUpdate("insert into cliente values ('"+c.getNome()+"', '"+c.getSobrenome()+"', '"+c.getEmail()+"' , '"+c.getData_nascimento()+"' , '"+c.getCPF()+"', '"+c.getEmail()+"', '"+c.getTelefone()+"', '"+c.getCelular()+"')");
		    return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
                        e.printStackTrace();
			return Message.ERRO_MENSAGE;
		}
	}

	protected void delete(String idcliente) {

		try {
                        bdMySql.getStatement().executeUpdate("delete from cliente where cpf = "+idcliente);
			/*PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"delete from cliente where cpf = ?");
			ps.setInt(1, idcliente);
			ps.execute();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	protected Cliente getOne(String idcliente) {
		try {
                    ResultSet rs = bdMySql.getStatement().executeQuery("select * from cliente where cpf = "+idcliente);
                    Cliente c = new Cliente();
                    while (rs.next()) {
				//c.setIdcliente(rs.getString("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getString("cpf"));
				c.setData_nascimento(rs.getString("data_nascimento"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
                                break;
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}

	protected Vector<Cliente> getAll() {
		try {
			/*PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from cliente");
			ResultSet rs = ps.executeQuery*/
                        ResultSet rs = bdMySql.getStatement().executeQuery("select * from cliente");
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

	protected int update(Cliente c) {
		try {
                    bdMySql.getStatement().executeUpdate("update cliente set nome = '"+c.getNome()+"', sobrenome = '"+c.getSobrenome()+"', endereco = '"+ c.getEndereco()+"', telefone = '"+c.getTelefone()+"', celular = '"+c.getCelular()+"' where cpf = '"+c.getCPF()+"'");	
		    return Message.SUCCESS_MENSAGE;

		} catch (SQLException e) {
			return Message.SUCCESS_MENSAGE;
		}

	}

	protected Vector<Cliente> getPage(int i,String like) {
            Vector<Cliente> all, vet;
            all = getAll();
            vet = new Vector<Cliente>();
            int j;
            for(j = 0; j < all.size(); j++){
                Cliente c = all.get(j);
                if((c.getCPF().contains(like))||(c.getNome().contains(like))||(c.getSobrenome().contains(like)))
                    vet.add(c);
            }
            return vet;
	}

	protected int getCount(String like){
		int count=0;
		try {
			ResultSet rs = bdMySql.getStatement().executeQuery("select count(*) as clientes from cliente where concat(nome,' ',sobrenome) like '%"+like+"%'  or " +
							"endereco like '%"+like+"%' or " +
							"cpf like '%"+like+"%' or " +
							"email like '%"+like+"%'");
			//ResultSet rs=ps.executeQuery();
			if(rs.next())
				count=rs.getInt("clientes");
		} catch (SQLException e) {
			
		}
		return count;
		
	}
	
	protected Vector<Cliente> getPageAniversariantes(){
		Vector<Cliente> list = new Vector();
		Vector<Cliente> all = getAll();
                java.util.Date data = new java.util.Date();
                //System.out.println("mes = "+data.getMonth());
                int i;
                for(i = 0; i < all.size(); i++){
                    if(all.get(i).getData_nascimento().getMonth() == data.getMonth()+1)
                        list.add(all.get(i));
                }
		return list;
	}
	
}
