package interfaz;

import javax.swing.*;

public class InterfazProyecto extends JFrame {
	
	private PanelIntroduccion panelIntro;
	private PanelRegistro panelRegistro;
	private PanelExamen panelExamen;
	private PanelEstadisticas panelEsta;
	private PanelAdmin panelAdmin;
	private JTabbedPane pesta;
	
	private static final long serialVersionUID = 1L;

	public InterfazProyecto(){
		setTitle("Proyecto 2");
		setSize(800,600);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarPestañas();
		setVisible(true);
	}
	
	private void iniciarPestañas() {
		pesta = new JTabbedPane();
		panelIntro = new PanelIntroduccion();
		panelRegistro = new PanelRegistro();
		panelExamen = new PanelExamen();
		panelEsta = new PanelEstadisticas();
		panelAdmin = new PanelAdmin();
		
		pesta.add("Intrucciones",panelIntro);
		pesta.add("Registro Usuario",panelRegistro);
		pesta.add("Examenes",panelExamen);
		pesta.add("Estadisticas de Examenes",panelEsta);
		pesta.add("Admin",panelAdmin);
		
		add(pesta);
		
	}
}
