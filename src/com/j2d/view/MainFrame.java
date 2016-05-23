package com.j2d.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.utils.WindowManager;
import java.sql.Date;

public class MainFrame extends JFrame {

	private static MainFrame current;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbl_agendarAtendimento = null;
	private JLabel lbl_cliente = null;
	private JLabel lbl_servico = null;
	private JLabel lbl_agenda = null;
        private JLabel lbl_relatorio = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_aniversariantes = null;
	
	public static MainFrame getCurrent(){
		return current;
	}
	
	private MainFrame() {
                
		super();
		initialize();
		AtualizaTable(GerenteBD.getInstance().getPageAniversariantes());
		current=this;
                System.out.println("Inicializando sistema");
	}

	private void initialize() {
		this.setSize(600, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("J2DAgendamento");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowManager.centralizaTela(this);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagClientes = new GridBagConstraints();
			gridBagClientes.insets = new Insets(6, 7, 4, 2);
			gridBagClientes.gridy = 0;
			gridBagClientes.weightx = 0.3;
			gridBagClientes.weighty = 0.25;
			gridBagClientes.gridx = 0;
			
			GridBagConstraints gridBagAgenda = new GridBagConstraints();
			gridBagAgenda.insets = new Insets(3, 3, 2, 2);
			gridBagAgenda.gridx = 1	;
			gridBagAgenda.gridy = 0;
			gridBagAgenda.weightx = 0.3;
			gridBagAgenda.gridwidth = 1;
			
			GridBagConstraints gridBagAgendarAtendimento = new GridBagConstraints();
			gridBagAgendarAtendimento.insets = new Insets(9, 3, 6, 2);
			gridBagAgendarAtendimento.gridy = 1;
			gridBagAgendarAtendimento.weighty = 0.25;
			gridBagAgendarAtendimento.gridx = 0;
			
			GridBagConstraints gridBagServico = new GridBagConstraints();
			gridBagServico.insets = new Insets(5, 3, 2, 7);
			gridBagServico.gridy = 1;
			gridBagServico.gridx = 1;
                        
                        GridBagConstraints gridBagRelatorios = new GridBagConstraints();
			gridBagRelatorios.insets = new Insets(10, 3, 6, 2);
			gridBagRelatorios.gridy = 2;
			gridBagRelatorios.weighty = 0.25;
			gridBagRelatorios.gridx = 0;
			
			GridBagConstraints gridBagPanelAniversaritantes = new GridBagConstraints();
			gridBagPanelAniversaritantes.fill = GridBagConstraints.HORIZONTAL;
			gridBagPanelAniversaritantes.gridwidth = 3;
			gridBagPanelAniversaritantes.gridx = 0;
			gridBagPanelAniversaritantes.gridy = 4;
			gridBagPanelAniversaritantes.weightx = 0.0;
			gridBagPanelAniversaritantes.weighty = 0.25;
			gridBagPanelAniversaritantes.insets = new Insets(0, 0, 0, 0);
                        
                        
			lbl_agenda = new JLabel(new ImageIcon(getClass().getResource("/images/fila.png")));
			lbl_agenda.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(AgendaView.getInstance());
				}
			});
			lbl_agenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
			lbl_servico = new JLabel(new ImageIcon(getClass().getResource("/images/servico.png")));
			lbl_servico.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_servico.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(ServicoView.getInstance());
				}
			});
		
			lbl_cliente = new JLabel(new ImageIcon(getClass().getResource("/images/addUsuario.png")));
						lbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {   
							public void mouseClicked(java.awt.event.MouseEvent e) {    
								WindowManager.open(ClientesFrame.getInstance());
							} 
						
			});
			lbl_cliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			lbl_agendarAtendimento = new JLabel(new ImageIcon(getClass().getResource("/images/agendador.png")));
			lbl_agendarAtendimento.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//lbl_agendarAtendimento.setText("JLabel");
			lbl_agendarAtendimento.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(AgendarClienteForm.getInstance());
					
				}
			});
                        
                        lbl_relatorio = new JLabel(new ImageIcon(getClass().getResource("/images/relatorios.png")));
			lbl_relatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_relatorio.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(RelatoriosView.getInstance());
				}
			});
			
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_agendarAtendimento, gridBagAgendarAtendimento);
			jContentPane.add(lbl_cliente, gridBagClientes);
			jContentPane.add(lbl_servico, gridBagServico);
			jContentPane.add(lbl_agenda, gridBagAgenda);
                        jContentPane.add(lbl_relatorio, gridBagRelatorios);
			jContentPane.add(getJScrollPane(), gridBagPanelAniversaritantes);
		}
		return jContentPane;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setPreferredSize(new Dimension(453, 120));
			jScrollPane.setViewportView(getTb_aniversariantes());
		}
		return jScrollPane;
	}

	private JTable getTb_aniversariantes() {
		if (tb_aniversariantes == null) {
			tb_aniversariantes = new javax.swing.JTable();

			tb_aniversariantes.setModel(new javax.swing.table.DefaultTableModel(
			    new Object [][] {
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null}
			    },
			    new String [] {
			        "Cliente", "Data Aniversário", "Telefone", "Endereço"
			    }
			));
		}
		return tb_aniversariantes;
	}

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
	
	public void AtualizaTable(Vector<Cliente> cliente){
		Object[][] table = new Object[5][4];
		int i = 0;
		for (Cliente c : cliente) {
			table[i][0] = c.getNome() + " " + c.getSobrenome();
                        Date d = c.getData_nascimento();
			table[i][1] = new String(d.getDay()+"/"+d.getMonth()+"/"+d.getYear());
			table[i][2] = c.getTelefone();
			table[i][3] = c.getEndereco();

			i++;
		}

		tb_aniversariantes.setModel(new javax.swing.table.DefaultTableModel(table,
				new String[] { "Cliente", "Data Aniversário", "Telefone", "Endereço" }));
	    tb_aniversariantes.updateUI();
	}	
}
