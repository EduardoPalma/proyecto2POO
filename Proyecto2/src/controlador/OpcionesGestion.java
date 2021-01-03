package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		System.out.println(datos.getUsuarios().toString());
		if(panelGestion.getHacerAdmin() == e.getSource()) {
			Usuario u = datos.buscar(panelGestion.getNombreUsuario().getText());
			if(u != null) {
				u.setAdmin(true);
				panelGestion.getTablaUsuarios().getModelo().setRowCount(0);
				panelGestion.getTablaUsuarios().ingresarUsuariosATabla(datos);
				System.out.println("lo hize admin");
			}else {
				System.out.println("no lo encontro");
			}
		}else {
			if(panelGestion.getHacerProfesor() == e.getSource()) {
				Usuario u = datos.buscar(panelGestion.getNombreUsuario().getText());
				if(u != null) {
					u.setProfesor(true);
					panelGestion.getTablaUsuarios().getModelo().setRowCount(0);
					panelGestion.getTablaUsuarios().ingresarUsuariosATabla(datos);
					System.out.println("lo hize profesor");
				}else {
					System.out.println("no lo encontro");
				}
			}
		}
		
	}
}
