package clases;

import java.sql.SQLException;

import enumeraciones.Pais;
import excepciones.ContrasegnaIncorrectaException;

public final class Administrador extends Usuario {

	public Administrador(String email, String nombreUsuario, String nombre, String apellido, String pass, Pais pais)
			throws SQLException, ContrasegnaIncorrectaException {
		super(email, nombreUsuario, nombre, apellido, pass, pais);
		// TODO Auto-generated constructor stub
	}

	
	

	

}
