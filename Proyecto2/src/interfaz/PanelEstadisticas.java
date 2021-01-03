package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.EventosEstadisticas;
import modelo.*;

public class PanelEstadisticas extends JPanel {
	private JTable tabla;
	private DefaultTableModel modelo;
	private JButton botton1,botton2,botton3;
	private Exam datos;
	
	public PanelEstadisticas(Exam datos) throws ClassNotFoundException, SQLException {
		this.datos = datos;
		this.setLayout(null);
		this.setBackground(Color.black);
		tabla();
		botones();
		ingresarDatosATabla();
	}
	
	private void tabla() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Usuario");
		modelo.addColumn("Nombre Usuario");
		modelo.addColumn("examen");
		modelo.addColumn("puntaje");
		
		tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(75, 10, 400, 200);
		this.add(scroll,BorderLayout.CENTER);
		
	}
	
	private void ingresarDatosATabla() throws ClassNotFoundException, SQLException {
		modelo = (DefaultTableModel) tabla.getModel();
		this.datos.sacarDatos(this);
	}
	
	private void botones() {
		EventosEstadisticas e = new EventosEstadisticas(this);
		botton1 = new JButton("Ordenar de Mayor Puntaje");
		botton1.setBounds(150, 230, 250, 25);
		botton1.addActionListener(e);
		this.add(botton1);
		
		botton2 = new JButton("Obtener Usuario Con mas Examenes");
		botton2.setBounds(150, 260, 250, 25);
		botton2.addActionListener(e);
		this.add(botton2);
		
		botton3 = new JButton("Ordenar de Menor Puntaje ");
		botton3.setBounds(150, 290, 250, 25);
		botton3.addActionListener(e);
		this.add(botton3);
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JButton getBotton1() {
		return botton1;
	}

	public void setBotton1(JButton botton1) {
		this.botton1 = botton1;
	}

	public JButton getBotton2() {
		return botton2;
	}

	public void setBotton2(JButton botton2) {
		this.botton2 = botton2;
	}

	public JButton getBotton3() {
		return botton3;
	}

	public void setBotton3(JButton botton3) {
		this.botton3 = botton3;
	}

	public Exam getDatos() {
		return datos;
	}

	public void setDatos(Exam datos) {
		this.datos = datos;
	}
}
