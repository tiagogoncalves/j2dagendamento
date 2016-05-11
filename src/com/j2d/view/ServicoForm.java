package com.j2d.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Tipo_servico;
import com.j2d.utils.Message;

public class ServicoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private static ServicoForm singleton;  //  @jve:decl-index=0:visual-constraint="320,10"
	private JPanel jContentPane = null;
	private JLabel lbl_descricao = null;
	private JTextArea txt_descricao = null;
	private JLabel lbl_preco = null;
	private JTextField txt_preco = null;
	private JButton bt_ok = null;
	private JButton bt_cancel = null;
	private boolean atualizar=false;
	private Tipo_servico current;  //  @jve:decl-index=0:

	public static ServicoForm getInstance(){
		if(singleton==null)
			singleton=new ServicoForm();
			
		
		return singleton;
	}
	
	public static ServicoForm getInstance(int id){
		if(singleton==null)
			singleton=new ServicoForm(id);
		
		return singleton;
	}
	
	private ServicoForm() {
		super();
		initialize();
	}
	
	private ServicoForm(int id) {
		super();
		initialize();
		atualizar=true;
		preencheCampos(GerenteBD.getInstance().getOneTipoServico(id));
	}

	private void preencheCampos(Tipo_servico t) {
		txt_descricao.setText(t.getDescricao());
		txt_preco.setText(Double.toString(t.getPreco()));
		bt_ok.setText("Atualizar");
		
		current=t;
		
	}

	private void initialize() {
		this.setSize(300, 264);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro Serviço");
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_preco = new JLabel();
			lbl_preco.setBounds(new Rectangle(17, 151, 51, 16));
			lbl_preco.setText("Preço: ");
			lbl_descricao = new JLabel();
			lbl_descricao.setBounds(new Rectangle(14, 15, 74, 16));
			lbl_descricao.setText("Descrição: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbl_descricao, null);
			jContentPane.add(getTxt_descricao(), null);
			jContentPane.add(lbl_preco, null);
			jContentPane.add(getTxt_preco(), null);
			jContentPane.add(getBt_ok(), null);
			jContentPane.add(getBt_cancel(), null);
		}
		return jContentPane;
	}

	private JTextArea getTxt_descricao() {
		if (txt_descricao == null) {
			txt_descricao = new JTextArea();
			txt_descricao.setBounds(new Rectangle(15, 40, 250, 92));
		}
		return txt_descricao;
	}

	private JTextField getTxt_preco() {
		if (txt_preco == null) {
			txt_preco = new JTextField();
			txt_preco.setLocation(new Point(73, 146));
			txt_preco.setSize(new Dimension(80, 28));
		}
		return txt_preco;
	}

	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setText("Cadastrar");
			bt_ok.setSize(new Dimension(93, 25));
			bt_ok.setLocation(new Point(85, 188));
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result=0;
					if(!atualizar){
						Tipo_servico s=new Tipo_servico();
						s.setDescricao(txt_descricao.getText());
						s.setPreco(Double.parseDouble(txt_preco.getText()));
						
						result=GerenteBD.getInstance().insert(s);
						
					}else{
						Tipo_servico s=new Tipo_servico();
						s.setDescricao(txt_descricao.getText());
						s.setPreco(Double.parseDouble(txt_preco.getText()));
						s.setIdtipo_servico(current.getIdtipo_servico());
						result=GerenteBD.getInstance().update(s);
					}
					
					if(result==Message.SUCCESS_MENSAGE){
						JOptionPane.showMessageDialog(ServicoForm.this, Message.getMensage(result));
						ServicoView frame=ServicoView.getInstance();
						if(frame.isVisible())
							frame.atualizaTable(GerenteBD.getInstance().getPageServico(1, ""));
						ServicoForm.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(ServicoForm.this, "Erro no cadastro de um cliente", "Error!", JOptionPane.ERROR_MESSAGE);
					
				}
			});
		}
		return bt_ok;
	}

	private JButton getBt_cancel() {
		if (bt_cancel == null) {
			bt_cancel = new JButton();
			bt_cancel.setText("Cancelar");
			bt_cancel.setSize(new Dimension(91, 25));
			bt_cancel.setLocation(new Point(184, 189));
			bt_cancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				
					singleton=null;
					ServicoForm.this.dispose();
				
				}
			});
		}
		return bt_cancel;
	}
	
	public static void main(String [] args){
		ServicoForm s=ServicoForm.getInstance(1);
		s.setVisible(true);
		s.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
