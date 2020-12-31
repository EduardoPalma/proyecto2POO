package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import interfaz.InterfazProyecto;

public class App {
	
	public static void lecturaExamen(String nombreExamen,Exam e) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("archivos/examen_"+nombreExamen+".txt"));
		while(archivo.hasNextLine()) {
			String linea = archivo.nextLine();
			String [] parte = linea.split(",");
			if(parte[0].equals("PTF")) {
				Pregunta p = new TFpregunta(parte[1],Integer.parseInt(parte[2]),Boolean.parseBoolean(parte[3]));
				e.getPreguntas().add(p);
			}
			if(parte[0].equals("PC")) {
				Pregunta p = new PregunCortas(parte[1],Integer.parseInt(parte[2]),parte[3]);
				e.getPreguntas().add(p);
			}
			if(parte[0].equals("PSM")) {
				int i = Integer.parseInt(parte[4]);
				String [] alternativas = new String[6];
				for(int j=0;j<i;j++) {
					alternativas[j] = parte[4+j+1];
				}
				Pregunta p = new PreguntSelecMul(parte[1],Integer.parseInt(parte[2]),alternativas,Integer.parseInt(parte[3]));
				e.getPreguntas().add(p);
			}
		}
		archivo.close();
	}
	
	public static void examenes(Exam examen) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("archivos/examenes.txt"));
		while(archivo.hasNextLine()) {
			String nombre = archivo.nextLine();
			examen.agregarNombrExamen(nombre);
		}
		archivo.close();
	}
	public static void main(String [] args) throws FileNotFoundException {
		Exam datos = new Exam();
		char [] pass = {'9','a','a','d','9','6','6','3'};
		Usuario admin = new Usuario("Eduardo Armando","Palma Pizarro",pass,"hellopalma","hellopalma1@gmail.com");
		datos.getUsuarios().add(admin);
		examenes(datos);
		new InterfazProyecto(datos);
	}

}
