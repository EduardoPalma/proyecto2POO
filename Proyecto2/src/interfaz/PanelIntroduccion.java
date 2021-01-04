package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Usuario;

public class PanelIntroduccion extends JPanel {
	private JLabel usuario,password;
	private JTextField registroU;
	private JPasswordField registroPW;
	private JTextArea instrucciones;
	private JButton bottonIniciarSesion,bottonCerrarSesion;
	
	public PanelIntroduccion() {
		setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		areaTexto();
		datos();
		inicioSesion();
	}
	
	private void datos() {
		usuario = new JLabel("Usuario");
		usuario.setForeground(Color.WHITE);
		usuario.setBounds(425, 50, 100, 50);
		add(usuario);
		
		registroU = new JTextField();
		registroU.setBounds(395, 90, 120, 25);
		add(registroU);
		
		
		password = new JLabel("Contraseña");
		password.setForeground(Color.WHITE);
		password.setBounds(415, 100, 100, 50);
		add(password);
		
		registroPW = new JPasswordField();
		registroPW.setBounds(395, 140, 120, 25);
		add(registroPW);
	}
	
	private void areaTexto() {
		instrucciones = new JTextArea("INTRUCCIONES\r\n"
				+ "• Para ingresar al sistema debe estar registrado(a) para lo anterior diríjase a la pestaña “Registro”.\r\n"
				+ "       1. En caso de ser Usuario nuevo Solo podrá Realizar los exámenes que se encuentran en el sistema.\r\n"
				+ "       2. En caso de ser nuevo Usuario y quiere ser profesor Contactarse con un Administrador.\r\n"
				+ "       3. Para el cerrado de sesion porfavor aprete El botton “Cerrar Sesion”\r\n"
				+ "\n• Para la realización de un examen ya ingresado al sistema diríjase a la pestaña “Exámenes”, tendrá la opción de elegir el examen que se encuentra en el sistema al seleccionar y apretar el botón Realizar Examen se procede a ingresar las respuestas de la preguntas en cuestión.\r\n"
				+ "       1. Las preguntas son de tipo cuestionario ya sea.\r\n"
				+ "             Preguntas de verdadero y falso.\r\n"
				+ "             Preguntas de Selección Múltiple.\r\n"
				+ "             Preguntas Cortas.\r\n"
				+ "\n• Para ver estadísticas del usuario de los exámenes hechos por el diríjase la pestaña Estadísticas, tendrá opciones de ordenar de menor a mayor puntaje y viceversa, en el caso de no realizar estas opciones y quiere obtener el examen con mayor puntaje que ha realizado seleccione el botón “obtener”. \r\n"
				+ "\n• Para el ingreso a la pestaña “Admin” si es profesor tendrá las siguiente opciones.\r\n"
				+ "       1. Crear un Examen. Donde se le pedirán los distintos datos para el ingreso y la cantidad de preguntas del examen con un máximo de 10 preguntas.\r\n"
				+ "\nANTE CUALQUIER PROBLEMA PORFAVOR CONTACTE CON SU ADMINISTRADOR\r\n"
				+ "");
		instrucciones.setBounds(20, 20, 300, 300);
		instrucciones.setBackground(Color.black);
		instrucciones.setForeground(Color.WHITE);
		instrucciones.setLineWrap(true);
		instrucciones.setWrapStyleWord(true);
		instrucciones.setEditable(false);
		JScrollPane scroll = new JScrollPane(instrucciones);
		scroll.setBounds(20, 20, 300, 300);
		add(scroll);
	}
	
	private void inicioSesion() {
		bottonIniciarSesion = new JButton("iniciar Sesion");
		bottonIniciarSesion.setBounds(395, 200, 120, 25);
		add(bottonIniciarSesion);
		
		this.bottonCerrarSesion = new JButton("Cerrar Sesion");
		this.bottonCerrarSesion.setBounds(395, 240, 120, 25);
		this.bottonCerrarSesion.setEnabled(false);
		add(this.bottonCerrarSesion);
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JTextField getRegistroU() {
		return registroU;
	}

	public void setRegistroU(JTextField registroU) {
		this.registroU = registroU;
	}

	public JPasswordField getRegistroPW() {
		return registroPW;
	}

	public void setRegistroPW(JPasswordField registroPW) {
		this.registroPW = registroPW;
	}

	public JTextArea getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(JTextArea instrucciones) {
		this.instrucciones = instrucciones;
	}

	public JButton getBottonIniciarSesion() {
		return bottonIniciarSesion;
	}

	public void setBottonIniciarSesion(JButton bottonIniciarSesion) {
		this.bottonIniciarSesion = bottonIniciarSesion;
	}

	public JButton getBottonCerrarSesion() {
		return bottonCerrarSesion;
	}

	public void setBottonCerrarSesion(JButton bottonCerrarSesion) {
		this.bottonCerrarSesion = bottonCerrarSesion;
	}
	
}
