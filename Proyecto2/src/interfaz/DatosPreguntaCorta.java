package interfaz;

import java.awt.Color;

import javax.swing.*;

import modelo.PregunCortas;
import modelo.Pregunta;

public class DatosPreguntaCorta {
	private JLabel respuesta;
	private JTextField respuestaCorta;
	private PanelCrearExamen panel;
	
	public DatosPreguntaCorta(PanelCrearExamen panel) {
		this.panel = panel;
		iniciar();
	}
	
	private void iniciar() {
		respuesta = new JLabel("Respuesta Corta");
		respuesta.setBounds(30, 200, 140, 25);
		respuesta.setBackground(Color.black);
		respuesta.setForeground(Color.white);
		respuesta.setVisible(false);
		this.panel.add(respuesta);
		
		respuestaCorta = new JTextField();
		respuestaCorta.setBounds(150, 200, 140, 25);
		respuestaCorta.setVisible(false);
		this.panel.add(respuestaCorta);
	}
	
	public void mostrar() {
		respuesta.setVisible(true);
		respuestaCorta.setVisible(true);
	}
	
	public void noMostrar() {
		respuesta.setVisible(false);
		respuestaCorta.setVisible(false);
	}
	
	public Pregunta pregunta() {
		String text = panel.getPanelPreguntas().getTexto().getText();
		int peso = panel.getPanelPreguntas().getPuntajes().getSelectedIndex()+1;
		Pregunta p = new PregunCortas(text,peso,this.respuestaCorta.getText());
		return p;
		
	}

	public JLabel getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(JLabel respuesta) {
		this.respuesta = respuesta;
	}

	public JTextField getRespuestaCorta() {
		return respuestaCorta;
	}

	public void setRespuestaCorta(JTextField respuestaCorta) {
		this.respuestaCorta = respuestaCorta;
	}

	public PanelCrearExamen getPanel() {
		return panel;
	}

	public void setPanel(PanelCrearExamen panel) {
		this.panel = panel;
	}
	
	
}
