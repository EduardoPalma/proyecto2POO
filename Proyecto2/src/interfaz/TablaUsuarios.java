package interfaz;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelo.Exam;

public class TablaUsuarios extends JPanel {
	private JTable tabla;
	private DefaultTableModel modelo;
	public TablaUsuarios() {
		this.setLayout(null);
		this.setBounds(10, 10, 400, 200);
		this.setPreferredSize(new Dimension(600,300));
		this.setVisible(true);
		tabla();
	}
	
	
	public void tabla() {
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Nombre Usuario");
		modelo.addColumn("Correo Electronico");
		modelo.addColumn("Profesor");
		modelo.addColumn("Admin");
		
		tabla = new JTable(modelo);
		tabla.setVisible(true);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(0, 0,600, 200);
		scroll.setVisible(true);
		this.add(scroll);
	}
	
	public void ingresarUsuariosATabla(Exam datos) {
        modelo=(DefaultTableModel) tabla.getModel(); 
        
        for(int i=0;i<datos.getUsuarios().size();i++) {
	        Object [] fila=new Object[7]; 
	 
	        fila[0]=datos.getUsuarios().get(i).getNombre(); 
	        fila[1]=datos.getUsuarios().get(i).getApellido(); 
	        fila[2]=datos.getUsuarios().get(i).getPassword(); 
	        fila[3]=datos.getUsuarios().get(i).getNombreUsuario(); 
	        fila[4]=datos.getUsuarios().get(i).getCorreo(); 
	        fila[5]=datos.getUsuarios().get(i).isProfesor();
	        fila[6]=datos.getUsuarios().get(i).isAdmin(); 
	 
	        modelo.addRow(fila); 
	        tabla.setModel(modelo); 
        }
	}
	
	public void visible() {
		this.setVisible(true);
	}
	
	public void noVisisble() {
		this.setVisible(false);
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

}
