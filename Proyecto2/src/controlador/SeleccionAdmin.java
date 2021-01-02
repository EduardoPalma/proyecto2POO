package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.PanelAdmin;

public class SeleccionAdmin implements ActionListener {
	private PanelAdmin panel;
	
	public SeleccionAdmin(PanelAdmin panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.getCrearExamen()) {
			panel.getPanelCrearExamen().setVisible(true);
			panel.getPanelEliminarExamen().noVisible();
			panel.getPanelCrearExamen().visible();
			panel.visible();
		}else {
			if(e.getSource() == panel.getEliminarExamen()) {
				panel.getPanelEliminarExamen().setVisible(true);
				panel.getPanelEliminarExamen().visible();
				panel.getPanelCrearExamen().setVisible(false);
				panel.getPanelGestionarUsuarios().setVisible(false);
			}else {
				if(e.getSource() == panel.getGestionarUsuarios()) {
					panel.getPanelEliminarExamen().setVisible(false);
					panel.getPanelCrearExamen().setVisible(false);
					panel.getPanelGestionarUsuarios().setVisible(true);
				}
			}
		}
		
	}

}
