package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelCrearExamen extends JPanel implements ActionListener{
	private JComboBox<String> cantidadPreguntas;
	private JButton crearExamen;
	private PanelPreguntas panelPreguntas;
	private JTextField textoNombreExamen;
	private JLabel nombreExamen,numeroPreguntas;
	private int cantidadPregunta;
	
	
	public PanelCrearExamen() {
		this.cantidadPregunta = 0;
		setLayout(null);
		this.setBounds(200, 5 , 360, 325);
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(false);
		botones();
		textos();
		PanelPreguntas();
	}
	
	private void PanelPreguntas() {
		panelPreguntas = new PanelPreguntas(this);
		
	}
	
	private void textos() {
		nombreExamen = new JLabel("Nombre Examen");
		nombreExamen.setBackground(Color.black);
		nombreExamen.setForeground(Color.white);
		nombreExamen.setBounds(30, 20, 100, 25);
		add(nombreExamen);
		
		textoNombreExamen = new JTextField();
		textoNombreExamen.setBounds(150, 22, 200, 20);
		add(textoNombreExamen);
		
		numeroPreguntas = new JLabel("Cantidad Preguntas");
		numeroPreguntas.setBackground(Color.black);
		numeroPreguntas.setForeground(Color.white);
		numeroPreguntas.setBounds(30, 50, 120, 25);
		add(numeroPreguntas);
		
		cantPregun();
	}
	
	private void cantPregun() {
		cantidadPreguntas = new JComboBox<String>();
		for(int i=1;i<11;i++) {
			cantidadPreguntas.addItem(String.valueOf(i));
		}
		cantidadPreguntas.setBounds(150, 52, 100, 20);
		add(cantidadPreguntas);
		
	}
	
	
	private void botones() {
		crearExamen = new JButton("CREAR EXAMEN");
		crearExamen.setBounds(125, 275, 140, 25);
		crearExamen.addActionListener(this);
		add(crearExamen);
	}
	
	public void visible() {
		this.setVisible(true);
	}
	
	public void noVisible() {
		this.cantidadPreguntas.setVisible(false);
		this.crearExamen.setVisible(false);
		this.nombreExamen.setVisible(false);
		this.textoNombreExamen.setVisible(false);
		this.numeroPreguntas.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		noVisible();
		this.panelPreguntas.visible();
	}
	
	
	
}
