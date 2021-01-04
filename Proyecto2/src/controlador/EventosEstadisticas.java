package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import interfaz.PanelEstadisticas;

public class EventosEstadisticas implements ActionListener {
	private PanelEstadisticas panelEsta;
	
	public EventosEstadisticas(PanelEstadisticas panelEsta) {
		this.panelEsta = panelEsta;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(panelEsta.getBotton1() == e.getSource()) {
			panelEsta.getModelo().setRowCount(0);
			try {
				panelEsta.getDatos().ordenarDatos(panelEsta, 0);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			if(panelEsta.getBotton3() == e.getSource()) {
				panelEsta.getModelo().setRowCount(0);
				try {
					panelEsta.getDatos().ordenarDatos(panelEsta, 1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				if(panelEsta.getBotton2() == e.getSource()){
					try {
						panelEsta.getDatos().obtenerPuntajeMasAlto();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	
}
