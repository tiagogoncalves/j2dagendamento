package com.j2d.view;

import com.j2d.model.bd.ClienteBD;
import com.j2d.model.bd.HistoricoAtendimentoBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.utils.WindowManager;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RelatoriosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
        
	private JButton btnRelClientesAtendidos = null;
        private JButton btnRelClientesMaisAtendidos = null;
        private JButton btnRelServicosMaisRealizados = null;
        private JButton btnRelServicosMenosRealizados = null;
        private JButton btnRelValorVendasDoMes = null;
        private JButton btnRelValorVendasMediaPorDia = null;
        
	private JScrollPane jScrollPane = null;
	private static RelatoriosView singleton;
	
	public static RelatoriosView getInstance(){
		if(singleton==null)
			singleton=new RelatoriosView();
		
		return singleton;
	}
	
	public RelatoriosView() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(701, 385);
		this.setContentPane(getJContentPane());
		this.setTitle("Relatórios");
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints1.gridy = 0;
                        
                        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints1.gridy = 0;
                        
                        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints1.gridy = 0;
                        
                        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints1.gridy = 0;
                        
                        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints1.gridy = 0;
                        
                        GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints1.gridy = 0;
                        
			btnRelClientesAtendidos = new JButton("Clientes atendidos");
                        btnRelClientesAtendidos.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                    System.out.println("Relatório de clientes atendidos");
                                    Vector<Cliente> clientes = HistoricoAtendimentoBD.getInstance().getClientesAtendidos();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);                                   
                                    }
				}
			});
                        
                        
                        btnRelClientesMaisAtendidos = new JButton("Clientes mais atendidos");
                        btnRelClientesMaisAtendidos.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                    System.out.println("Relatório de clientes mais atendidos");
                                    Vector<Cliente> clientes = HistoricoAtendimentoBD.getInstance().getClientesAtendidos();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);                                   
                                    }
				}
			});
                        
                        btnRelServicosMaisRealizados = new JButton("Serviços mais realizados");
                        btnRelServicosMaisRealizados.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                    System.out.println("Relatório de serviços mais realizados");
                                    Vector<Cliente> clientes = HistoricoAtendimentoBD.getInstance().getClientesAtendidos();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);                                   
                                    }
				}
			});
                        
                        btnRelServicosMenosRealizados = new JButton("Serviços menos realizados");
                        btnRelServicosMenosRealizados.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                    System.out.println("Relatório de serviços menos realizados");
                                    Vector<Cliente> clientes = HistoricoAtendimentoBD.getInstance().getClientesAtendidos();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);                                   
                                    }
				}
			});
                        
                        btnRelValorVendasDoMes = new JButton("Relatório do valor das vendas por mês");
                        btnRelValorVendasDoMes.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                    System.out.println("Relatório do valor das vendas por mês");
                                    Vector<Cliente> clientes = HistoricoAtendimentoBD.getInstance().getClientesAtendidos();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);                                   
                                    }
				}
			});
                        
                        
                        btnRelValorVendasMediaPorDia = new JButton("Relatório do valor médio de vendas por dia da semana ao longo do ano");
                        btnRelValorVendasMediaPorDia.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                    System.out.println("Relatório do valor médio de vendas por dia da semana ao longo do ano");
                                    Vector<Cliente> clientes = HistoricoAtendimentoBD.getInstance().getClientesAtendidos();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);                                   
                                    }
				}
			});
                        
                        
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(btnRelClientesAtendidos, gridBagConstraints1);
                        jContentPane.add(btnRelClientesMaisAtendidos, gridBagConstraints2);
                        jContentPane.add(btnRelServicosMaisRealizados, gridBagConstraints3);
                        jContentPane.add(btnRelServicosMenosRealizados, gridBagConstraints4);
                        jContentPane.add(btnRelValorVendasDoMes, gridBagConstraints5);
                        jContentPane.add(btnRelValorVendasMediaPorDia, gridBagConstraints6);
		}
		return jContentPane;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
		}
		return jScrollPane;
	}

	
}  //  @jve:decl-index=0:visual-constraint="10,10"
