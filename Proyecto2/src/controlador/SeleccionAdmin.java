package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import interfaz.PanelAdmin;

public class SeleccionAdmin implements ActionListener {
	private PanelAdmin panel;
	
	public SeleccionAdmin(PanelAdmin panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.getCrearExamen()) {
			int resp = JOptionPane.showConfirmDialog(panel, "¿ Desea Crear Un Examen ?");
			if(resp == 0) {
				panel.getPanelCrearExamen().setVisible(true);
				panel.getPanelEliminarExamen().noVisible();
				panel.getPanelCrearExamen().visible();
				panel.getPanelGestionarUsuarios().getTablaUsuarios().getModelo().setRowCount(0);
				panel.visible();
				panel.getPanelGestionarUsuarios().getTablaUsuarios().noVisisble();
			}
		}else {
			if(e.getSource() == panel.getEliminarExamen()) {
				panel.getPanelEliminarExamen().setVisible(true);
				panel.getPanelEliminarExamen().visible();
				panel.getPanelCrearExamen().setVisible(false);
				panel.getPanelGestionarUsuarios().setVisible(false);
				panel.getGestionarUsuarios().setEnabled(true);
				panel.getPanelGestionarUsuarios().getTablaUsuarios().getModelo().setRowCount(0);
				panel.getPanelGestionarUsuarios().getTablaUsuarios().noVisisble();
			}else {
				if(e.getSource() == panel.getGestionarUsuarios()) {
					panel.getPanelEliminarExamen().setVisible(false);
					panel.getPanelCrearExamen().setVisible(false);
					panel.getPanelGestionarUsuarios().setVisible(true);
					panel.getPanelGestionarUsuarios().getTablaUsuarios().ingresarUsuariosATabla(panel.getDatos());
					panel.getGestionarUsuarios().setEnabled(false);
					panel.getPanelGestionarUsuarios().getTablaUsuarios().visible();;
				}
			}
		}
		
	}

}
