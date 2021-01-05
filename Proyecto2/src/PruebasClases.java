import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.UnsupportedLookAndFeelException;

import org.junit.Test;

import interfaz.InterfazProyecto;
import modelo.Exam;
import modelo.Pregunta;
import modelo.TFpregunta;
import modelo.Usuario;

public class PruebasClases {
	private Exam e;
	private InterfazProyecto ip;

	
	public PruebasClases() throws FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		e = new Exam();
		ip = new InterfazProyecto(e);
		
	}
	
	@Test
	public void test() {
		char [] pas = {'a','b','c'};
		Usuario u = new Usuario("Eduardo","Palma",pas,"Edu","correo") ;
		assertTrue(e.agregarUsuario(u));
	}
	
	@Test
	public void testPuntaje() {
		ArrayList<String> respuestas = new ArrayList<String>();
		respuestas.add("0");
		respuestas.add("0");
		assertEquals(0,e.darExam(respuestas));
	}
	
	@Test
	public void testAgregarPregunta() {
		Pregunta p = new TFpregunta("velocidad",1,false);
		assertTrue(e.agregarPregunta(p));
	}
	
	@Test
	public void testPanel() throws ClassNotFoundException, SQLException {
		ip.iniciarPestañas();
		assertEquals(null,ip.getPanelAdmin());
		
	}
	
	@Test
	public void testRegistroUsuario() throws ClassNotFoundException, SQLException {
		ip.iniciarPestañas();
		assertEquals(null,ip.getPanelRegistro());
		
	}

}
