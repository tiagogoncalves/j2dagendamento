package com.j2d.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;




public class BDMySql {

	private static BDMySql singleton = null;
	private Connection connection = null;
        private Statement statement;

	public static BDMySql getInstance() {
		if (singleton == null) {
			singleton = new BDMySql();
		}
                return singleton;
	}

	private BDMySql() {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
                statement = connection.createStatement();
                criaBanco();
            } catch (Exception e) {
            
            }
	}
	
	public Connection getConnection(){
		return connection;
	}
        
        public Statement getStatement(){
            return statement;
        }

	
	public void fecharConexao() {
		try {
			connection.close();
		} catch (Exception e) {
		}

	}
	
	@Override
	protected void finalize() throws Throwable {
		fecharConexao();
		super.finalize();
	}
        
        private void criaBanco(){
            try{
                statement.executeUpdate("drop table if exists cliente");
                statement.executeUpdate("create table cliente (nome string, sobrenome string, endereco string, data_nascimento date, cpf string, email string, telefone string, celular string)");
                statement.executeUpdate("drop table if exists reserva");
                statement.executeUpdate("create table reserva (idreserva integer,hora string, data date, idcliente string, idtipo_servico integer, atendido boolean)");
                statement.executeUpdate("drop table if exists tipo_servico");
                statement.executeUpdate("create table tipo_servico (idtipo_servico integer, descricao string, preco double)");
                statement.executeUpdate("drop table if exists historico_atendimento");
                statement.executeUpdate("create table historico_atendimento (relatorio string, preco double, idreserva int)");
             
            }catch(Exception e){
                
            }
        }

}
