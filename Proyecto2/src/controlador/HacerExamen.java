package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import interfaz.PanelExamen;
import modelo.Exam;
import modelo.PregunCortas;
import modelo.PreguntSelecMul;
import modelo.Pregunta;
import modelo.TFpregunta;

public class HacerExamen implements ActionListener {
	private PanelExamen panel;
	private Exam datos;
	private ArrayList<String> respuestas;
	
	public HacerExamen(PanelExamen panel,Exam datos) {
		this.panel = panel;
		this.datos = datos;
		this.respuestas = new ArrayList<String>(10);
		rellenar();
	}
	
	private void rellenar() {
		for(int i=0;i<10;i++) {
			this.respuestas.add(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.getHacerExamen()) {
			int resp = JOptionPane.showConfirmDialog(panel, "¿Estas Seguro de la Seleccion ?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(resp == 0) {
				String nombreExamen = (String) panel.getPruebas().getSelectedItem();
				try {
					datos.lecturaExamen(nombreExamen);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				panel.getFinalizarExamen().setEnabled(true);
				panel.getPruebas().setEnabled(false);
				panel.getHacerExamen().setEnabled(false);
				panel.getPanelExamen().getSiguiente().setVisible(true);
				panel.getPanelExamen().getAnt().setVisible(true);
				panel.getPanelExamen().getSiguiente().setEnabled(true);
				panel.getPanelExamen().getAnt().setEnabled(true);
				panel.getPanelExamen().getTipoPregunta().setVisible(true);
				int indice = panel.getPanelExamen().getIndicePregunta();
				panel.getPanelExamen().getTextoPregunta().setText((indice+1) +".  "+datos.getPreguntas().get(indice).getText());
				Preguntas(datos.getPreguntas().get(indice));
				panel.getPanelExamen().getAnt().setEnabled(false);
			}
		}else {
			if(e.getSource() == panel.getPanelExamen().getSiguiente()) {
				botonSig();
			}else {
				if(e.getSource() == panel.getPanelExamen().getAnt()) {
					botonAnt();
				}else {
					if(e.getSource() == panel.getFinalizarExamen()) {
						String nombreExamen = (String) panel.getPruebas().getSelectedItem();
						terminarExamen(nombreExamen);
					}
				}
			}
				
				
		}
		
	}
	
	
	private void botonAnt() {
		int indice = panel.getPanelExamen().getIndicePregunta();
		if(panel.getPanelExamen().getIndicePregunta() >= 0) {
			respuestaPreguntas(datos.getPreguntas().get(indice),indice);
			panel.getPanelExamen().getTextoPregunta().setText((indice)+".  "+datos.getPreguntas().get(indice-1).getText());
			Preguntas(datos.getPreguntas().get(indice-1));
			panel.getPanelExamen().setIndicePregunta(indice-1);
			panel.getPanelExamen().limpiarRespuesta();
			panel.getPanelExamen().getAnt().setEnabled(true);
			panel.getPanelExamen().getSiguiente().setEnabled(true);
			panel.getPanelExamen().getGrupoSeleccionMultiple().clearSelection();
			panel.getPanelExamen().getGrupoVerFalso().clearSelection();
			if(panel.getPanelExamen().getIndicePregunta() == 0) {
				panel.getPanelExamen().getAnt().setEnabled(false);
			}
		}
	}
	
	private void botonSig() {
		int indice = panel.getPanelExamen().getIndicePregunta();
		if(datos.getPreguntas().size() > panel.getPanelExamen().getIndicePregunta()) {
			respuestaPreguntas(datos.getPreguntas().get(indice),indice);
			panel.getPanelExamen().getTextoPregunta().setText((indice+2)+".  "+datos.getPreguntas().get(indice+1).getText());
			Preguntas(datos.getPreguntas().get(indice+1));
			panel.getPanelExamen().setIndicePregunta(indice+1);
			panel.getPanelExamen().getSiguiente().setEnabled(true);
			panel.getPanelExamen().getAnt().setEnabled(true);
			panel.getPanelExamen().limpiarRespuesta();
			panel.getPanelExamen().getGrupoSeleccionMultiple().clearSelection();
			panel.getPanelExamen().getGrupoVerFalso().clearSelection();
			if(panel.getPanelExamen().getIndicePregunta() == datos.getPreguntas().size()-1) {
				panel.getPanelExamen().getSiguiente().setEnabled(false);
				panel.getPanelExamen().setIndicePregunta(datos.getPreguntas().size()-1);
			}
		}
	}
	
	
	private void terminarExamen(String nombreExamen) {
		JOptionPane.showMessageDialog(panel, "Examen finalizado Correctamente \n Porcentaje Obtenido Correcto "+datos.darExam(respuestas)+"%");
		datos.ingresarDatos(datos.getU().getNombreUsuario(), datos.getU().getNombre(), nombreExamen,datos.darExam(respuestas));
		panel.getFinalizarExamen().setEnabled(false);
		panel.getPruebas().setEnabled(true);
		panel.getHacerExamen().setEnabled(true);
		panel.getPanelExamen().getSiguiente().setVisible(false);
		panel.getPanelExamen().getAnt().setVisible(false);
		datos.getPreguntas().clear();
		panel.getPanelExamen().setIndicePregunta(0);
		panel.getPanelExamen().getTextoPregunta().setText(null);
		panel.getPanelExamen().getRespuesta().setText(null);
		panel.getPanelExamen().getRespuesta().setVisible(false);
		panel.getPanelExamen().getRespuestaCorta().setVisible(false);
		panel.getPanelExamen().noVisibleVF();
		panel.getPanelExamen().limpiarGrupoBotones();
		panel.getPanelExamen().getTipoPregunta().setVisible(false);
		for(int i=0;i<10;i++) {
			this.respuestas.set(i, null);
		}
	}
	
	private void Preguntas(Pregunta p) {
		if(p instanceof TFpregunta) {
			panel.getPanelExamen().limpiarGrupoBotones();
			panel.getPanelExamen().visibleVF();
			panel.getPanelExamen().getRespuesta().setVisible(false);
			panel.getPanelExamen().getRespuestaCorta().setVisible(false);
			panel.getPanelExamen().getTipoPregunta().setText("Pregunta Verdadero y falso");
		}else {
			if(p instanceof PreguntSelecMul ) {
				panel.getPanelExamen().cargarSelecciones(((PreguntSelecMul) p).getRespuestas());
				panel.getPanelExamen().noVisibleVF();
				panel.getPanelExamen().getRespuesta().setVisible(false);
				panel.getPanelExamen().getRespuestaCorta().setVisible(false);
				panel.getPanelExamen().getTipoPregunta().setText("Pregunta Seleccion Multiple");
			}else {
				if(p instanceof PregunCortas) {
					panel.getPanelExamen().limpiarGrupoBotones();
					panel.getPanelExamen().noVisibleVF();
					panel.getPanelExamen().getRespuesta().setVisible(true);
					panel.getPanelExamen().getRespuestaCorta().setVisible(true);
					panel.getPanelExamen().getTipoPregunta().setText("Pregunta Corta");
				}
			}
		}
	}
	
	
	private void respuestaPreguntas(Pregunta p,int indice) {
		if(p instanceof TFpregunta) {
			guardarRespuestaVerdaderoFalso(indice);
		}else {
			if(p instanceof PreguntSelecMul ) {
				guardarRespuestasPregunSelecMul(indice);
			}else {
				if(p instanceof PregunCortas) {
					guardarRespuestaPregunCorta(indice);
				}
			}
		}
	}
	
	
	private void guardarRespuestaVerdaderoFalso(int indice) {
		if(panel.getPanelExamen().getVerdadero().isSelected() == true) {
			this.respuestas.set(indice, "true");
			System.out.println("selecciono verdadero");
		}else {
			if(panel.getPanelExamen().getFalso().isSelected() == true) {
				this.respuestas.set(indice, "false");
			}
		}
		
		System.out.println(this.respuestas.toString());
		
	}
	
	private void guardarRespuestaPregunCorta(int indice) {
		if(panel.getPanelExamen().getRespuesta().getText() != null && !panel.getPanelExamen().getRespuesta().getText().equals("")) {
			this.respuestas.set(indice, panel.getPanelExamen().getRespuesta().getText());
		}
	}
	
	private void guardarRespuestasPregunSelecMul(int indice) {
		for(int i=0;i<panel.getPanelExamen().getOpciones().size();i++) {
			JRadioButton btn = panel.getPanelExamen().getOpciones().get(i);
			if(btn.isSelected() == true) {
				this.respuestas.set(indice, String.valueOf(i));
				break;
			}
		}
	}
}
