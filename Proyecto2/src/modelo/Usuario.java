package modelo;

/**
 * clase Usuario que registra el nombre y el puntaje del usuario a hacer el examen
 * @author hello
 *
 */
public class Usuario {
	private String nombre;
	private String apellido;
	private char[] password;
	private String nombreUsuario;
	private String correo;
	private boolean admin;
	private boolean profesor;
	
	private int puntaje;
	
	
	/**
	 * contructor Usuario
	 * @param nombreCompleto
	 */
	public Usuario(String nombre,String apellido,char [] password,String nombreUsuario,String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.puntaje = 0;
		this.admin = false;
		this.profesor = false;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public char[] getPassword() {
		return password;
	}


	public void setPassword(char[] password) {
		this.password = password;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public int getPuntaje() {
		return puntaje;
	}


	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public boolean isProfesor() {
		return profesor;
	}


	public void setProfesor(boolean profesor) {
		this.profesor = profesor;
	}
	
}
