package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import interfaz.PanelRegistro;
import modelo.Exam;
import modelo.Usuario;

public class RegistroUsuario implements ActionListener {
	private PanelRegistro panel;
	private Exam datos;
	
	public RegistroUsuario(PanelRegistro panel,Exam datos) {
		this.panel = panel;
		this.datos = datos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(camposVacios()) {
			JOptionPane.showMessageDialog(panel,"    ¡¡ Error !! \n    campos vacios");
			vaciar();
		}else {
			if(!passwordVerificacion()) {
				JOptionPane.showMessageDialog(panel," ¡¡ contraseñas ingresadas no coinciden !!");
				vaciar();
			}else {
				Usuario u = new Usuario(panel.getRegistro1().getText(),panel.getRegistro2().getText(),panel.getRegistro4().getPassword(),panel.getRegistro3().getText(),panel.getRegistro6().getText());
				datos.agregarUsuario(u);
				try {
					datos.ingresarUsuario(u);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel," ¡¡ Usuario Registro con existo !!");
				vaciar();
			}
		}
		
	}
	
	private void vaciar() {
		panel.getRegistro1().setText(null);
		panel.getRegistro2().setText(null);
		panel.getRegistro3().setText(null);
		panel.getRegistro4().setText(null);
		panel.getRegistro5().setText(null);
		panel.getRegistro6().setText(null);
	}
	
	
	private boolean camposVacios() {
		if(panel.getRegistro1().getText().equals(null) ||
			panel.getRegistro2().getText().equals(null) ||
			panel.getRegistro3().getText().equals(null) ||
			panel.getRegistro4().getPassword().length == 0 ||
			panel.getRegistro5().getPassword().length == 0 ||
			panel.getRegistro6().getText().equals(null)) {
			
			return true;
		}
		return false;
	}
	
	private boolean passwordVerificacion() {
		if(panel.getRegistro4().getPassword().length != panel.getRegistro5().getPassword().length) {
			return false;
		}else {
			for(int i=0;i<panel.getRegistro4().getPassword().length;i++) {
				char passwordA = panel.getRegistro4().getPassword()[i];
				char passwordB = panel.getRegistro5().getPassword()[i];
				if(passwordA != passwordB) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
