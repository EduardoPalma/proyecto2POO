package interfaz;

import java.io.FileNotFoundException;

import javax.swing.*;

import controlador.HacerExamen;
import controlador.InicioSesion;
import controlador.RegistroUsuario;
import controlador.SeleccionAdmin;
import modelo.Exam;

public class InterfazProyecto extends JFrame {
	
	private PanelIntroduccion panelIntro;
	private PanelRegistro panelRegistro;
	private PanelExamen panelExamen;
	private PanelEstadisticas panelEsta;
	private PanelAdmin panelAdmin;
	private JTabbedPane pesta;
	private Exam datos;
	
	private static final long serialVersionUID = 1L;

	public InterfazProyecto(Exam datos) throws FileNotFoundException{
		this.datos = datos;
		setTitle("Proyecto 2");
		setSize(600,400);
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		datos.ingresoUsuariosAlSistema();
		iniciarPestañas();
		eventos();
		setVisible(true);
	}
	
	private void iniciarPestañas() {
		pesta = new JTabbedPane();
		panelIntro = new PanelIntroduccion();
		panelRegistro = new PanelRegistro();
		panelExamen = new PanelExamen(datos.getNamExam());
		panelEsta = new PanelEstadisticas();
		panelAdmin = new PanelAdmin(datos,panelExamen);
		
		pesta.add("Intrucciones",panelIntro);
		pesta.add("Registro Usuario",panelRegistro);
		pesta.add("Examenes",panelExamen);
		pesta.add("Estadisticas de Examenes",panelEsta);
		pesta.add("Admin",panelAdmin);
		add(pesta);
		
		pesta.setEnabledAt(2, false);
		pesta.setEnabledAt(3, false);
		pesta.setEnabledAt(4, false);
		
	}
	
	private void eventos() {
		RegistroUsuario registroUsuario = new RegistroUsuario(panelRegistro,datos);
		panelRegistro.getRegistro().addActionListener(registroUsuario);
		InicioSesion inicioSesion = new InicioSesion(panelIntro,datos,pesta);
		panelIntro.getBottonIniciarSesion().addActionListener(inicioSesion);
		panelIntro.getBottonCerrarSesion().addActionListener(inicioSesion);
		HacerExamen hacerExamen = new HacerExamen(panelExamen,datos);
		panelExamen.getHacerExamen().addActionListener(hacerExamen);
		panelExamen.getPanelExamen().getSiguiente().addActionListener(hacerExamen);
		panelExamen.getPanelExamen().getAnt().addActionListener(hacerExamen);
		panelExamen.getFinalizarExamen().addActionListener(hacerExamen);
		
		SeleccionAdmin seleccionAdmin = new SeleccionAdmin(panelAdmin);
		panelAdmin.getEliminarExamen().addActionListener(seleccionAdmin);
		panelAdmin.getCrearExamen().addActionListener(seleccionAdmin);
		panelAdmin.getGestionarUsuarios().addActionListener(seleccionAdmin);
		
	}
}
