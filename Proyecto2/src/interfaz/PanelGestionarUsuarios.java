package interfaz;


import java.awt.Color;
import javax.swing.*;

import controlador.OpcionesGestion;


public class PanelGestionarUsuarios extends JPanel {
	private TablaUsuarios tablaUsuarios;
	private PanelAdmin panelAdmin;
	private JLabel texto1;
	private JTextField nombreUsuario;
	private JButton hacerProfesor,hacerAdmin;
	
	public PanelGestionarUsuarios(PanelAdmin panelAdmin) {
		this.panelAdmin = panelAdmin;
		this.setLayout(null);
		this.setBounds(200, 5 , 360, 325);
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
		iniciarTabla();
		botones();
		texto();
		
	}
	
	private void iniciarTabla() {
		tablaUsuarios = new TablaUsuarios();
		JScrollPane scroll = new JScrollPane(tablaUsuarios);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroll.setVisible(true);
		scroll.setBounds(0,0,360,200);
		this.add(scroll);
	}
	
	private void texto() {
		texto1 = new JLabel("ingrese Nombre Usuario ");
		texto1.setBackground(Color.black);
		texto1.setForeground(Color.white);
		texto1.setBounds(45, 220, 150, 25);
		this.add(texto1);
		
		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(200, 220, 150, 25);
		this.add(nombreUsuario);
	}
	
	private void botones() {
		hacerProfesor = new JButton("Hacer Profesor");
		hacerProfesor.setVisible(true);
		hacerProfesor.setBounds(25, 275, 140, 25);
		hacerProfesor.addActionListener(new OpcionesGestion(this.panelAdmin.getDatos(),this));
		this.add(hacerProfesor);
		hacerAdmin = new JButton("Hacer Admin");
		hacerAdmin.setVisible(true);
		hacerAdmin.setBounds(200, 275, 140, 25);
		hacerAdmin.addActionListener(new OpcionesGestion(this.panelAdmin.getDatos(),this));
		this.add(hacerAdmin);
	}

	public TablaUsuarios getTablaUsuarios() {
		return tablaUsuarios;
	}

	public void setTablaUsuarios(TablaUsuarios tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	public PanelAdmin getPanelAdmin() {
		return panelAdmin;
	}

	public void setPanelAdmin(PanelAdmin panelAdmin) {
		this.panelAdmin = panelAdmin;
	}

	public JLabel getTexto1() {
		return texto1;
	}

	public void setTexto1(JLabel texto1) {
		this.texto1 = texto1;
	}

	public JTextField getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(JTextField nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public JButton getHacerProfesor() {
		return hacerProfesor;
	}

	public void setHacerProfesor(JButton hacerProfesor) {
		this.hacerProfesor = hacerProfesor;
	}

	public JButton getHacerAdmin() {
		return hacerAdmin;
	}

	public void setHacerAdmin(JButton hacerAdmin) {
		this.hacerAdmin = hacerAdmin;
	}
	
}
