package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import interfaz.PanelGestionarUsuarios;
import modelo.Exam;
import modelo.Usuario;

public class OpcionesGestion implements ActionListener {
	private Exam datos;
	private PanelGestionarUsuarios panelGestion;
	
	public OpcionesGestion(Exam datos,PanelGestionarUsuarios panelGestion){
		this.datos = datos;
		this.panelGestion = panelGestion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(panelGestion.getHacerAdmin() == e.getSource()) {
			Usuario u = datos.buscar(panelGestion.getNombreUsuario().getText());
			if(u != null) {
				u.setAdmin(true);
				panelGestion.getTablaUsuarios().getModelo().setRowCount(0);
				panelGestion.getTablaUsuarios().ingresarUsuariosATabla(datos);
				try {
					datos.ingresarUsuario(null, 0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else {
			if(panelGestion.getHacerProfesor() == e.getSource()) {
				Usuario u = datos.buscar(panelGestion.getNombreUsuario().getText());
				if(u != null) {
					u.setProfesor(true);
					try {
						datos.ingresarUsuario(null, 0);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					panelGestion.getTablaUsuarios().getModelo().setRowCount(0);
					panelGestion.getTablaUsuarios().ingresarUsuariosATabla(datos);
				}
			}
		}
		
	}
}
