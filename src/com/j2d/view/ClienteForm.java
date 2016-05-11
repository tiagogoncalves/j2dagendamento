package com.j2d.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.utils.Message;
import com.toedter.calendar.JDateChooser;

public class ClienteForm extends JFrame {

	private static ClienteForm singleton;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton bt_ok = null;
	private JButton bt_cancel = null;
	private JLabel lbl_nome = null;
	private JLabel lbl_sobrenome = null;
	private JTextField txt_nome = null;
	private JLabel lbl_dataNasciment = null;
	private JLabel lbl_cpf = null;
	private JLabel lbl_endereco = null;
	private JLabel lbl_email = null;
	private JLabel lbl_telefone = null;
	private JTextField txt_sobrenome = null;
	private JTextField txt_cpf = null;
	private JTextField txt_endereco = null;
	private JTextField txt_email = null;
	private JTextField txt_telefone = null;  //  @jve:decl-index=0:
	private JDateChooser txt_data = null;
	private JLabel lbl_telefone2 = null;
	private JTextField txt_telefone2 = null;
	private boolean inserir;
	private String idCliente;
	
	public static ClienteForm getInstance(){
		if(singleton==null)
			singleton=new ClienteForm();
		
		return singleton;
	}
	
	public static ClienteForm getInstance(String id){
		if(singleton==null)
			singleton=new ClienteForm(id);
		
		return singleton;
	}
	
	private ClienteForm() {
		super();
		initialize();
		inserir=true;
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}
	
	private ClienteForm(String idCliente) {
		super();
		initialize();
		preencheCampos(GerenteBD.getInstance().getOneCliente(idCliente));
		this.idCliente=idCliente;
		inserir=false;
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private void preencheCampos(Cliente c) {
		txt_cpf.setText(c.getCPF());
		txt_data.setDate(new java.util.Date(c.getData_nascimento().getTime()));
		txt_email.setText(c.getEmail());
		txt_endereco.setText(c.getEndereco());
		txt_nome.setText(c.getNome());
		txt_sobrenome.setText(c.getSobrenome());
		txt_telefone.setText(c.getTelefone());
		txt_telefone2.setText(c.getCelular());
		
		bt_ok.setText("Atualizar");
	}

	private void initialize() {
		this.setSize(396, 343);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro Cliente");
		this.setResizable(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_telefone2 = new JLabel();
			lbl_telefone2.setText("Celular: ");
			lbl_telefone2.setLocation(new Point(10, 221));
			lbl_telefone2.setSize(new Dimension(54, 16));
			lbl_telefone = new JLabel();
			lbl_telefone.setText("Telefone: ");
			lbl_telefone.setLocation(new Point(10, 188));
			lbl_telefone.setSize(new Dimension(69, 16));
			lbl_email = new JLabel();
			lbl_email.setText("E-mail: ");
			lbl_email.setLocation(new Point(10, 162));
			lbl_email.setSize(new Dimension(52, 16));
			lbl_endereco = new JLabel();
			lbl_endereco.setText("Endereço:");
			lbl_endereco.setLocation(new Point(10, 134));
			lbl_endereco.setSize(new Dimension(65, 16));
			lbl_cpf = new JLabel();
			lbl_cpf.setText("CPF: ");
			lbl_cpf.setLocation(new Point(11, 103));
			lbl_cpf.setSize(new Dimension(38, 16));
			lbl_dataNasciment = new JLabel();
			lbl_dataNasciment.setText("Data Nasc. :");
			lbl_dataNasciment.setLocation(new Point(11, 74));
			lbl_dataNasciment.setSize(new Dimension(74, 16));
			lbl_sobrenome = new JLabel();
			lbl_sobrenome.setBounds(new Rectangle(11, 45, 85, 16));
			lbl_sobrenome.setText("Sobrenome:");
			lbl_nome = new JLabel();
			lbl_nome.setBounds(new Rectangle(12, 16, 40, 16));
			lbl_nome.setText("Nome: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBt_ok(), null);
			jContentPane.add(getBt_cancel(), null);
			jContentPane.add(lbl_nome, null);
			jContentPane.add(lbl_sobrenome, null);
			jContentPane.add(getTxt_nome(), null);
			jContentPane.add(lbl_dataNasciment, null);
			jContentPane.add(lbl_cpf, null);
			jContentPane.add(lbl_endereco, null);
			jContentPane.add(lbl_email, null);
			jContentPane.add(lbl_telefone, null);
			jContentPane.add(getTxt_sobrenome(), null);
			jContentPane.add(getTxt_cpf(), null);
			jContentPane.add(getTxt_endereco(), null);
			jContentPane.add(getTxt_email(), null);
			jContentPane.add(getTxt_telefone(), null);
			jContentPane.add(getTxt_data(), null);
			jContentPane.add(lbl_telefone2, null);
			jContentPane.add(getTxt_telefone2(), null);
		}
		return jContentPane;
	}

	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setSize(new Dimension(93, 25));
			bt_ok.setText("Cadastrar");
			bt_ok.setLocation(new Point(183, 267));
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					int result=0;
					if(inserir){
                                            System.out.println("inserir");
						Cliente c=new Cliente();
						c.setNome(txt_nome.getText());
						c.setSobrenome(txt_sobrenome.getText());
						
						c.setData_nascimento(new java.sql.Date(txt_data.getDate().getTime()));
						c.setCPF(txt_cpf.getText());
						c.setEndereco(txt_endereco.getText());
						c.setEmail(txt_email.getText());
						c.setTelefone(txt_telefone.getText());
						c.setCelular(txt_telefone2.getText());
						System.out.println("pegou os valores");
						result=GerenteBD.getInstance().insert(c);
						
					}else{
						Cliente c=new Cliente();
						c.setNome(txt_nome.getText());
						c.setSobrenome(txt_sobrenome.getText());
						
						c.setData_nascimento(new java.sql.Date(txt_data.getDate().getTime()));
						c.setCPF(txt_cpf.getText());
						c.setEndereco(txt_endereco.getText());
						c.setEmail(txt_email.getText());
						//c.setIdcliente(idCliente);
						c.setTelefone(txt_telefone.getText());
						c.setCelular(txt_telefone2.getText());
						
						result=GerenteBD.getInstance().update(c);
						
					}
					
					if(result==Message.SUCCESS_MENSAGE){
						JOptionPane.showMessageDialog(ClienteForm.this, Message.getMensage(result));
						ClientesFrame frame=ClientesFrame.getInstance();
						if(frame.isVisible())
							frame.atualizaTable(GerenteBD.getInstance().getPage(1,""));
						ClienteForm.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(ClienteForm.this, "Erro no cadastro de um cliente", "Error!", JOptionPane.ERROR_MESSAGE);
					
				}
			});
		}
		return bt_ok;
	}

	private JButton getBt_cancel() {
		if (bt_cancel == null) {
			bt_cancel = new JButton();
			bt_cancel.setText("Cancelar");
			bt_cancel.setSize(new Dimension(87, 25));
			bt_cancel.setLocation(new Point(283, 267));
			bt_cancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ClienteForm.this.dispose();
				}
			});
		}
		return bt_cancel;
	}

	private JTextField getTxt_nome() {
		if (txt_nome == null) {
			txt_nome = new JTextField();
			txt_nome.setSize(new Dimension(264, 27));
			txt_nome.setLocation(new Point(107, 13));
		}
		return txt_nome;
	}

	private JTextField getTxt_sobrenome() {
		if (txt_sobrenome == null) {
			txt_sobrenome = new JTextField();
			txt_sobrenome.setSize(new Dimension(264, 27));
			txt_sobrenome.setLocation(new Point(107, 43));
		}
		return txt_sobrenome;
	}

	private JTextField getTxt_cpf() {
		if (txt_cpf == null) {
			try {
				txt_cpf = new JFormattedTextField(new MaskFormatter("########"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txt_cpf.setLocation(new Point(107, 102));
			txt_cpf.setSize(new Dimension(171, 27));
			
			
		}
		return txt_cpf;
	}

	private JTextField getTxt_endereco() {
		if (txt_endereco == null) {
			txt_endereco = new JTextField();
			txt_endereco.setSize(new Dimension(264, 27));
			txt_endereco.setLocation(new Point(107, 133));
		}
		return txt_endereco;
	}

	private JTextField getTxt_email() {
		if (txt_email == null) {
			txt_email = new JTextField();
			txt_email.setLocation(new Point(107, 163));
			txt_email.setSize(new Dimension(229, 27));
		}
		return txt_email;
	}

	private JTextField getTxt_telefone() {
		if (txt_telefone == null) {
			try {
				txt_telefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
			} catch (ParseException e) {
				
			}
			txt_telefone.setLocation(new Point(107, 188));
			txt_telefone.setSize(new Dimension(177, 27));
		}
		return txt_telefone;
	}

	private JDateChooser getTxt_data() {
		if (txt_data == null) {
			txt_data = new JDateChooser();
			txt_data.setSize(new Dimension(175, 25));
			txt_data.setLocation(new Point(107, 70));
		}
		return txt_data;
	}
	
	private JTextField getTxt_telefone2() {
		if (txt_telefone2 == null) {
			try {
				txt_telefone2 = new JFormattedTextField(new MaskFormatter("(##)####-####"));
			} catch (ParseException e) {
				
			}
			txt_telefone2.setLocation(new Point(107, 217));
			txt_telefone2.setSize(new Dimension(177, 27));
		}
		return txt_telefone2;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
