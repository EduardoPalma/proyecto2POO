package interfaz;

import java.awt.Color;

import javax.swing.*;

import modelo.Pregunta;
import modelo.TFpregunta;

public class DatosPreguntaVyF {
	private PanelCrearExamen panelCrearExamen;
	private JLabel respuestaCorrecta;
	private JComboBox<String> trueOfalse;
	
	public DatosPreguntaVyF(PanelCrearExamen panelCrearExamen) {
		this.panelCrearExamen = panelCrearExamen;
		iniciar();
	}
	
	
	private void iniciar() {
		respuestaCorrecta = new JLabel("Respuesta Correcta");
		respuestaCorrecta.setVisible(false);
		respuestaCorrecta.setBounds(30, 200, 140, 25);
		respuestaCorrecta.setBackground(Color.black);
		respuestaCorrecta.setForeground(Color.white);
		this.panelCrearExamen.add(respuestaCorrecta);
		
		trueOfalse = new JComboBox<String>();
		trueOfalse.addItem("Verdadero");
		trueOfalse.addItem("Falso");
		trueOfalse.setVisible(false);
		trueOfalse.setBounds(150,200 , 140, 25);
		this.panelCrearExamen.add(trueOfalse);
	}
	
	public void mostrar() {
		respuestaCorrecta.setVisible(true);
		trueOfalse.setVisible(true);
	}
	
	public void noMostrar() {
		respuestaCorrecta.setVisible(false);
		trueOfalse.setVisible(false);
	}
	
	public Pregunta pregunta() {
		String text = panelCrearExamen.getPanelPreguntas().getTexto().getText();
		int peso = panelCrearExamen.getPanelPreguntas().getPuntajes().getSelectedIndex()+1;
		boolean resp; 
		if(trueOfalse.getSelectedIndex() == 0) resp = true;
		else resp = false;
		Pregunta p = new TFpregunta(text,peso,resp);
		return p;
	}


	public PanelCrearExamen getPanelCrearExamen() {
		return panelCrearExamen;
	}


	public void setPanelCrearExamen(PanelCrearExamen panelCrearExamen) {
		this.panelCrearExamen = panelCrearExamen;
	}


	public JLabel getRespuestaCorrecta() {
		return respuestaCorrecta;
	}


	public void setRespuestaCorrecta(JLabel respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}


	public JComboBox<String> getTrueOfalse() {
		return trueOfalse;
	}


	public void setTrueOfalse(JComboBox<String> trueOfalse) {
		this.trueOfalse = trueOfalse;
	}
}
