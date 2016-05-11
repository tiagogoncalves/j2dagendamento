package com.j2d.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Tipo_servico;
import com.j2d.utils.WindowManager;

public class ServicoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private final static int NUM_REG=40; 
	private JPanel jContentPane = null;
	private JLabel lbl_search = null;
	private JTextField txt_search = null;
	private JButton bt_search = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_servicos = null;
	private JButton bt_new = null;
	private JButton bt_editar = null;
	private JButton bt_back = null;
	private JButton bt_next = null;
	private int currentPage=1;
	private String currentSearch="";
	private Vector<Tipo_servico> currentServicos;
	private static ServicoView singleton;
	private JButton bt_delete = null;
	
	public static ServicoView getInstance(){
		if(singleton==null)
			singleton=new ServicoView();
		
		return singleton;
	}
	
	public ServicoView() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(701, 385);
		this.setContentPane(getJContentPane());
		this.setTitle("Serviços");
		this.atualizaTable(GerenteBD.getInstance().getPageServico(currentPage, currentSearch));
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 2;
			gridBagConstraints11.insets = new Insets(0, 0, 3, 0);
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 4;
			gridBagConstraints7.gridy = 2;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 3;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridy = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.fill = GridBagConstraints.NONE;
			gridBagConstraints5.weightx = 0.0;
			gridBagConstraints5.insets = new Insets(0, 4, 3, 0);
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(0, 0, 3, 0);
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.gridwidth = 5;
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.weightx = 0.4;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.3;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 6, 0, 0);
			gridBagConstraints.gridy = 0;
			lbl_search = new JLabel();
			lbl_search.setText("Procurar: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_search, gridBagConstraints);
			jContentPane.add(getTxt_search(), gridBagConstraints1);
			jContentPane.add(getBt_search(), gridBagConstraints2);
			jContentPane.add(getJScrollPane(), gridBagConstraints3);
			jContentPane.add(getBt_new(), gridBagConstraints4);
			jContentPane.add(getBt_editar(), gridBagConstraints5);
			jContentPane.add(getBt_back(), gridBagConstraints6);
			jContentPane.add(getBt_next(), gridBagConstraints7);
			jContentPane.add(getBt_delete(), gridBagConstraints11);
		}
		return jContentPane;
	}

	private JTextField getTxt_search() {
		if (txt_search == null) {
			txt_search = new JTextField();
			txt_search.addKeyListener(new java.awt.event.KeyAdapter() { 
							public void keyPressed(KeyEvent e) {    
								if(e.getKeyChar()=='\n'){
									currentPage=1;
									currentSearch=txt_search.getText();
									atualizaTable(GerenteBD.getInstance().getPageServico(1, currentSearch));
								}
							}
						});
		}
		return txt_search;
	}

	private JButton getBt_search() {
		if (bt_search == null) {
			bt_search = new JButton();
			bt_search.setText("Procurar...");
			bt_search.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage=1;
					currentSearch=txt_search.getText();
					atualizaTable(GerenteBD.getInstance().getPageServico(1, currentSearch));
				}
			});
		}
		return bt_search;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_servicos());
		}
		return jScrollPane;
	}

	private JTable getTb_servicos() {
		if (tb_servicos == null) {
			tb_servicos = new JTable();
			tb_servicos.setModel(
					new DefaultTableModel(new Object[NUM_REG][2]
			                     , new String[]{"Serviço","Valor"}));
		}
		
		return tb_servicos;
	}

	private JButton getBt_new() {
		if (bt_new == null) {
			bt_new = new JButton();
			bt_new.setText("Novo");
			bt_new.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					WindowManager.open(ServicoForm.getInstance());
				}
			});
		}
		return bt_new;
	}

	private JButton getBt_editar() {
		if (bt_editar == null) {
			bt_editar = new JButton();
			bt_editar.setText("Editar");
			bt_editar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l=tb_servicos.getSelectedRow();
					if(l>-1){
						try{
							Tipo_servico t=currentServicos.get(l);
							WindowManager.open(ServicoForm.getInstance(t.getIdtipo_servico()));
						}catch(IndexOutOfBoundsException ex){}
					}
				}
			});
		}
		return bt_editar;
	}

	private JButton getBt_back() {
		if (bt_back == null) {
			bt_back = new JButton();
			bt_back.setText("<");
			bt_back.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage--;
					atualizaTable(GerenteBD.getInstance().getPageServico(currentPage,currentSearch));
				}
			});
		}
		return bt_back;
	}

	private JButton getBt_next() {
		if (bt_next == null) {
			bt_next = new JButton();
			bt_next.setText(">");
			bt_next.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage++;
					atualizaTable(GerenteBD.getInstance().getPageServico(currentPage,currentSearch));
				}
			});
		}
		return bt_next;
	}

	public void atualizaTable(Vector<Tipo_servico> servicos){
		Object[][]table=new Object[NUM_REG][2];
		int i=0;
		for(Tipo_servico s:servicos){
			table[i][0]=s.getDescricao();
			table[i][1]=s.getPreco();
			
						
			i++;
		}
		
		tb_servicos.setModel(new javax.swing.table.DefaultTableModel(table,
				    new String [] {
				        "Serviço","Preço"
				     }
		));
		tb_servicos.updateUI();
		if(currentPage==1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);
		
		
		int num_clientes=GerenteBD.getInstance().getCountServico(currentSearch);
		int maxPage=num_clientes/NUM_REG+1;
		
		if(currentPage==maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);
		
		currentServicos=servicos;
	}
	
	private JButton getBt_delete() {
		if (bt_delete == null) {
			bt_delete = new JButton();
			bt_delete.setText("Excluir");
			bt_delete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l=tb_servicos.getSelectedRow();
					if(l>-1){
						try{
							Tipo_servico t=currentServicos.get(l);
							GerenteBD.getInstance().deleteServico(t.getIdtipo_servico());
							
							atualizaTable(GerenteBD.getInstance().getPageServico(currentPage, currentSearch));
						}catch(IndexOutOfBoundsException ex){}
					}
				}
			});
		}
		return bt_delete;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
