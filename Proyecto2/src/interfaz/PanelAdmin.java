package interfaz;

import java.awt.Color;

import javax.swing.*;

import modelo.Exam;

public class PanelAdmin extends JPanel {
	private JButton crearExamen,eliminarExamen,gestionarUsuarios;
	private PanelCrearExamen panelCrearExamen;
	private PanelEliminarExamen panelEliminarExamen;
	private PanelGestionarUsuarios panelGestionarUsuarios;
	private PanelExamen panelExamen;
	private Exam datos;
	
	public PanelAdmin(Exam datos,PanelExamen panelExamen) {
		this.panelExamen = panelExamen;
		this.datos = datos;
		setLayout(null);
		this.setBackground(Color.BLACK);
		botones();
		paneles();
	}
	
	private void paneles() {
		panelCrearExamen = new PanelCrearExamen(this);
		panelCrearExamen.setVisible(false);
		add(panelCrearExamen);
		
		panelEliminarExamen = new PanelEliminarExamen(datos,panelExamen);
		panelEliminarExamen.setVisible(false);
		add(panelEliminarExamen);
		
		panelGestionarUsuarios = new PanelGestionarUsuarios();
		panelGestionarUsuarios.setVisible(false);
		add(panelGestionarUsuarios);
	}
	
	private void botones() {
		crearExamen = new JButton("CREAR EXAMEN");
		crearExamen.setBounds(30, 50, 150, 25);
		add(crearExamen);
		
		eliminarExamen = new JButton("ELIMINAR EXAMEN");
		eliminarExamen.setBounds(30, 100, 150, 25);
		add(eliminarExamen);
		
		gestionarUsuarios = new JButton("GESTION USUARIOS");
		gestionarUsuarios.setBounds(30, 150, 150, 25);
		add(gestionarUsuarios);
	}
	
	public void noVisisble() {
		this.crearExamen.setEnabled(true);
		this.eliminarExamen.setEnabled(true);
		this.gestionarUsuarios.setEnabled(true);
	}
	
	public void visible() {
		this.crearExamen.setEnabled(false);
		this.eliminarExamen.setEnabled(false);
		this.gestionarUsuarios.setEnabled(false);
	}

	public JButton getCrearExamen() {
		return crearExamen;
	}

	public void setCrearExamen(JButton crearExamen) {
		this.crearExamen = crearExamen;
	}

	public JButton getEliminarExamen() {
		return eliminarExamen;
	}

	public void setEliminarExamen(JButton eliminarExamen) {
		this.eliminarExamen = eliminarExamen;
	}

	public JButton getGestionarUsuarios() {
		return gestionarUsuarios;
	}

	public void setGestionarUsuarios(JButton gestionarUsuarios) {
		this.gestionarUsuarios = gestionarUsuarios;
	}

	public PanelCrearExamen getPanelCrearExamen() {
		return panelCrearExamen;
	}

	public void setPanelCrearExamen(PanelCrearExamen panelCrearExamen) {
		this.panelCrearExamen = panelCrearExamen;
	}

	public PanelEliminarExamen getPanelEliminarExamen() {
		return panelEliminarExamen;
	}

	public void setPanelEliminarExamen(PanelEliminarExamen panelEliminarExamen) {
		this.panelEliminarExamen = panelEliminarExamen;
	}

	public PanelGestionarUsuarios getPanelGestionarUsuarios() {
		return panelGestionarUsuarios;
	}

	public void setPanelGestionarUsuarios(PanelGestionarUsuarios panelGestionarUsuarios) {
		this.panelGestionarUsuarios = panelGestionarUsuarios;
	}

	public Exam getDatos() {
		return datos;
	}

	public void setDatos(Exam datos) {
		this.datos = datos;
	}

	public PanelExamen getPanelExamen() {
		return panelExamen;
	}

	public void setPanelExamen(PanelExamen panelExamen) {
		this.panelExamen = panelExamen;
	}
}
