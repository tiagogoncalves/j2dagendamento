package com.j2d.view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Tipo_servico;

public class ServicoChooser extends JDialog {

	private static ServicoChooser current;
	private static final long serialVersionUID = 1L;
	private final static int NUM_REG=40; 
	private JPanel jContentPane = null;
	private boolean confirmado=false;
	private Tipo_servico selected;  //  @jve:decl-index=0:
	private JLabel lbl_procurar = null;
	private JTextField txt_search = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_servicos = null;
	private JButton bt_search = null;
	private JButton bt_ok = null;
	private JButton bt_back = null;
	private JButton bt_next = null;
	private int currentPage=1;
	private Vector<Tipo_servico> currentServicos;  //  @jve:decl-index=0:
	private String currentSearch="";
	private Frame owner;

	public ServicoChooser(Frame owner) {
		super(owner);
		this.owner=owner;
		initialize();
		current=this;
	}

	private void initialize() {
		this.setSize(601, 350);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Selecione um cliente");
		this.setContentPane(getJContentPane());
		this.atualizaTable(GerenteBD.getInstance().getPageServico(currentPage, currentSearch));
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 4;
			gridBagConstraints31.weightx = 0.0;
			gridBagConstraints31.insets = new Insets(0, 0, 5, 5);
			gridBagConstraints31.gridy = 2;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 3;
			gridBagConstraints21.anchor = GridBagConstraints.EAST;
			gridBagConstraints21.weightx = 0.7;
			gridBagConstraints21.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints21.gridy = 2;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(0, 6, 5, 0);
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.weightx = 0.0;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridwidth = 5;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.5;
			gridBagConstraints1.ipadx = 100;
			gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.insets = new Insets(5, 10, 0, 5);
			gridBagConstraints.gridy = 0;
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_procurar, gridBagConstraints);
			jContentPane.add(getTxt_search(), gridBagConstraints1);
			jContentPane.add(getJScrollPane(), gridBagConstraints2);
			jContentPane.add(getBt_search(), gridBagConstraints3);
			jContentPane.add(getBt_ok(), gridBagConstraints11);
			jContentPane.add(getBt_back(), gridBagConstraints21);
			jContentPane.add(getBt_next(), gridBagConstraints31);
		}
		return jContentPane;
	}
	
	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public void setSelected(Tipo_servico selected) {
		this.selected = selected;
	}

	public Tipo_servico getSelected() {
		return selected;
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

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_clientes());
		}
		return jScrollPane;
	}

	private JTable getTb_clientes() {
		if (tb_servicos == null) {
			tb_servicos = new javax.swing.JTable();

			tb_servicos.setModel(new javax.swing.table.DefaultTableModel(
			    new Object [][] {
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null},
			    	{null, null}
			        
			       
			    },
			    new String [] {
			        "Servi�o","Pre�o"
			    }
			));
			//tb_servicos.setColumnSelectionAllowed(true);
			tb_servicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tb_servicos;
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

	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setText("Selecionar");
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					int l=tb_servicos.getSelectedRow();
					if(l>-1){
						selected=currentServicos.get(l);
						confirmado=true;
						if(owner instanceof AgendarClienteForm){
							AgendarClienteForm a=(AgendarClienteForm)owner;
							a.setServico(selected);
						}
						
						ServicoChooser.this.dispose();
					}else{
						JOptionPane.showMessageDialog(ServicoChooser.this,  "Selecione um cliente por favor!","Aten��o!", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			});
		}
		return bt_ok;
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

	public static void setCurrent(ServicoChooser current) {
		ServicoChooser.current = current;
	}

	public static ServicoChooser getCurrent() {
		return current;
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
	
	public static void open(final JFrame parent){
		
	
		ServicoChooser chooser=new ServicoChooser(parent);
		Dimension paneSize = chooser.getSize();
        JFrame current=parent; 
		Dimension screenSize = current.getSize();
         chooser.setLocation( current.getLocation().x+(screenSize.width - paneSize.width) / 2, current.getLocation().y+(screenSize.height - paneSize.height) / 2);
		chooser.setVisible(true);
		
			
	}
	
	public static void main(String [] args){
		JFrame j=new JFrame("teste");
		ServicoChooser.open(j);
		j.setVisible(true);
		
		
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
