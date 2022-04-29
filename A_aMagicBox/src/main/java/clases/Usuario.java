package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.ContraseñaIncorrectaException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;

public class Usuario extends ElementoConNombre {

	private String nombreUsuario;
	private String email;
	private String password;
	private String apellido;
	//Necesitamos variable activo?
	
	//Constructor
	public Usuario(String nombreUsuario, String email, String password, String apellido) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.apellido = apellido;
	}
	
	public Usuario(String email) throws SQLException { 
		//Constructor para saber todos los datos de un usuario en la BBDD según su email.
		Statement smtSelect = utils.ConexionBD.conectar();
		 ResultSet cursor = smtSelect.executeQuery("select * from usuario where email='"+email+"';");
		 if (cursor.next()) { //Lo hacemos con un if ya que el email será clave primaria.
			 	//Habría que crear las tablas en BBDD para modificar los getters.
				
			 	this.email = email;
			 	this.password = cursor.getString("pass");
				this.nombreUsuario = cursor.getString("nombre");
				this.apellido=cursor.getString("apellido");
				
				

		 }else {
			 utils.ConexionBD.desconectar();
			 throw new SQLException("No se ha podido conectar");
		 }

		utils.ConexionBD.desconectar();
		
	}
	
	//Constructor para el login
	
	public Usuario(String email, String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException {
		Statement smt=ConexionBD.conectar();
		ResultSet cursor=smt.executeQuery("select * from usuario where email='"+
		email+"'");
		//If porque es primary key y solo hay uno.
		
		if(cursor.next()) {
			this.password=cursor.getString("pass");
			if(!this.password.equals(contraseña)) {
				ConexionBD.desconectar();
				throw new ContraseñaIncorrectaException("La contraseña no es correcta");
			}
			this.email=cursor.getString("email");
			this.nombreUsuario=cursor.getString("nombreUsuario");
			this.apellido=cursor.getString("apellido");
		}else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese email en la BD");
		}
		ConexionBD.desconectar();
	}

	
	
	
	//Getters AND Setters
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	//TO STRING
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", email=" + email + ", password=" + password + ", apellido="
				+ apellido + "]";
	}
	
	
	
	
	
}
