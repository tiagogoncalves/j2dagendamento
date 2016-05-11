package com.j2d.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.NumberFormatter;

import com.j2d.model.bd.GerenteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.model.negocio.Reserva;
import com.j2d.model.negocio.Tipo_servico;
import com.j2d.utils.Message;
import com.j2d.utils.TimeUtils;
import com.toedter.calendar.JDateChooser;

public class AgendarClienteForm extends JFrame {

	private static AgendarClienteForm singleton;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbl_cliente = null;
	private JTextField txt_cliente = null;
	private JLabel lbl_data = null;
	private JDateChooser txt_data = null;
	private JLabel lbl_hora = null;
	private JTextField txt_hora = null;
	private JLabel lbl_ponto = null;
	private JTextField txt_minuto = null;
	private JLabel lbl_servico = null;
	private JTextField txt_servico = null;
	private JButton bt_cliente = null;
	private JButton bt_servico = null;
	private JButton bt_ok = null;
	private JButton bt_cancelar = null;
	private Cliente c;  //  @jve:decl-index=0:
	private Tipo_servico t;  //  @jve:decl-index=0:
	private boolean inserir;
	private Reserva input;
	
	public static AgendarClienteForm getInstance(){
		if(singleton==null)
			singleton=new AgendarClienteForm();
		
		return singleton;
	}
	
	public static AgendarClienteForm getInstance(int id){
		if(singleton==null)
			singleton=new AgendarClienteForm(id);
		
		return singleton;
		
	}
	
	private AgendarClienteForm() {
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

	public AgendarClienteForm(int id) {
		super();
		initialize();
		inserir=false;
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
		
		preencheCampos(GerenteBD.getInstance().getOneReserva(id));
	}

	@SuppressWarnings("deprecation")
	private void preencheCampos(Reserva r) {
		input=r;
		this.c=GerenteBD.getInstance().getOneCliente(r.getIdcliente());
		this.t=GerenteBD.getInstance().getOneTipoServico(r.getIdtipo_servico());
		
		txt_cliente.setText(c.getNome()+" "+c.getSobrenome());
		txt_data.setDate(new java.util.Date(r.getData().getTime()));
		txt_hora.setText(Integer.toString(r.getHora().getHours()));
		txt_minuto.setText(Integer.toString(r.getHora().getMinutes()));
		txt_servico.setText(t.getDescricao());
		
		bt_ok.setText("Atualizar");
	}

	private void initialize() {
		this.setSize(364, 249);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Agendar Atendimento");
		this.setResizable(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_servico = new JLabel();
			lbl_servico.setBounds(new Rectangle(19, 128, 53, 16));
			lbl_servico.setText("Serviço: ");
			lbl_ponto = new JLabel();
			lbl_ponto.setText(":");
			lbl_ponto.setLocation(new Point(120, 94));
			lbl_ponto.setSize(new Dimension(8, 16));
			lbl_hora = new JLabel();
			lbl_hora.setText("Hora: ");
			lbl_hora.setLocation(new Point(18, 92));
			lbl_hora.setSize(new Dimension(38, 16));
			lbl_data = new JLabel();
			lbl_data.setBounds(new Rectangle(18, 55, 38, 16));
			lbl_data.setText("Data: ");
			lbl_cliente = new JLabel();
			lbl_cliente.setBounds(new Rectangle(18, 17, 56, 16));
			lbl_cliente.setText("Cliente: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbl_cliente, null);
			jContentPane.add(getTxt_cliente(), null);
			jContentPane.add(lbl_data, null);
			jContentPane.add(getTxt_data(), null);
			jContentPane.add(lbl_hora, null);
			jContentPane.add(getTxt_hora(), null);
			jContentPane.add(lbl_ponto, null);
			jContentPane.add(getTxt_minuto(), null);
			jContentPane.add(lbl_servico, null);
			jContentPane.add(getTxt_servico(), null);
			jContentPane.add(getBt_cliente(), null);
			jContentPane.add(getBt_servico(), null);
			jContentPane.add(getBt_ok(), null);
			jContentPane.add(getBt_cancelar(), null);
		}
		return jContentPane;
	}

	private JTextField getTxt_cliente() {
		if (txt_cliente == null) {
			txt_cliente = new JTextField();
			txt_cliente.setLocation(new Point(90, 15));
			txt_cliente.setSize(new Dimension(145, 25));
		}
		return txt_cliente;
	}

	private JDateChooser getTxt_data() {
		if (txt_data == null) {
			txt_data = new JDateChooser();
			txt_data.setLocation(new Point(90, 52));
			txt_data.setSize(new Dimension(191, 25));
		}
		return txt_data;
	}

	private JTextField getTxt_hora() {
		if (txt_hora == null) {
			txt_hora = new JFormattedTextField(new NumberFormatter());
			
			txt_hora.setLocation(new Point(89, 90));
			txt_hora.setPreferredSize(new Dimension(17, 28));
			txt_hora.setSize(new Dimension(30, 25));
		}
		return txt_hora;
	}

	private JTextField getTxt_minuto() {
		if (txt_minuto == null) {
			txt_minuto = new JFormattedTextField(new NumberFormatter());
		
			txt_minuto.setSize(new Dimension(30, 25));
			txt_minuto.setPreferredSize(new Dimension(17, 28));
			txt_minuto.setLocation(new Point(130, 90));
		}
		return txt_minuto;
	}

	private JTextField getTxt_servico() {
		if (txt_servico == null) {
			txt_servico = new JTextField();
			txt_servico.setLocation(new Point(91, 125));
			txt_servico.setSize(new Dimension(146, 25));
		}
		return txt_servico;
	}

	private JButton getBt_cliente() {
		if (bt_cliente == null) {
			bt_cliente = new JButton();
			bt_cliente.setText("Procurar...");
			bt_cliente.setSize(new Dimension(97, 25));
			bt_cliente.setLocation(new Point(240, 15));
			bt_cliente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ClienteChooser.open(AgendarClienteForm.this);
				}
			});
		}
		return bt_cliente;
	}

	private JButton getBt_servico() {
		if (bt_servico == null) {
			bt_servico = new JButton();
			bt_servico.setText("Procurar...");
			bt_servico.setSize(new Dimension(97, 25));
			bt_servico.setLocation(new Point(242, 124));
			bt_servico.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ServicoChooser.open(AgendarClienteForm.this);
				}
			});
		}
		return bt_servico;
	}

	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setText("Agendar");
			bt_ok.setSize(new Dimension(85, 25));
			bt_ok.setLocation(new Point(154, 169));
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result=0;
					int hora=Integer.parseInt(txt_hora.getText());
					int minuto=Integer.parseInt(txt_minuto.getText());
					if(!TimeUtils.validaHora(hora)||
					   !TimeUtils.validaMinuto(minuto)){
						JOptionPane.showMessageDialog(AgendarClienteForm.this, "Hora inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
						return ;
					}
					if(c==null){
						JOptionPane.showMessageDialog(AgendarClienteForm.this, "Selecione um cliente!", "Atenção", JOptionPane.WARNING_MESSAGE);
						return ;
					}
					if(t==null){
						JOptionPane.showMessageDialog(AgendarClienteForm.this, "Selecione um serviço!", "Atenção", JOptionPane.WARNING_MESSAGE);
						return ;
					}
						
					if(inserir){
						Reserva r=new Reserva();
						r.setIdcliente(c.getIdcliente());
						r.setIdtipo_servico(t.getIdtipo_servico());
						r.setHora(new Time(hora,minuto,0));
						r.setData(new Date(txt_data.getDate().getTime()));
						
						result=GerenteBD.getInstance().insert(r);
					}else{
						
						Reserva r=new Reserva();
						r.setIdcliente(c.getIdcliente());
						r.setIdtipo_servico(t.getIdtipo_servico());
						r.setHora(new Time(hora,minuto,0));
						r.setData(new Date(txt_data.getDate().getTime()));
						r.setIdreserva(input.getIdreserva());
						r.setAtendido(input.isAtendido());
						
						result=GerenteBD.getInstance().update(r);
						
					}
					
					AgendaView a=AgendaView.getInstance();
					if(a.isVisible())
						a.atualizaTable(GerenteBD.getInstance().getNextReserva(a.getCurrentSearch(), 1, a.isAtendido(),new java.sql.Date(txt_data.getDate().getTime())));
					
					if(result==Message.SUCCESS_MENSAGE){
						JOptionPane.showMessageDialog(AgendarClienteForm.this, Message.getMensage(result));
						ClientesFrame frame=ClientesFrame.getInstance();
						if(frame.isVisible())
							frame.atualizaTable(GerenteBD.getInstance().getPage(1,""));
						AgendarClienteForm.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(AgendarClienteForm.this, "Erro ao agendar um cliente", "Error!", JOptionPane.ERROR_MESSAGE);
					
				}
			});
		}
		return bt_ok;
	}

	private JButton getBt_cancelar() {
		if (bt_cancelar == null) {
			bt_cancelar = new JButton();
			bt_cancelar.setText("Cancelar");
			bt_cancelar.setSize(new Dimension(89, 25));
			bt_cancelar.setLocation(new Point(250, 169));
			bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					singleton=null;
					AgendarClienteForm.this.dispose();
				}
			});
		}
		return bt_cancelar;
	}

	public void setCliente(Cliente c) {
		this.c = c;
		txt_cliente.setText(c.getNome()+" "+c.getSobrenome());
	}

	public Cliente getCliente() {
		return c;
	}

	public void setServico(Tipo_servico t) {
		this.t = t;
		txt_servico.setText(t.getDescricao());
	}

	public Tipo_servico getServico() {
		return t;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
