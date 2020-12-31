package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import interfaz.PanelIntroduccion;
import modelo.Exam;
import modelo.Usuario;

public class InicioSesion implements ActionListener {
	private PanelIntroduccion panel;
	private Exam datos;
	private JTabbedPane pesta;
	
	public InicioSesion(PanelIntroduccion panel,Exam datos,JTabbedPane pesta) {
		this.panel = panel;
		this.datos = datos;
		this.pesta = pesta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Usuario u = datos.buscar(panel.getRegistroU().getText(), panel.getRegistroPW().getPassword());
		if(u == null) {
			JOptionPane.showMessageDialog(panel,"Nombre de Usuario o Contraseña Incorrectos");
			vaciar();
		}else {
			datos.setU(u);
			pesta.setEnabledAt(1, false);
			pesta.setEnabledAt(2, true);
			pesta.setEnabledAt(3, true);
			JOptionPane.showMessageDialog(panel,"Inicio de Sesion Exitoso");
			panel.getBottonIniciarSesion().setEnabled(false);
			vaciar();
		}
	}
	
	private void vaciar() {
		panel.getRegistroU().setText(null);
		panel.getRegistroPW().setText(null);
	}
	
}
