package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.*;

import modelo.*;

public class PanelPreguntas extends JPanel implements ItemListener,ActionListener {
	private JComboBox<String> tipoPreguntas;
	private JComboBox<String> puntajes;
	private JTextArea texto;
	private JLabel tipoPregunta,textoPregunta,textoPuntaje;
	private PanelCrearExamen panel;
	private JButton ingresarPregunta;
	private DatosPreguntaVyF datosVerYFals;
	private DatosPreguntaCorta datosPregunCorta;
	private DatosPreguntaSelecMul datosPreguntSelecMul;
	private int preguntasIngresadas;
	
	public PanelPreguntas(PanelCrearExamen panel) {
		this.panel = panel;
		this.preguntasIngresadas = 0;
		this.datosVerYFals = new DatosPreguntaVyF(panel);
		this.datosPregunCorta = new DatosPreguntaCorta(panel);
		this.datosPreguntSelecMul = new DatosPreguntaSelecMul(panel);
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
		
		textoPuntaje = new JLabel("puntaje ");
		textoPuntaje.setBounds(30, 60, 140, 25);
		textoPuntaje.setBackground(Color.black);
		textoPuntaje.setForeground(Color.white);
		textoPuntaje.setVisible(false);
		this.panel.add(textoPuntaje);
		
		puntajes = new JComboBox<String>();
		puntajes.setVisible(false);
		puntajes.setBounds(150,60,140,25);
		for(int i=1;i<21;i++) {
			puntajes.addItem(String.valueOf(i));
		}
		this.panel.add(puntajes);
		
		
		textoPregunta = new JLabel("texto de pregunta");
		textoPregunta.setBounds(30, 100 , 140, 25);
		textoPregunta.setBackground(Color.black);
		textoPregunta.setForeground(Color.white);
		textoPregunta.setVisible(false);
		this.panel.add(textoPregunta);
		
		texto = new JTextArea();
		texto.setBounds(150, 100, 200, 75);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		texto.setVisible(false);
		this.panel.add(texto);
	}
	private void datosBasicos() {
		textoPregunta.setVisible(true);
		texto.setVisible(true);
		puntajes.setVisible(true);
		textoPuntaje.setVisible(true);
		ingresarPregunta.setVisible(true);
	}
	
	private void boton() {
		this.ingresarPregunta = new JButton("Ingresar Pregunta");
		this.ingresarPregunta.setBounds(125, 300, 140, 25);
		this.ingresarPregunta.setVisible(false);
		this.ingresarPregunta.addActionListener(this);
		this.panel.add(this.ingresarPregunta);
	}
	

	public void visible() {
		tipoPregunta.setVisible(true);
		tipoPreguntas.setVisible(true);
	}
	
	public void noVisible() {
		tipoPregunta.setVisible(false);
		tipoPreguntas.setVisible(false);
		textoPuntaje.setVisible(false);
		puntajes.setVisible(false);
		textoPregunta.setVisible(false);
		texto.setVisible(false);
		ingresarPregunta.setVisible(false);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 if (e.getStateChange() == ItemEvent.SELECTED) {
             String item = (String) e.getItem();
             if(item.equals("Verdadero y Falso")) {
            	 datosBasicos();
            	 this.texto.setText(null);
            	 this.datosVerYFals.mostrar();
            	 this.datosPregunCorta.noMostrar();
            	 this.datosPreguntSelecMul.noMostrar();
             }else {
            	 if(item.equals("Seleccion Multiple")) {
            		 datosBasicos();
            		 this.texto.setText(null);
            		 this.datosVerYFals.noMostrar();
            		 this.datosPregunCorta.noMostrar();
            		 this.datosPreguntSelecMul.mostrar();
            	 }else {
            		 if(item.equals("Pregunta Corta")) {
            			 datosBasicos();
            			 this.texto.setText(null);
            			 this.datosPregunCorta.getRespuestaCorta().setText(null);
            			 this.datosVerYFals.noMostrar();
            			 this.datosPregunCorta.mostrar();
            			 this.datosPreguntSelecMul.noMostrar();
            		 }
            	 }
             }
          }
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.texto.getText() == null || this.texto.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "¡¡¡ Campo Vacio !!!","CUIDADO!!",JOptionPane.WARNING_MESSAGE);
		}else {
			if(tipoPreguntas.getSelectedItem().equals("Verdadero y Falso")) {
				Pregunta p = this.datosVerYFals.pregunta();
				this.panel.getPanelAdmin().getDatos().agregarPregunta(p);
				this.preguntasIngresadas++;
				this.texto.setText(null);
				JOptionPane.showMessageDialog(this," ¡¡ Pregunta "+this.preguntasIngresadas+" a sido ingresada !!");
			}else {
				if(tipoPreguntas.getSelectedItem().equals("Seleccion Multiple")) {
					this.datosPreguntSelecMul.cantPreguntas();
					this.datosPreguntSelecMul.llenarOpciones();
					this.datosPreguntSelecMul.respuestaCorrecta();
					Pregunta p = this.datosPreguntSelecMul.pregunta();
					this.panel.getPanelAdmin().getDatos().agregarPregunta(p);
					this.texto.setText(null);
					this.preguntasIngresadas++;
					JOptionPane.showMessageDialog(this," ¡¡ Pregunta "+this.preguntasIngresadas+" a sido ingresada !!");
				}else {
					if(tipoPreguntas.getSelectedItem().equals("Pregunta Corta")) {
						Pregunta p = this.datosPregunCorta.pregunta();
						this.panel.getPanelAdmin().getDatos().agregarPregunta(p);
						this.preguntasIngresadas++;
						this.texto.setText(null);
						JOptionPane.showMessageDialog(this," ¡¡ Pregunta "+this.preguntasIngresadas+" a sido ingresada !!");
					}
				}
			}
			if(panel.getCantidadPregunta() == this.preguntasIngresadas) {
				JOptionPane.showMessageDialog(this.panel, "Examen Ingresado Correctamente");
				System.out.println(this.panel.getPanelAdmin().getDatos().getPreguntas().toString());
				try {
					vaciar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private void vaciar() throws IOException {
		panel.setVisible(false);
		panel.getPanelAdmin().noVisisble();
		this.panel.getPanelAdmin().getDatos().getNamExam().add(this.panel.getTextoNombreExamen().getText());
		panel.getPanelAdmin().getPanelEliminarExamen().actualizar();
		panel.getPanelAdmin().getPanelExamen().actualizar(this.panel.getPanelAdmin().getDatos());
		this.panel.getPanelAdmin().getDatos().archivoExamen(this.panel.getTextoNombreExamen().getText());
		this.panel.getPanelAdmin().getDatos().getPreguntas().clear();
		this.datosPregunCorta.noMostrar();
		this.datosPreguntSelecMul.noMostrar();
		this.datosVerYFals.noMostrar();
		this.preguntasIngresadas = 0;
		noVisible();
	}

	public JComboBox<String> getTipoPreguntas() {
		return tipoPreguntas;
	}

	public void setTipoPreguntas(JComboBox<String> tipoPreguntas) {
		this.tipoPreguntas = tipoPreguntas;
	}

	public JComboBox<String> getPuntajes() {
		return puntajes;
	}

	public void setPuntajes(JComboBox<String> puntajes) {
		this.puntajes = puntajes;
	}

	public JTextArea getTexto() {
		return texto;
	}

	public void setTexto(JTextArea texto) {
		this.texto = texto;
	}

	public JLabel getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(JLabel tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public JLabel getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(JLabel textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public JLabel getTextoPuntaje() {
		return textoPuntaje;
	}

	public void setTextoPuntaje(JLabel textoPuntaje) {
		this.textoPuntaje = textoPuntaje;
	}

	public PanelCrearExamen getPanel() {
		return panel;
	}

	public void setPanel(PanelCrearExamen panel) {
		this.panel = panel;
	}

	public JButton getIngresarPregunta() {
		return ingresarPregunta;
	}

	public void setIngresarPregunta(JButton ingresarPregunta) {
		this.ingresarPregunta = ingresarPregunta;
	}

	public DatosPreguntaVyF getDatosVerYFals() {
		return datosVerYFals;
	}

	public void setDatosVerYFals(DatosPreguntaVyF datosVerYFals) {
		this.datosVerYFals = datosVerYFals;
	}

	public DatosPreguntaCorta getDatosPregunCorta() {
		return datosPregunCorta;
	}

	public void setDatosPregunCorta(DatosPreguntaCorta datosPregunCorta) {
		this.datosPregunCorta = datosPregunCorta;
	}

	public DatosPreguntaSelecMul getDatosPreguntSelecMul() {
		return datosPreguntSelecMul;
	}

	public void setDatosPreguntSelecMul(DatosPreguntaSelecMul datosPreguntSelecMul) {
		this.datosPreguntSelecMul = datosPreguntSelecMul;
	}

	public int getPreguntasIngresadas() {
		return preguntasIngresadas;
	}

	public void setPreguntasIngresadas(int preguntasIngresadas) {
		this.preguntasIngresadas = preguntasIngresadas;
	}
	
}
