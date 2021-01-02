package interfaz;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import modelo.Exam;


public class PanelExamen extends JPanel {
	private JComboBox<String> pruebas;
	private ArrayList<String> nombrePruebas;
	private JLabel seleccion;
	private JButton hacerExamen,finalizarExamen;
	private PanelRealizarExamen panelExamen;
	
	public PanelExamen(ArrayList<String> nombrePruebas) {
		this.nombrePruebas = nombrePruebas;
		this.setBackground(Color.black);
		setLayout(null);
		textos();
		cargarNombresPruebas();
		boton();
		panelExamen();
	}
	
	private void cargarNombresPruebas() {
		this.pruebas = new JComboBox<String>();
		for(int i=0;i<nombrePruebas.size();i++) {
			this.pruebas.addItem(nombrePruebas.get(i));
		}
		pruebas.setBounds(160, 25, 100, 25);
		add(pruebas);
	}
	
	private void textos() {
		seleccion = new JLabel("Seleccione un Examen");
		seleccion.setBounds(25, 25, 150, 25);
		seleccion.setBackground(Color.black);
		seleccion.setForeground(Color.WHITE);
		add(seleccion);
	}
	
	private void boton() {
		hacerExamen = new JButton("hacer el examen");
		hacerExamen.setBounds(275, 25, 130, 25);
		add(hacerExamen);
		
		finalizarExamen = new JButton("Finalizar Examen");
		finalizarExamen.setBounds(410, 25, 130, 25);
		finalizarExamen.setEnabled(false);
		add(finalizarExamen);
	}
	
	private void panelExamen() {
		panelExamen = new PanelRealizarExamen();
		add(panelExamen);
	}
	
	public void actualizar(Exam datos) {
		this.pruebas.removeAllItems();
		for(int i=0;i<datos.getNamExam().size();i++) {
			this.pruebas.addItem(datos.getNamExam().get(i));
		}
	}

	public JComboBox<String> getPruebas() {
		return pruebas;
	}

	public void setPruebas(JComboBox<String> pruebas) {
		this.pruebas = pruebas;
	}

	public ArrayList<String> getNombrePruebas() {
		return nombrePruebas;
	}

	public void setNombrePruebas(ArrayList<String> nombrePruebas) {
		this.nombrePruebas = nombrePruebas;
	}

	public JLabel getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(JLabel seleccion) {
		this.seleccion = seleccion;
	}

	public JButton getHacerExamen() {
		return hacerExamen;
	}

	public void setHacerExamen(JButton hacerExamen) {
		this.hacerExamen = hacerExamen;
	}

	public PanelRealizarExamen getPanelExamen() {
		return panelExamen;
	}

	public void setPanelExamen(PanelRealizarExamen panelExamen) {
		this.panelExamen = panelExamen;
	}

	public JButton getFinalizarExamen() {
		return finalizarExamen;
	}

	public void setFinalizarExamen(JButton finalizarExamen) {
		this.finalizarExamen = finalizarExamen;
	}

}
