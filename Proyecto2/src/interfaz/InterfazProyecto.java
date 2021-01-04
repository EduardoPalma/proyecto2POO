package interfaz;

import java.io.FileNotFoundException;
import java.sql.SQLException;

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

	public InterfazProyecto(Exam datos) throws FileNotFoundException, ClassNotFoundException, SQLException{
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
	
	public void iniciarPestañas() throws ClassNotFoundException, SQLException {
		pesta = new JTabbedPane();
		panelIntro = new PanelIntroduccion();
		panelRegistro = new PanelRegistro();
		panelExamen = new PanelExamen(datos.getNamExam());
		panelEsta = new PanelEstadisticas(datos);
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
	
	public void eventos() {
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

	public PanelIntroduccion getPanelIntro() {
		return panelIntro;
	}

	public void setPanelIntro(PanelIntroduccion panelIntro) {
		this.panelIntro = panelIntro;
	}

	public PanelRegistro getPanelRegistro() {
		return panelRegistro;
	}

	public void setPanelRegistro(PanelRegistro panelRegistro) {
		this.panelRegistro = panelRegistro;
	}

	public PanelExamen getPanelExamen() {
		return panelExamen;
	}

	public void setPanelExamen(PanelExamen panelExamen) {
		this.panelExamen = panelExamen;
	}

	public PanelEstadisticas getPanelEsta() {
		return panelEsta;
	}

	public void setPanelEsta(PanelEstadisticas panelEsta) {
		this.panelEsta = panelEsta;
	}

	public PanelAdmin getPanelAdmin() {
		return panelAdmin;
	}

	public void setPanelAdmin(PanelAdmin panelAdmin) {
		this.panelAdmin = panelAdmin;
	}

	public JTabbedPane getPesta() {
		return pesta;
	}

	public void setPesta(JTabbedPane pesta) {
		this.pesta = pesta;
	}

	public Exam getDatos() {
		return datos;
	}

	public void setDatos(Exam datos) {
		this.datos = datos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
