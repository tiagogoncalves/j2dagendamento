package com.j2d.model.negocio;

import java.sql.Date;
import java.util.List;

public class Cliente {
	
	//private int idcliente;
	private String nome;
	private String sobrenome;
	private Date data_nascimento;
	private String CPF;
	private String endereco;
	private String email;
	private String telefone,celular;
	
	public String getIdcliente() {
		return CPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date dataNascimento) {
		data_nascimento = dataNascimento;
	}
        public void setData_nascimento(String dataNascimento){
            String ano = dataNascimento.substring(0, 4);
            String mes = dataNascimento.substring(5, 7);
            String dia = dataNascimento.substring(8);   
            //System.out.println(dataNascimento+"vira "+ano+"-"+mes+"-"+dia);
            //System.out.println("int: "+Integer.parseInt(ano)+"-"+Integer.parseInt(mes)+"-"+Integer.parseInt(dia));
            java.util.Date d = new java.util.Date(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
            data_nascimento = new Date(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
            data_nascimento = new Date(d.getTime());
            //System.out.println(data_nascimento+"-"+data_nascimento.getMonth());
            
            //data_nascimento = dataNascimento;
        }
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular() {
		return celular;
	}

        @Override
        public String toString() {
            return "Cliente{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", data_nascimento=" + data_nascimento + ", CPF=" + CPF + ", endereco=" + endereco + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + '}';
        }
	
       
	
	

}
