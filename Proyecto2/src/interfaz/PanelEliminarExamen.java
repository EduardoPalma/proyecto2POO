package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import modelo.Exam;

public class PanelEliminarExamen extends JPanel implements ActionListener {
	private JComboBox<String> examenes;
	private Exam datos;
	private JLabel seleccionarExamen;
	private JButton eliminarExamen;
	private PanelExamen panelExamen;
	
	public PanelEliminarExamen(Exam datos,PanelExamen panelExamen) {
		this.panelExamen = panelExamen;
		this.datos = datos;
		setLayout(null);
		this.setBounds(200, 5, 360, 325);
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
		this.examenes = new JComboBox<String>();
		textos();
		boton();
		cargarExamenes();
		examenes.setBounds(150, 100, 140, 25);
		add(examenes);
		
	}
	
	private void textos() {
		seleccionarExamen = new JLabel("Seleccione Examen");
		seleccionarExamen.setBackground(Color.black);
		seleccionarExamen.setForeground(Color.WHITE);
		seleccionarExamen.setBounds(30,100, 140, 25);
		add(seleccionarExamen);
	}
	
	private void boton() {
		eliminarExamen = new JButton("Eliminar Examen");
		eliminarExamen.setBounds(115, 180, 140, 25);
		eliminarExamen.addActionListener(this);
		add(eliminarExamen);
	}
	
	private void cargarExamenes() {
		System.out.println(
				this.datos.getNamExam().toString());
		for(int i=0;i<datos.getNamExam().size();i++) {
			this.examenes.addItem(datos.getNamExam().get(i));
		}
	}
	
	public void actualizar() {
		this.examenes.removeAllItems();
		for(int i=0;i<datos.getNamExam().size();i++) {
			this.examenes.addItem(datos.getNamExam().get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int resp = JOptionPane.showConfirmDialog(this, "¿ Desea Eliminar El Examen ?");
		if(resp == 0) {
			int indice = this.examenes.getSelectedIndex();
			this.examenes.removeAllItems();
			try {
				this.datos.eliminarExamen(indice);
				JOptionPane.showMessageDialog(this, "¡¡¡ Examen a sido Eliminado !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panelExamen.actualizar(datos);
			cargarExamenes();
			
		}
		
	}
	
	public void visible() {
		this.eliminarExamen.setVisible(true);
		this.examenes.setVisible(true);
		this.seleccionarExamen.setVisible(true);
	}
	
	public void noVisible() {
		this.eliminarExamen.setVisible(false);
		this.examenes.setVisible(false);
		this.seleccionarExamen.setVisible(false);
	}

	public JComboBox<String> getExamenes() {
		return examenes;
	}

	public void setExamenes(JComboBox<String> examenes) {
		this.examenes = examenes;
	}

	public Exam getDatos() {
		return datos;
	}

	public void setDatos(Exam datos) {
		this.datos = datos;
	}

	public JLabel getSeleccionarExamen() {
		return seleccionarExamen;
	}

	public void setSeleccionarExamen(JLabel seleccionarExamen) {
		this.seleccionarExamen = seleccionarExamen;
	}

	public JButton getEliminarExamen() {
		return eliminarExamen;
	}

	public void setEliminarExamen(JButton eliminarExamen) {
		this.eliminarExamen = eliminarExamen;
	}

	public PanelExamen getPanelExamen() {
		return panelExamen;
	}

	public void setPanelExamen(PanelExamen panelExamen) {
		this.panelExamen = panelExamen;
	}
}
