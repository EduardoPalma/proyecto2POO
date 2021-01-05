package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.UnsupportedLookAndFeelException;

import interfaz.InterfazProyecto;

public class App {

	public static void examenes(Exam examen) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("archivos/examenes.txt"));
		while(archivo.hasNextLine()) {
			String nombre = archivo.nextLine();
			examen.agregarNombrExamen(nombre);
		}
		archivo.close();
	}
	public static void main(String [] args) throws FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Exam datos = new Exam();
		examenes(datos);
		new InterfazProyecto(datos);
	}

}
