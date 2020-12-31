package interfaz;

import javax.swing.*;


public class PanelRegistro extends JPanel {
	private JLabel nombre,apellido,Usuario,password,correoElectronico;
	private JPasswordField registro4,registro5;
	private JTextField registro1,registro2,registro3,registro6;
	private JButton registrar;
	
	public PanelRegistro() {
		setLayout(null);
		textos();
		boton();
	}
	
	private void textos() {
		nombre = new JLabel("Nombres    ");
		nombre.setBounds(10,0 ,115 ,100 );
		add(nombre);
		registro1 = new JTextField();
		registro1.setBounds(125, 40, 250, 20);
		add(registro1);
		
		apellido = new JLabel("Apellidos    ");
		apellido.setBounds(10,20 ,115 ,100 );
		add(apellido);
		registro2 = new JTextField();
		registro2.setBounds(125, 60, 250, 20);
		add(registro2);
		
		Usuario = new JLabel("Nombre de usuario  ");
		Usuario.setBounds(10,40 ,115 ,100 );
		add(Usuario);
		registro3 = new JTextField();
		registro3.setBounds(125, 80, 250, 20);
		add(registro3);
		
		password = new JLabel("contraseña");
		password.setBounds(10, 60, 116, 100);
		add(password);
		registro4 = new JPasswordField();
		registro4.setBounds(125, 100, 250, 20);
		add(registro4);
		
		nombre = new JLabel("repita contraseña");
		nombre.setBounds(10,80,115 ,100 );
		add(nombre);
		registro5 = new JPasswordField();
		registro5.setBounds(125, 120, 250, 20);
		add(registro5);
		
		correoElectronico = new JLabel("correo electronico  ");
		correoElectronico.setBounds(10, 100, 115, 100);
		add(correoElectronico);
		registro6 = new JTextField();
		registro6.setBounds(125, 140, 250, 20);
		add(registro6);
		
	}
	
	private void boton() {
		registrar = new JButton("registrar");
		registrar.setBounds(400, 250, 100, 30);
		add(registrar);
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getApellido() {
		return apellido;
	}

	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}

	public JLabel getUsuario() {
		return Usuario;
	}

	public void setUsuario(JLabel usuario) {
		Usuario = usuario;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JLabel getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(JLabel correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public JPasswordField getRegistro4() {
		return registro4;
	}

	public void setRegistro4(JPasswordField registro4) {
		this.registro4 = registro4;
	}

	public JPasswordField getRegistro5() {
		return registro5;
	}

	public void setRegistro5(JPasswordField registro5) {
		this.registro5 = registro5;
	}

	public JTextField getRegistro1() {
		return registro1;
	}

	public void setRegistro1(JTextField registro1) {
		this.registro1 = registro1;
	}

	public JTextField getRegistro2() {
		return registro2;
	}

	public void setRegistro2(JTextField registro2) {
		this.registro2 = registro2;
	}

	public JTextField getRegistro3() {
		return registro3;
	}

	public void setRegistro3(JTextField registro3) {
		this.registro3 = registro3;
	}

	public JTextField getRegistro6() {
		return registro6;
	}

	public void setRegistro6(JTextField registro6) {
		this.registro6 = registro6;
	}

	public JButton getRegistro() {
		return registrar;
	}

	
}
