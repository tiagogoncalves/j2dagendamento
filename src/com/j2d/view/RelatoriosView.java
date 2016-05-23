package com.j2d.view;

import com.j2d.model.bd.ClienteBD;
import com.j2d.model.negocio.Cliente;
import com.j2d.utils.WindowManager;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RelatoriosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton btnRelClientesMaisAtendidos = null;
	private JScrollPane jScrollPane = null;
	private static RelatoriosView singleton;
	
	public static RelatoriosView getInstance(){
		if(singleton==null)
			singleton=new RelatoriosView();
		
		return singleton;
	}
	
	public RelatoriosView() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(701, 385);
		this.setContentPane(getJContentPane());
		this.setTitle("Relatórios");
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
			btnRelClientesMaisAtendidos = new JButton("Clientes mais atendidos");
                        btnRelClientesMaisAtendidos.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
                                        System.out.println("Clientes");
                                    Vector<Cliente> clientes = ClienteBD.getInstance().getAll();
                                    Iterator it = clientes.iterator();
                                    while(it.hasNext()){
                                        Cliente cliente = (Cliente) it.next();
                                        System.out.println(cliente);
                                       
                                    }
				}
			});
                        
                        
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(btnRelClientesMaisAtendidos, gridBagConstraints);
		}
		return jContentPane;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
		}
		return jScrollPane;
	}

	
}  //  @jve:decl-index=0:visual-constraint="10,10"
