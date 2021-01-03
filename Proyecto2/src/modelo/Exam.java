package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import interfaz.PanelEstadisticas;



/**
 * clase examen que hace los requerimientos esenciales y las inicializacion de las variables
 * a guardar 
 * @author hello
 *
 */
public class Exam {
	private ArrayList<String> namExam;
	private ArrayList<Pregunta> preguntas; 
	private ArrayList<Usuario> usuarios;
	private Usuario u;
	private int contador;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("error");
			e.printStackTrace();
		}
	}
	
	/**
	 * constructor de la clase Exam
	 * inicializa las variables
	 */
	public Exam() {
		this.namExam = new ArrayList<String>();
		this.preguntas = new ArrayList<Pregunta>();
		this.usuarios = new ArrayList<Usuario>();
		this.u = null;
		this.contador = 0;
	}
	
	/**
	 * metodo que retorna el contador de preguntas del examen
	 * @return
	 */
	public int getContador() {
		return contador;
	}
	
	/**
	 * metodo que ingresa el nombre de un examen al sistema
	 * @param nombreExamen
	 */
	public void agregarNombrExamen(String nombreExamen) {
		this.namExam.add(nombreExamen);
	}

	public boolean agregarUsuario(Usuario u) {
		this.usuarios.add(u);
		return true;
	}
	

	public boolean agregarPregunta(Pregunta p) {
		if(this.contador < 10 ) {
			preguntas.add(p);
			this.contador++;
			return true;
		}else return false;
	}

	public Usuario buscar(String nombreUsuario,char [] password) {
		for(int i=0;i<this.usuarios.size();i++) {
			Usuario u = usuarios.get(i);
			if(u.getNombreUsuario().equals(nombreUsuario)) {
				if(password.length != u.getPassword().length) return null;
				else {
					for(int j=0;j<password.length;j++) {
						if(password[j] != u.getPassword()[j]) return null;
					}
					return u;
				}
			}
		}
		return null;
	}
	
	public int darExam(ArrayList<String> respuestas) {
		double puntos = 0;
		double puntosTotales = 0;
		for(int i=0;i<preguntas.size();i++) {
			if(preguntas.get(i) instanceof TFpregunta) {
				TFpregunta aux = (TFpregunta) preguntas.get(i);
				if(respuestas.get(i) != null) {
					if(aux.getRespuestaCorrecta() == true) {
						if(respuestas.get(i).equals("true")) {
							puntos = puntos + aux.peso;
							puntosTotales = puntosTotales + aux.peso;
						}else{
							puntosTotales = puntosTotales + aux.peso;
						}
					}else {
						if(respuestas.get(i).equals("false")) {
							puntos = puntos + aux.peso;
							puntosTotales = puntosTotales + aux.peso;
						}else {
							puntosTotales = puntosTotales + aux.peso;
						}
					}
				}else puntosTotales = puntosTotales + aux.peso;
			}else {
				if(preguntas.get(i) instanceof PreguntSelecMul) {
					PreguntSelecMul aux = (PreguntSelecMul) preguntas.get(i);
					if(respuestas.get(i) != null) {
						if(aux.getRespuesta() == Integer.parseInt(respuestas.get(i))) {
							puntos = puntos + aux.peso;
							puntosTotales = puntosTotales + aux.peso;
						}else {
							puntosTotales = puntosTotales + aux.peso;
						}
					}else puntosTotales = puntosTotales + aux.peso;
				}else {
					if(preguntas.get(i) instanceof PregunCortas) {
						PregunCortas aux = (PregunCortas) preguntas.get(i);
						if(respuestas.get(i) != null) {
							if(aux.getRespuesta().equalsIgnoreCase(respuestas.get(i))) {
								puntos = puntos + aux.peso;
								puntosTotales = puntosTotales + aux.peso;
							}else {
								puntosTotales = puntosTotales + aux.peso;
							}
						}else puntosTotales = puntosTotales + aux.peso;
					}
				}
			}
		}
		double resultado = Math.round((puntos/puntosTotales)*100); 
		return (int) resultado;
	}

	
	public void lecturaExamen(String nombreExamen) throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("archivos/examen_"+nombreExamen+".txt"));
		while(archivo.hasNextLine()) {
			String linea = archivo.nextLine();
			String [] parte = linea.split(",");
			if(parte[0].equals("PTF")) {
				Pregunta p = new TFpregunta(parte[1],Integer.parseInt(parte[2]),Boolean.parseBoolean(parte[3]));
				this.preguntas.add(p);
			}
			if(parte[0].equals("PC")) {
				Pregunta p = new PregunCortas(parte[1],Integer.parseInt(parte[2]),parte[3]);
				this.preguntas.add(p);
			}
			if(parte[0].equals("PSM")) {
				int i = Integer.parseInt(parte[4]);
				String [] alternativas = new String[6];
				for(int j=0;j<i;j++) {
					alternativas[j] = parte[4+j+1];
				}
				Pregunta p = new PreguntSelecMul(parte[1],Integer.parseInt(parte[2]),alternativas,Integer.parseInt(parte[3]));
				this.preguntas.add(p);
			}
		}
		archivo.close();
	}
	
	
	public void archivoExamen(String nombreExamen) throws IOException {
		FileWriter ficheroExamen = new FileWriter("archivos/examenes.txt",true);
		PrintWriter archivoExamen = new PrintWriter(ficheroExamen);
		archivoExamen.println(nombreExamen);
		FileWriter ficheroNuevo = new FileWriter("archivos/examen_"+nombreExamen+".txt");
		PrintWriter archivo = new PrintWriter(ficheroNuevo);
		for(int i=0;i<this.getPreguntas().size();i++) {
			if(this.getPreguntas().get(i) instanceof TFpregunta) {
				TFpregunta aux = (TFpregunta) this.getPreguntas().get(i);
				archivo.println("PTF,"+aux.getText()+","+aux.getPeso()+","+aux.getRespuestaCorrecta());
			}else {
				if(this.getPreguntas().get(i) instanceof PregunCortas) {
					PregunCortas aux = (PregunCortas) this.getPreguntas().get(i);
					archivo.println("PC,"+aux.getText()+","+aux.getPeso()+","+aux.getRespuesta());
				}else {
					if(this.getPreguntas().get(i) instanceof PreguntSelecMul) {
						PreguntSelecMul aux = (PreguntSelecMul) this.getPreguntas().get(i);
						int z;
						for(z=0;z<aux.getRespuestas().length;z++) {
							if(aux.getRespuestas()[z] == null) break;
						} 
						archivo.print("PSM,"+aux.getText()+","+aux.getPeso()+","+aux.getRespuesta()+","+z);
						for(int j=0;j<z;j++) {
							archivo.print(","+aux.getRespuestas()[j]);
						}
						archivo.println();
					}
				}
			}
		}
		ficheroExamen.close();
		archivoExamen.close();
		ficheroNuevo.close();
		archivo.close();
	}
	
	public void eliminarExamen(int indice) throws IOException {
		File archivo = new File("archivos/examen_"+this.getNamExam().get(indice)+".txt");
		FileWriter ficheroExamen = new FileWriter("archivos/examenes.txt");
		PrintWriter archivoExamen = new PrintWriter(ficheroExamen);
		this.getNamExam().remove(indice);
		for(int j=0;j<this.getNamExam().size();j++) {
			archivoExamen.println(this.getNamExam().get(j));
		}
		archivoExamen.close();
		ficheroExamen.close();
		if(archivo.delete());
	}
	
	public void ingresarUsuario(Usuario u) throws IOException {
		FileWriter ficheroExamen = new FileWriter("archivos/usuarios.txt",true);
		PrintWriter archivoExamen = new PrintWriter(ficheroExamen);
		archivoExamen.println(u.getNombre()+","+u.getApellido()+","+String.valueOf(u.getPassword())+","+u.getNombreUsuario()+","+u.getCorreo()+","+u.isProfesor()+","+u.isAdmin());
		archivoExamen.close();
		ficheroExamen.close();
	}
	
	public void ingresoUsuariosAlSistema() throws FileNotFoundException {
		Scanner archivo = new Scanner(new File("archivos/usuarios.txt"));
		while(archivo.hasNextLine()) {
			String linea = archivo.nextLine();
			String [] parte = linea.split(",");
			String nombre = parte[0];
			String apellidos =parte[1];
			char [] pass = new char[parte[2].length()];
			for(int i=0;i<parte[2].length();i++) {
				pass[i] = parte[2].charAt(i);
			}
			String nomUsuario = parte[3];
			String correo =  parte[4];
			Usuario u = new Usuario(nombre,apellidos,pass,nomUsuario,correo);
			if(parte[5].equals("true")) u.setProfesor(true);
			if(parte[6].equals("true")) u.setAdmin(true);
			this.agregarUsuario(u);
		}
	}
	
	
	public Connection ConectBaseDeDatos() throws ClassNotFoundException, SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tablaprogra?serverTimezone=UTC","root","9aad96631");
	}
	
	public void ordenarDatos(PanelEstadisticas panelEsta,int menor) throws SQLException, ClassNotFoundException {
		Connection conex = this.ConectBaseDeDatos();
		Statement s = conex.createStatement();
		ResultSet r ;
		if(this.u == null) {
			if(menor == 0) r = s.executeQuery("SELECT * FROM tablapuntajesusuarios ORDER BY puntaje DESC");
			else r = s.executeQuery("SELECT * FROM tablapuntajesusuarios ORDER BY puntaje");
		}else {
			if(menor == 0) r = s.executeQuery("SELECT * FROM tablapuntajesusuarios WHERE usuario = '"+this.u.getNombreUsuario()+"' ORDER BY puntaje DESC");
			else r = s.executeQuery("SELECT * FROM tablapuntajesusuarios WHERE usuario ='"+this.u.getNombreUsuario()+"' ORDER BY puntaje");
		}
		while(r.next()) {
			
			Object [] fila=new Object[4];
			String usuario = r.getString(1);
			String nombreUsuario = r.getString(2);
			String nombreExamen = r.getString(3);
			int puntaje = r.getInt(4);
			
			fila[0] = usuario;
			fila[1] = nombreUsuario;
			fila[2] = nombreExamen;
			fila[3] = puntaje;
			
			panelEsta.getModelo().addRow(fila);
			panelEsta.getTabla().setModel(panelEsta.getModelo());
		}
		
	}
	
	
	public void sacarDatos(PanelEstadisticas panelEsta) throws ClassNotFoundException, SQLException {
		Connection conex = this.ConectBaseDeDatos();
		Statement s = conex.createStatement();
		ResultSet r;
		if(this.u == null) r = s.executeQuery("SELECT * FROM tablapuntajesusuarios");
		else r = s.executeQuery("SELECT * FROM tablapuntajesusuarios WHERE usuario = '"+this.u.getNombreUsuario()+"'");
		
		while(r.next()) {
			Object [] fila=new Object[4];
			String usuario = r.getString(1);
			String nombreUsuario = r.getString(2);
			String nombreExamen = r.getString(3);
			int puntaje = r.getInt(4);
			
			fila[0] = usuario;
			fila[1] = nombreUsuario;
			fila[2] = nombreExamen;
			fila[3] = puntaje;
			
			panelEsta.getModelo().addRow(fila);
			panelEsta.getTabla().setModel(panelEsta.getModelo());
		}
	}
	
	
	public void ingresarDatos(String nombre,String nombreUsuario,String nombreExamen,int puntaje) {
		Connection conex;
		try {
			conex = this.ConectBaseDeDatos();
			PreparedStatement s = conex.prepareStatement("INSERT INTO tablapuntajesusuarios (Usuario,nombreUsuario,nombreExamen,puntaje) VALUES(?,?,?,?)");
			s.setString(1, nombre);
			s.setString(2, nombreUsuario);
			s.setString(3, nombreExamen);
			s.setInt(4, puntaje);
			
			s.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.print("no funciona");
			e.printStackTrace();
		}
	}
	/**
	 * metodo que retorna la lista de usuarios
	 * @return
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * metodo que retorna la lista de preguntas del examen
	 * @return Arraylist
	 */
	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * metodo que retorna la lista de nombre de examenes en el sistema
	 * @return
	 */
	public ArrayList<String> getNamExam() {
		return namExam;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public Usuario buscar(String text) {
		for(int i=0;i<this.usuarios.size();i++) {
			if(this.usuarios.get(i).getNombreUsuario().equals(text)) {
				return u = this.usuarios.get(i);
			}
		}
		return null;
	}
}
