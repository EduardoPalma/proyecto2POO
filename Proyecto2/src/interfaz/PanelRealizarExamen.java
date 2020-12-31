package interfaz;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;


public class PanelRealizarExamen extends JPanel {
	private JButton siguiente,ant;
	private JRadioButton verdadero,falso;
	private ArrayList<JRadioButton> opciones;
	private ButtonGroup grupoSeleccionMultiple,grupoVerFalso;
	private JLabel textoPregunta,tipoPregunta,respuestaCorta;
	private JTextField respuesta;
	private int indicePregunta;
	
	
	public PanelRealizarExamen() {
		this.indicePregunta = 0;
		setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		setBounds(15,55 , 550, 270);
		setVisible(true);
		texto();
		botones();
	}
	
	private void texto() {
		textoPregunta = new JLabel();
		textoPregunta.setForeground(Color.WHITE);
		textoPregunta.setBounds(10, 50, 300, 25);
		add(textoPregunta);
		
		tipoPregunta = new JLabel();
		tipoPregunta.setForeground(Color.WHITE);
		tipoPregunta.setBounds(10, 15, 200, 25);
		add(tipoPregunta);
		
		PreguntaVF();
		PreguntaCorta();
		PreguntaSelecMultiple();
	}
	
	private void botones() {
		siguiente = new JButton("siguiente");
		siguiente.setBounds(325, 245, 100, 25);
		siguiente.setVisible(false);
		add(siguiente);
		
		ant = new JButton("anterior");
		ant.setBounds(125, 245, 100, 25);
		ant.setVisible(false);
		add(ant);
	}
	
	private void PreguntaVF(){
		grupoVerFalso = new ButtonGroup();
		
		verdadero = new JRadioButton("Verdadero");
		verdadero.setForeground(Color.WHITE);
		verdadero.setBackground(Color.DARK_GRAY);
		verdadero.setBounds(50,80,100,25);
		verdadero.setVisible(false);
		add(verdadero);
		
		falso = new JRadioButton("Falso");
		falso.setForeground(Color.WHITE);
		falso.setBackground(Color.DARK_GRAY);
		falso.setBounds(50, 100, 100, 25);
		falso.setVisible(false);
		add(falso);
		
		grupoVerFalso.add(verdadero);
		grupoVerFalso.add(falso);
		
	}
	
	public void visibleVF() {
		verdadero.setVisible(true);
		falso.setVisible(true);
	}
	
	public void noVisibleVF() {
		verdadero.setVisible(false);
		falso.setVisible(false);
	}
	
	
	private void PreguntaCorta() {
		respuesta = new JTextField();
		respuesta.setBounds(150, 100, 100, 25);
		respuesta.setVisible(false);
		add(respuesta);
		
		respuestaCorta = new JLabel("Respuesta ");
		respuestaCorta.setForeground(Color.WHITE);
		respuestaCorta.setBounds(50, 100, 100, 25);
		respuestaCorta.setVisible(false);
		add(respuestaCorta);
	}
	
	public void limpiarRespuesta() {
		respuesta.setText(null);
	}
	
	private void PreguntaSelecMultiple() {
		grupoSeleccionMultiple = new ButtonGroup();
		opciones = new ArrayList<JRadioButton>();
		int posy = 0;
		for(int i=0;i<6;i++) {
			JRadioButton boton = new JRadioButton();
			boton.setBounds(50, 80+posy, 100, 25);
			boton.setForeground(Color.WHITE);
			boton.setBackground(Color.DARK_GRAY);
			boton.setVisible(false);
			add(boton);
			opciones.add(boton);
			grupoSeleccionMultiple.add(boton);
			posy+=20;
		}
	}
	
	public void cargarSelecciones(String [] respuestas) {
		int cantidadRespuestas;
		for(cantidadRespuestas = 0;cantidadRespuestas<respuestas.length;cantidadRespuestas++) {
			if(respuestas[cantidadRespuestas] == null) break;
		}
		for(int i=0;i<cantidadRespuestas;i++) {
			JRadioButton boton = opciones.get(i);
			boton.setText(respuestas[i]);
			boton.setVisible(true);
		}
	}
	
	public void limpiarGrupoBotones() {
		for(int i=0;i<opciones.size();i++) {
			JRadioButton bton = opciones.get(i);
			bton.setVisible(false);
		}
	}
	
	
	public JButton getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(JButton siguiente) {
		this.siguiente = siguiente;
	}


	public JButton getAnt() {
		return ant;
	}


	public void setAnt(JButton ant) {
		this.ant = ant;
	}

	public JLabel getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(JLabel textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public int getIndicePregunta() {
		return indicePregunta;
	}

	public void setIndicePregunta(int indicePregunta) {
		this.indicePregunta = indicePregunta;
	}

	public JTextField getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(JTextField respuesta) {
		this.respuesta = respuesta;
	}

	public JLabel getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(JLabel tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public JLabel getRespuestaCorta() {
		return respuestaCorta;
	}

	public void setRespuestaCorta(JLabel respuestaCorta) {
		this.respuestaCorta = respuestaCorta;
	}

	public JRadioButton getVerdadero() {
		return verdadero;
	}

	public void setVerdadero(JRadioButton verdadero) {
		this.verdadero = verdadero;
	}

	public JRadioButton getFalso() {
		return falso;
	}

	public void setFalso(JRadioButton falso) {
		this.falso = falso;
	}

	public ButtonGroup getGrupoSeleccionMultiple() {
		return grupoSeleccionMultiple;
	}

	public void setGrupoSeleccionMultiple(ButtonGroup grupoSeleccionMultiple) {
		this.grupoSeleccionMultiple = grupoSeleccionMultiple;
	}

	public ButtonGroup getGrupoVerFalso() {
		return grupoVerFalso;
	}

	public void setGrupoVerFalso(ButtonGroup grupoVerFalso) {
		this.grupoVerFalso = grupoVerFalso;
	}

	public ArrayList<JRadioButton> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<JRadioButton> opciones) {
		this.opciones = opciones;
	}
	
}
