package com.j2d.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.utils.WindowManager;
import java.sql.Date;

public class ClientesFrame extends JFrame {

	private static ClientesFrame singleton;  //  @jve:decl-index=0:visual-constraint="167,383"
	private static final long serialVersionUID = 1L;
	private final static int NUM_REG=40; 
	private JPanel jContentPane = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_pesquisa = null;
	private JButton bt_serach = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_clientes = null;
	private JButton bt_new = null;
	private JButton bt_info = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private int currentPage=1;
	private Vector<Cliente> currentClientes;  //  @jve:decl-index=0:
	private String currentSearch="";  //  @jve:decl-index=0:

	public static ClientesFrame getInstance(){
		if(singleton==null){
			singleton = new ClientesFrame();
		}
		return singleton;
	}
	
	private ClientesFrame() {
		super();
		initialize();
		atualizaTable(GerenteBD.getInstance().getPage(currentPage,txt_pesquisa.getText()));
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private void initialize() {
		this.setSize(830, 350);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Clientes");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 3;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.insets = new Insets(5, 0, 5, 5);
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints3.gridy = 2;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.insets = new Insets(5, 7, 5, 0);
			gridBagConstraints21.gridy = 2;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridwidth = 4;
			gridBagConstraints11.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.weightx = 0.7;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.15;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.insets = new Insets(7, 0, 5, 0);
			gridBagConstraints.gridy = 0;
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_procurar, gridBagConstraints);
			jContentPane.add(getTxt_pesquisa(), gridBagConstraints1);
			jContentPane.add(getBt_serach(), gridBagConstraints2);
			jContentPane.add(getJScrollPane(), gridBagConstraints11);
			jContentPane.add(getBt_new(), gridBagConstraints21);
			jContentPane.add(getBt_info(), gridBagConstraints3);
			jContentPane.add(getBt_next(), gridBagConstraints4);
			jContentPane.add(getBt_back(), gridBagConstraints5);
		}
		return jContentPane;
	}

	private JTextField getTxt_pesquisa() {
		if (txt_pesquisa == null) {
			txt_pesquisa = new JTextField();
						txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() { 
							public void keyPressed(KeyEvent e) {    
								if(e.getKeyChar()=='\n'){
									currentPage=1;
									currentSearch=txt_pesquisa.getText();
									atualizaTable(GerenteBD.getInstance().getPage(1, currentSearch));
								}
							}
						});
		}
		return txt_pesquisa;
	}

	private JButton getBt_serach() {
		if (bt_serach == null) {
			bt_serach = new JButton();
			bt_serach.setText("Procurar...");
			bt_serach.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage=1;
					currentSearch=txt_pesquisa.getText();
					atualizaTable(GerenteBD.getInstance().getPage(1, currentSearch));
				}
			});
		}
		return bt_serach;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_clientes());
		}
		
		return jScrollPane;
	}

	private JTable getTb_clientes() {
		if (tb_clientes == null) {
			tb_clientes = new javax.swing.JTable();

			tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
			    new Object [][] {
			    	{null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			        {null, null, null, null,null,null},
			    },
			    new String [] {
			        "Cliente", "CPF", "Telefone", "Endereço","E-mail","Data Nascimento"
			    }
			));
			//tb_clientes.setColumnSelectionAllowed(true);
			tb_clientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		
		
		
		
		return tb_clientes;
	}

	private JButton getBt_new() {
		if (bt_new == null) {
			bt_new = new JButton();
			bt_new.setText("Novo");
			bt_new.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					WindowManager.open(ClienteForm.getInstance());
				}
			});
		}
		return bt_new;
	}

	private JButton getBt_info() {
		if (bt_info == null) {
			bt_info = new JButton();
			bt_info.setText("Informações");
			bt_info.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l=tb_clientes.getSelectedRow();
					Cliente cli=currentClientes.get(l);
					if(cli!=null){
                                                //System.out.println(cli.getIdcliente());
						ClienteInfoFrame c=ClienteInfoFrame.getInstance(cli.getIdcliente());
						
						WindowManager.open(c);
					}
				}
			});
		}
		return bt_info;
	}

	private JButton getBt_next() {
		if (bt_next == null) {
			bt_next = new JButton();
			bt_next.setText(">");
			bt_next.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage++;
					atualizaTable(GerenteBD.getInstance().getPage(currentPage,currentSearch));
				}
			});
		}
		return bt_next;
	}

	private JButton getBt_back() {
		if (bt_back == null) {
			bt_back = new JButton();
			bt_back.setText("<");
			bt_back.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage--;
					atualizaTable(GerenteBD.getInstance().getPage(currentPage,currentSearch));
				}
			});
		}
		return bt_back;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void atualizaTable(Vector<Cliente> clientes){
		Object[][]table=new Object[NUM_REG][6];
		int i=0;
		for(Cliente c:clientes){
			table[i][0]=c.getNome()+" "+c.getSobrenome();
			table[i][1]=c.getCPF();
			table[i][2]=c.getTelefone();
			table[i][3]=c.getEndereco();
			table[i][4]=c.getEmail();
                        Date d = c.getData_nascimento();
			table[i][5]= new String(d.getDay()+"/"+d.getMonth()+"/"+d.getYear());
                                //new SimpleDateFormat("dd/MM/yyyy").format(c.getData_nascimento());
			
			i++;
		}
		
		tb_clientes.setModel(new javax.swing.table.DefaultTableModel(table,
				    new String [] {
				        "Cliente", "CPF", "Telefone", "Endereço","E-mail","Data Nascimento"
				    }
		));
		tb_clientes.updateUI();
		if(currentPage==1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);
		
		
		int num_clientes=GerenteBD.getInstance().getCountClientes(currentSearch);
		int maxPage=num_clientes/NUM_REG+1;
		
		if(currentPage==maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);
		
		currentClientes=clientes;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
