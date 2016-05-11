package com.j2d.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.model.negocio.Reserva;
import com.j2d.model.negocio.Tipo_servico;
import com.j2d.utils.WindowManager;
import com.toedter.calendar.JDateChooser;

public class AgendaView extends JFrame {

	private static AgendaView singleton;
	private static final long serialVersionUID = 1L;
	private final static int NUM_REG=40; 
	private JPanel mainPanel = null;
	private JTabbedPane pn_fila = null;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_agenda = null;
	private JButton bt_atendido = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_search = null;
	private JButton br_search = null;
	private int currentPage = 1;
	private Vector<Reserva> currentList;
	private String currentSearch = ""; // @jve:decl-index=0:
	private JPanel jPanel = null;
	private JScrollPane jScrollPane1 = null;
	private JTable tb_atendidos = null;
	private JTable currenteTable;
	private boolean atendido=false;
	private Date currentDate=new Date();
	private JButton bt_edit = null;
	private JDateChooser txt_data = null;

	public static AgendaView getInstance() {
		if (singleton == null) {
			singleton = new AgendaView();
		}
		return singleton;
	}

	private AgendaView() {
		super();
		initialize();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton = null;
			}

		});
		currenteTable = tb_agenda;
		atualizaTable(GerenteBD.getInstance().getNextReserva(currentSearch,
				currentPage, false, new java.sql.Date(txt_data.getDate().getTime())));
	}

	private void initialize() {
		this.setSize(586, 329);
		this.setContentPane(getMainPanel());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Agenda");
	}

	private JPanel getMainPanel() {
		if (mainPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 4;
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.insets = new Insets(0, 35, 0, 0);
			gridBagConstraints1.ipadx = 200;
			gridBagConstraints1.anchor = GridBagConstraints.EAST;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 2;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 2;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridwidth = 2;
			gridBagConstraints9.gridy = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.NONE;
			gridBagConstraints8.gridy = 0;
			gridBagConstraints8.weightx = 0.0;
			gridBagConstraints8.gridwidth = 1;
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.ipadx = 200;
			gridBagConstraints8.gridx = 1;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.gridy = 0;
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar:");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 4;
			gridBagConstraints6.weightx = 0.5;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridy = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 5;
			gridBagConstraints5.weightx = 0.0;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.weightx = 0.0;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridwidth = 6;
			gridBagConstraints.gridx = 0;
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridBagLayout());
			mainPanel.add(getPn_fila(), gridBagConstraints);
			mainPanel.add(getBt_atendido(), gridBagConstraints4);
			mainPanel.add(getBt_next(), gridBagConstraints5);
			mainPanel.add(getBt_back(), gridBagConstraints6);
			mainPanel.add(lbl_procurar, gridBagConstraints7);
			mainPanel.add(getTxt_search(), gridBagConstraints8);
			mainPanel.add(getBr_search(), gridBagConstraints9);
			mainPanel.add(getBt_edit(), gridBagConstraints11);
			mainPanel.add(getTxt_data(), gridBagConstraints1);
		}
		return mainPanel;
	}

	private JTabbedPane getPn_fila() {
		if (pn_fila == null) {
			pn_fila = new JTabbedPane();
			pn_fila.addTab("Proximos", null, getJContentPane(), null);
			pn_fila.addTab("Atendidos", null, getJPanel(), null);

			pn_fila.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					Component c = pn_fila.getSelectedComponent();
					atendido=false;
					if(c.getName()!=null)
						if(c.getName().equals("atendidos")){
							atendido=true;
							currenteTable=tb_atendidos;
							bt_atendido.setText("Desfazer Atendimento");
							//bt_atendido.setEnabled(false);
							//bt_desatender.setEnabled(true);
						}else if(c.getName().equals("agenda")){
							currenteTable=tb_agenda;
							bt_atendido.setText("Atendido");
							//bt_atendido.setEnabled(true);
							
						}
												
					
					atualizaTable(GerenteBD.getInstance().getNextReserva(currentSearch, currentPage, atendido, new java.sql.Date(txt_data.getDate().getTime())));
				}
			});
		}
		return pn_fila;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.setName("agenda");
			jContentPane.add(getJScrollPane(), gridBagConstraints2);
		}
		return jContentPane;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_agenda());
		}
		return jScrollPane;
	}

	private JTable getTb_agenda() {
		if (tb_agenda == null) {
			tb_agenda = new JTable();
			tb_agenda.setModel(new DefaultTableModel(new Object[][] {
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null } }, new String[] { "Cliente",
					"Serviço", "Data", "Hora" }));
		}
		return tb_agenda;
	}

	private JButton getBt_atendido() {
		if (bt_atendido == null) {
			bt_atendido = new JButton();
			bt_atendido.setText("Atendido");
			bt_atendido.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l=currenteTable.getSelectedRow();
					if(l>-1){
						Reserva r=currentList.get(l);
						if(r!=null){
							
							r.setAtendido(!atendido);
							
							if(r.isAtendido())
								WindowManager.open(new AtendimentoForm(r));
							else{
								GerenteBD.getInstance().deleteItemHistoricoAtendimentoByReserva(r.getIdreserva());
								GerenteBD.getInstance().update(r);
								
								atualizaTable(GerenteBD.getInstance().getNextReserva(currentSearch, currentPage, atendido,new java.sql.Date(txt_data.getDate().getTime())));
							}
						}
					}
				}
			});
		}
		return bt_atendido;
	}

	private JButton getBt_next() {
		if (bt_next == null) {
			bt_next = new JButton();
			bt_next.setText(">");
			bt_next.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage++;
					atualizaTable(GerenteBD.getInstance().getNextReserva(
							currentSearch, currentPage, atendido, new java.sql.Date(txt_data.getDate().getTime())));
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
					atualizaTable(GerenteBD.getInstance().getNextReserva(
							currentSearch, currentPage, atendido, new java.sql.Date(txt_data.getDate().getTime())));
				}
			});
		}
		return bt_back;
	}

	private JTextField getTxt_search() {
		if (txt_search == null) {
			txt_search = new JTextField();
			txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					if (e.getKeyChar() == '\n') {
						currentPage = 1;
						atualizaTable(GerenteBD.getInstance().getNextReserva(
								txt_search.getText(), currentPage, atendido, new java.sql.Date(txt_data.getDate().getTime())));
					}

				}
			});
		}
		return txt_search;
	}

	private JButton getBr_search() {
		if (br_search == null) {
			br_search = new JButton();
			br_search.setText("Procurar...");
			br_search.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage = 1;
					atualizaTable(GerenteBD.getInstance().getNextReserva(
							txt_search.getText(), currentPage, atendido,new java.sql.Date(txt_data.getDate().getTime())));
				}
			});
		}
		return br_search;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentList(Vector<Reserva> currentList) {
		this.currentList = currentList;
	}

	public Vector<Reserva> getCurrentList() {
		return currentList;
	}

	public void setCurrentSearch(String currentSearch) {
		this.currentSearch = currentSearch;
	}

	public String getCurrentSearch() {
		return currentSearch;
	}

	public void atualizaTable(Vector<Reserva> reserva) {
		Object[][] table = new Object[NUM_REG][4];
		int i = 0;
		for (Reserva r : reserva) {
			Cliente c = GerenteBD.getInstance().getOneCliente(r.getIdcliente());
			Tipo_servico s = GerenteBD.getInstance().getOneTipoServico(
					r.getIdtipo_servico());

			table[i][0] = c.getNome() + " " + c.getSobrenome();
			table[i][1] = s.getDescricao();
			table[i][2] = r.getData().getDate()+"/"+(r.getData().getMonth());
//new SimpleDateFormat("dd/MM/yyyy").format(r.getData());
			table[i][3] = r.getHora();

			i++;
		}

		currenteTable.setModel(new javax.swing.table.DefaultTableModel(table,
				new String[] { "Cliente", "Serviço", "Data", "Hora" }));
		currenteTable.updateUI();
		if (currentPage == 1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);

		int num_reg = GerenteBD.getInstance().getCountReserva(currentSearch,
				atendido,new java.sql.Date(txt_data.getDate().getTime()));
		int maxPage = num_reg / NUM_REG + 1;

		if (currentPage == maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);

		currentList = reserva;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BoxLayout(getJPanel(), BoxLayout.X_AXIS));
			jPanel.add(getJScrollPane1(), null);
			jPanel.setName("atendidos");
		}
		return jPanel;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTb_atendidos());
		}
		return jScrollPane1;
	}

	private JTable getTb_atendidos() {
		if (tb_atendidos == null) {
			tb_atendidos = new JTable();
			tb_atendidos.setModel(new DefaultTableModel(new Object[][] {
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null }, { null, null, null, null },
					{ null, null, null, null } }, new String[] { "Cliente",
					"Serviço", "Data", "Hora" }));
		}
		return tb_atendidos;
	}

	private JButton getBt_edit() {
		if (bt_edit == null) {
			bt_edit = new JButton();
			bt_edit.setText("Remover");
			bt_edit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l=currenteTable.getSelectedRow();
					if(l>-1){
						Reserva r=currentList.get(l);
						if(r!=null){
							//WindowManager.open(AgendarClienteForm.getInstance(r.getIdreserva()));
                                                        GerenteBD.getInstance().deleteReserva(r.getIdreserva());
                                                        atualizaTable(GerenteBD.getInstance().getNextReserva(
							txt_search.getText(), currentPage, atendido,new java.sql.Date(txt_data.getDate().getTime())));
							currentDate=txt_data.getDate();
                                                }
					}
				}
			});
		}
		return bt_edit;
	}
	
	public boolean isAtendido() {
		return atendido;
	}

	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}

	private JDateChooser getTxt_data() {
		if (txt_data == null) {
			txt_data = new JDateChooser();
			txt_data.setDate(new Date());
			txt_data.addPropertyChangeListener(new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					atualizaTable(GerenteBD.getInstance().getNextReserva(
							txt_search.getText(), currentPage, atendido,new java.sql.Date(txt_data.getDate().getTime())));
							currentDate=txt_data.getDate();
				}
			});
			
		}
		return txt_data;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

} // @jve:decl-index=0:visual-constraint="57,36"
