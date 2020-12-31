package interfaz;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class PanelPreguntas extends JPanel implements ItemListener {
	private JComboBox<String> tipoPreguntas;
	private JTextArea texto;
	private JLabel tipoPregunta,textoPregunta,respuesta,textoPuntaje;
	private JTextField puntaje;
	private PanelCrearExamen panel;
	private JButton ingresarPregunta;
	
	public PanelPreguntas(PanelCrearExamen panel) {
		this.panel = panel;
		textos();
		boton();
	}
	
	private void textos() {
		tipoPregunta = new JLabel("tipo Pregunta ");
		tipoPregunta.setBounds(30, 20, 100, 25);
		tipoPregunta.setBackground(Color.black);
		tipoPregunta.setForeground(Color.white);
		tipoPregunta.setVisible(false);
		this.panel.add(tipoPregunta);
		
		tipoPreguntas = new JComboBox<String>();
		tipoPreguntas.setBounds(150, 22, 140, 25);
		tipoPreguntas.addItem("Verdadero y Falso");
		tipoPreguntas.addItem("Seleccion Multiple");
		tipoPreguntas.addItem("Pregunta Corta");
		tipoPreguntas.setVisible(false);
		tipoPreguntas.addItemListener(this);
		this.panel.add(tipoPreguntas);
		
		textoPregunta = new JLabel("texto de pregunta");
		textoPregunta.setBounds(30, 60 , 140, 25);
		textoPregunta.setBackground(Color.black);
		textoPregunta.setForeground(Color.white);
		textoPregunta.setVisible(false);
		this.panel.add(textoPregunta);
		
		texto = new JTextArea();
		texto.setBounds(150, 60, 150, 100);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		texto.setVisible(false);
		this.panel.add(texto);
	}
	
	private void boton() {
		this.ingresarPregunta = new JButton("Ingresar Pregunta");
		this.ingresarPregunta.setBounds(125, 200, 140, 25);
		this.ingresarPregunta.setVisible(false);
		this.panel.add(this.ingresarPregunta);
	}
	
	private void preguntaVyF(){
		textoPregunta.setVisible(true);
		texto.setVisible(true);
	}
	
	public void visible() {
		tipoPregunta.setVisible(true);
		tipoPreguntas.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 if (e.getStateChange() == ItemEvent.SELECTED) {
             String item = (String) e.getItem();
             if(item.equals("Verdadero y Falso")) {
            	 preguntaVyF();
             }else {
            	 if(item.equals("Seleccion Multiple")) {
            		 
            	 }else {
            		 if(item.equals("Pregunta Corta")) {
            			 
            		 }
            	 }
             }
          }
		
	}
	
}
