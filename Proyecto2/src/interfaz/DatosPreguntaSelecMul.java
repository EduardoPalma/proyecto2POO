package interfaz;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

import modelo.PreguntSelecMul;
import modelo.Pregunta;

public class DatosPreguntaSelecMul {
	private JComboBox<String> respuestas;
	private ArrayList<String> opciones;
	private JLabel cantidadAlternativas;
	private PanelCrearExamen panel;
	private int cantidadPreguntas;
	private int indiceRespuesta;
	
	public DatosPreguntaSelecMul(PanelCrearExamen panel) {
		this.panel = panel;
		this.cantidadPreguntas = 0;
		iniciar();
	}
	
	private void iniciar() {
		cantidadAlternativas = new JLabel("Cantidad Alternativas");
		cantidadAlternativas.setBounds(30, 200, 140, 25);
		cantidadAlternativas.setBackground(Color.black);
		cantidadAlternativas.setForeground(Color.white);
		cantidadAlternativas.setVisible(false);
		this.panel.add(cantidadAlternativas);
		
		respuestas = new JComboBox<String>();
		respuestas.setBounds(151, 200, 140, 25);
		respuestas.setVisible(false);
		for(int i=2;i<7;i++) {
			respuestas.addItem(String.valueOf(i));
		}
		this.panel.add(respuestas);
		opciones = new ArrayList<String>();
	}
	
	public void mostrar() {
		cantidadAlternativas.setVisible(true);
		respuestas.setVisible(true);
	}
	
	public void noMostrar() {
		cantidadAlternativas.setVisible(false);
		respuestas.setVisible(false);
		opciones.clear();
	}
	
	
	
	public void cantPreguntas() {
		this.cantidadPreguntas = Integer.parseInt((String) respuestas.getSelectedItem());
	}
	
	public void llenarOpciones() {
		this.opciones.clear();
		System.out.print(this.cantidadPreguntas);
		for(int i=0;i<this.cantidadPreguntas;i++) {
			String opcion = JOptionPane.showInputDialog("ingrese alternativa "+(i+1));
			opciones.add(opcion);
		}
	}
	
	public void respuestaCorrecta() {
		String [] alter = new String[this.cantidadPreguntas];
		for(int i=0;i<this.cantidadPreguntas;i++) {
			alter[i] = this.opciones.get(i);
		}
		String resp = (String) JOptionPane.showInputDialog(panel, "Seleccione la alternativa Correcta", "Opciones", JOptionPane.DEFAULT_OPTION, null, alter, alter[0]);
		
		for(int j=0;j<this.cantidadPreguntas;j++) {
			
			if(resp.equalsIgnoreCase(alter[j])) this.indiceRespuesta = j;
		}
	}
	
	public Pregunta pregunta() {
		String text = panel.getPanelPreguntas().getTexto().getText();
		int peso = panel.getPanelPreguntas().getPuntajes().getSelectedIndex()+1;
		String [] resp = new String[this.cantidadPreguntas];
		for(int i=0;i<opciones.size();i++) {
			resp[i] = opciones.get(i);
		}
		
		Pregunta p = new PreguntSelecMul(text,peso,resp,this.indiceRespuesta);
		return p;
	}

	public JComboBox<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(JComboBox<String> respuestas) {
		this.respuestas = respuestas;
	}

	public JLabel getCantidadAlternativas() {
		return cantidadAlternativas;
	}

	public void setCantidadAlternativas(JLabel cantidadAlternativas) {
		this.cantidadAlternativas = cantidadAlternativas;
	}

	public PanelCrearExamen getPanel() {
		return panel;
	}

	public void setPanel(PanelCrearExamen panel) {
		this.panel = panel;
	}

	public ArrayList<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}

	public int getCantidadPreguntas() {
		return cantidadPreguntas;
	}

	public void setCantidadPreguntas(int cantidadPreguntas) {
		this.cantidadPreguntas = cantidadPreguntas;
	}
	
}
