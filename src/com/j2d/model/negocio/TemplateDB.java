/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2d.model.negocio;

import com.j2d.model.bd.GerenteBD;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *Classe que popula o banco 
 * @author tiago
 */
public abstract class TemplateDB {
    
    public static void run(){
      
        List<Cliente> clientes = new ArrayList<>();
        List<Tipo_servico> servicos = new ArrayList<>();
        for(int i =0; i <20;i++){
            Cliente c = new Cliente();
            c.setCPF("123456"+i);
            c.setCelular("99999"+i);
            c.setData_nascimento(new Date(new java.util.Date().getTime()));
            c.setEmail("example"+i+"@example.com");
            c.setEndereco("Rua A"+i);
            c.setNome("João"+i);
            c.setSobrenome("Silva"+i);
            c.setTelefone("333333"+i);

            GerenteBD.getInstance().insert(c);
            clientes.add(c);
            
            
            Tipo_servico ts = new Tipo_servico();
            ts.setDescricao("Serviço"+i);
            ts.setIdtipo_servico(i);
            ts.setPreco(i*12);
            GerenteBD.getInstance().insert(ts);
            servicos.add(ts);
        }
        
        boolean atendido = true;
        int teto = Math.abs((int)Math.random());
            teto = teto <= 0? 10 : teto;
            teto = teto > 20? 20 : teto;
        for(int j =0;j<teto;j++){
            ItemHistoricoAtendimento iha = new ItemHistoricoAtendimento();
            iha.setId(j);
            iha.setPreco(j*teto);
            iha.setRelatorio("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                    + "Morbi quis nibh tellus. Donec luctus urna sit amet sapien aliquam rhoncus. "
                    + "Maecenas cursus diam elementum mauris tincidunt aliquet. ");
            
            atendido = !atendido;
            
            Reserva r = new Reserva();
            r.setAtendido(atendido);
            r.setData(new Date(new java.util.Date().getTime()));
            r.setHora(new Time(80000));
            r.setIdcliente(clientes.get(j).getIdcliente());
            r.setIdreserva(j);
            r.setIdtipo_servico(servicos.get(j).getIdtipo_servico());
            GerenteBD.getInstance().insert(r);
            
            iha.setReserva(r);
            GerenteBD.getInstance().insert(iha);
            
            System.out.println(iha);
        }
    }
    
    
}
