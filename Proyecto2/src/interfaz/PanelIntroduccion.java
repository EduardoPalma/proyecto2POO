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
		instrucciones = new JTextArea("aqui va el texto...");
		instrucciones.setBounds(20, 20, 300, 300);
		instrucciones.setBackground(Color.black);
		instrucciones.setForeground(Color.WHITE);
		instrucciones.setEditable(false); 
		add(instrucciones);
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
