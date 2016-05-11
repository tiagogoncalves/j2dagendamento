package com.j2d.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.ItemHistoricoAtendimento;
import com.j2d.model.negocio.Reserva;

public class AtendimentoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbl_relatorio = null;
	private JTextArea txt_relatorio = null;
	private JLabel lbl_preco = null;
	private JTextField txt_preco = null;
	private JButton bt_ok = null;
	private JButton bt_cancel = null;
	private	Reserva reserva;

	public AtendimentoForm(Reserva r) {
		super();
		reserva=r;
		initialize();
	}

	private void initialize() {
		this.setSize(459, 345);
		this.setContentPane(getJContentPane());
		this.setTitle("Agendamento");
		this.setResizable(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridy = 3;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridwidth = 1;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints21.gridy = 3;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.ipadx = 100;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridy = 2;
			lbl_preco = new JLabel();
			lbl_preco.setText("Preço: ");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.ipadx = 300;
			gridBagConstraints1.ipady = 220;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(10, 5, 0, 0);
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 0;
			lbl_relatorio = new JLabel();
			lbl_relatorio.setText("Relatorio:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_relatorio, gridBagConstraints);
			jContentPane.add(getTxt_relatorio(), gridBagConstraints1);
			jContentPane.add(lbl_preco, gridBagConstraints2);
			jContentPane.add(getTxt_preco(), gridBagConstraints3);
			jContentPane.add(getBt_ok(), gridBagConstraints21);
			jContentPane.add(getBt_cancel(), gridBagConstraints31);
		}
		return jContentPane;
	}

	private JTextArea getTxt_relatorio() {
		if (txt_relatorio == null) {
			txt_relatorio = new JTextArea();
		}
		return txt_relatorio;
	}

	private JTextField getTxt_preco() {
		if (txt_preco == null) {
			txt_preco = new JTextField();
		}
		return txt_preco;
	}

	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setText("Inserir");
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ItemHistoricoAtendimento i=new ItemHistoricoAtendimento();
					i.setReserva(reserva);
					i.setPreco(Double.parseDouble(txt_preco.getText()));
					i.setRelatorio(txt_relatorio.getText());
					
					GerenteBD.getInstance().insert(i);
					GerenteBD.getInstance().update(reserva);
					
					AgendaView a=AgendaView.getInstance();
					if(a!=null){
						a.atualizaTable(GerenteBD.getInstance().getNextReserva(a.getCurrentSearch(), 1, a.isAtendido(), new java.sql.Date(a.getCurrentDate().getTime())));
					}
					dispose();
				}
			});
		}
		return bt_ok;
	}

	private JButton getBt_cancel() {
		if (bt_cancel == null) {
			bt_cancel = new JButton();
			bt_cancel.setText("Cancelar");
		}
		return bt_cancel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
