package com.j2d.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.model.negocio.Reserva;
import com.j2d.model.negocio.Tipo_servico;
import com.j2d.utils.WindowManager;
import java.util.Vector;

public class ClienteInfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbl_nome = null;
	private JLabel lbl_data = null;
	private JLabel lbl_end = null;
	private JLabel lbl_cpf = null;
	private JLabel lbl_telefone = null;
	private JLabel lbl_celular = null;
	private JLabel lbl_email = null;
	private JLabel lbl_data_cliente = null;
	private JLabel lbl_endereco_cliente = null;
	private JLabel lbl_email_cliente = null;
	private JLabel lbl_cpf_cliente = null;
	private JLabel lbl_telefone_cliente = null;
	private JLabel lbl_celular_cliente = null;
	private JLabel lbl_nome_cliente = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_servicos = null;
	private JLabel lbl_servico = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private static ClienteInfoFrame singleton;
	private Cliente c;
	private JButton bt_edit = null;
	private JButton bt_agendar = null;
	
	public static ClienteInfoFrame getInstance(String id){
		
		if(singleton==null)
			singleton=new ClienteInfoFrame(id);
		return singleton;
	}
	
	private ClienteInfoFrame(String id) {
		// TODO Auto-generated constructor
		super();
		initialize();
		c=GerenteBD.getInstance().getOneCliente(id);
                System.out.println(c+"");
		this.setTitle("Informações de "+c.getNome()+" "+c.getSobrenome());
		preencheCampos();
                atualizaTable(GerenteBD.getInstance().getReservas(c));
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private void preencheCampos() {
		lbl_nome_cliente.setText(c.getNome()+" "+c.getSobrenome());
		lbl_email_cliente.setText(c.getEmail());
		lbl_cpf_cliente.setText(c.getCPF());
		lbl_data_cliente.setText( new SimpleDateFormat("dd/MM/yyyy").format(c.getData_nascimento()));
		lbl_endereco_cliente.setText(c.getEndereco());
		lbl_celular_cliente.setText(c.getCelular());
		lbl_telefone_cliente.setText(c.getTelefone());
		
	}

	private void initialize() {
		this.setSize(465, 437);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Informações de ");
		this.setResizable(false);
                
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 2;
			gridBagConstraints15.insets = new Insets(6, 0, 0, 0);
			gridBagConstraints15.gridwidth = 2;
			gridBagConstraints15.anchor = GridBagConstraints.EAST;
			gridBagConstraints15.gridy = 7;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints31.gridy = 10;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 2;
			gridBagConstraints21.anchor = GridBagConstraints.EAST;
			gridBagConstraints21.insets = new Insets(0, 3, 5, 0);
			gridBagConstraints21.weightx = 0.6;
			gridBagConstraints21.gridy = 10;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 3;
			gridBagConstraints1.anchor = GridBagConstraints.EAST;
			gridBagConstraints1.insets = new Insets(0, 0, 5, 5);
			gridBagConstraints1.gridy = 10;
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 0;
			gridBagConstraints51.gridwidth = 3;
			gridBagConstraints51.insets = new Insets(9, 0, 0, 0);
			gridBagConstraints51.gridy = 8;
			lbl_servico = new JLabel();
			//lbl_servico.setFont(new java.awt.Font("Tahoma", 0, 16));
			lbl_servico.setText("Serviços");
			
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.fill = GridBagConstraints.BOTH;
			gridBagConstraints41.gridy = 9;
			gridBagConstraints41.weightx = 1.0;
			gridBagConstraints41.weighty = 1.0;
			gridBagConstraints41.gridwidth = 4;
			gridBagConstraints41.gridx = 0;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 1;
			gridBagConstraints14.anchor = GridBagConstraints.WEST;
			gridBagConstraints14.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints14.gridy = 0;
			lbl_nome_cliente = new JLabel();
			lbl_nome_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 1;
			gridBagConstraints13.anchor = GridBagConstraints.WEST;
			gridBagConstraints13.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints13.gridy = 6;
			lbl_celular_cliente = new JLabel();
			lbl_celular_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints12.gridy = 5;
			lbl_telefone_cliente = new JLabel();
			lbl_telefone_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints11.gridy = 4;
			lbl_cpf_cliente = new JLabel();
			lbl_cpf_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 1;
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints10.gridy = 3;
			lbl_email_cliente = new JLabel();
			lbl_email_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints9.gridy = 2;
			lbl_endereco_cliente = new JLabel();
			lbl_endereco_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.insets = new Insets(7, 7, 0, 0);
			gridBagConstraints8.gridy = 1;
			lbl_data_cliente = new JLabel();
			lbl_data_cliente.setText("JLabel");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints7.gridy = 3;
			lbl_email = new JLabel();
			lbl_email.setText("E-mail: ");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints6.gridy = 6;
			lbl_celular = new JLabel();
			lbl_celular.setText("Celular: ");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints5.gridy = 5;
			lbl_telefone = new JLabel();
			lbl_telefone.setText("Telefone: ");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints4.gridy = 4;
			lbl_cpf = new JLabel();
			lbl_cpf.setText("CPF: ");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints3.gridy = 2;
			lbl_end = new JLabel();
			lbl_end.setText("Endereço:");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints2.gridy = 1;
			lbl_data = new JLabel();
			lbl_data.setText("Data Nascimento: ");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.insets = new Insets(7, 10, 0, 0);
			gridBagConstraints.gridy = 0;
			lbl_nome = new JLabel();
			lbl_nome.setText("Nome: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_nome, gridBagConstraints);
			jContentPane.add(lbl_data, gridBagConstraints2);
			jContentPane.add(lbl_end, gridBagConstraints3);
			jContentPane.add(lbl_cpf, gridBagConstraints4);
			jContentPane.add(lbl_telefone, gridBagConstraints5);
			jContentPane.add(lbl_celular, gridBagConstraints6);
			jContentPane.add(lbl_email, gridBagConstraints7);
			jContentPane.add(lbl_data_cliente, gridBagConstraints8);
			jContentPane.add(lbl_endereco_cliente, gridBagConstraints9);
			jContentPane.add(lbl_email_cliente, gridBagConstraints10);
			jContentPane.add(lbl_cpf_cliente, gridBagConstraints11);
			jContentPane.add(lbl_telefone_cliente, gridBagConstraints12);
			jContentPane.add(lbl_celular_cliente, gridBagConstraints13);
			jContentPane.add(lbl_nome_cliente, gridBagConstraints14);
			jContentPane.add(getJScrollPane(), gridBagConstraints41);
			jContentPane.add(lbl_servico, gridBagConstraints51);
			jContentPane.add(getBt_next(), gridBagConstraints1);
			jContentPane.add(getBt_back(), gridBagConstraints21);
			jContentPane.add(getBt_edit(), gridBagConstraints31);
			jContentPane.add(getBt_agendar(), gridBagConstraints15);
		}
		return jContentPane;
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
			    	{null, null}
			    	
			    },
			    new String [] {
			        "Serviço","Data"
			    }
			));
			tb_servicos.setColumnSelectionAllowed(true);
			tb_servicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
                //tb_servicos.setVisible(false);
		return tb_servicos;
	}

	private JButton getBt_next() {
		if (bt_next == null) {
			bt_next = new JButton();
			bt_next.setText(">");
		}
		return bt_next;
	}

	private JButton getBt_back() {
		if (bt_back == null) {
			bt_back = new JButton();
			bt_back.setText("<");
		}
		return bt_back;
	}

	private JButton getBt_edit() {
		if (bt_edit == null) {
			bt_edit = new JButton();
			bt_edit.setText("Editar");
			bt_edit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ClienteInfoFrame.this.dispose();
					singleton=null;
					WindowManager.open(ClienteForm.getInstance(c.getIdcliente()));
				}
			});
		}
		return bt_edit;
	
	}

	private JButton getBt_agendar() {
		if (bt_agendar == null) {
			bt_agendar = new JButton();
			bt_agendar.setText("Novo atendimento");
			bt_agendar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AgendarClienteForm a=AgendarClienteForm.getInstance();
					a.setCliente(c);
					WindowManager.open(a);
				}
			});
		}
		return bt_agendar;
	}
        
        public void atualizaTable(Vector<Reserva> reserva){
            Object[][] table = new Object[reserva.size()][2];
		int i = 0;
		for (Reserva r : reserva){
                    Tipo_servico s = GerenteBD.getInstance().getOneTipoServico(r.getIdtipo_servico());
                    table[i][0] = s.getDescricao();
                    table[i][1] = r.getData().getDate()+"/"+r.getData().getMonth();
                    i++;
                }
                
                tb_servicos.setModel(new javax.swing.table.DefaultTableModel(table, new String[] {"Serviço", "Data"}));
                tb_servicos.updateUI();
        }

}  //  @jve:decl-index=0:visual-constraint="10,10"
