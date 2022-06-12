package clases;

import java.sql.SQLException;

import enumeraciones.Pais;
import excepciones.ContrasegnaIncorrectaException;

/**
 * Clase que hereda de usuario y representa si un usuario es adminitrador o cliente para tener ciertos permisos
 * @author José Oña Pineda
 *
 */
public final class Administrador extends Usuario {

	public Administrador(String email, String nombreUsuario, String nombre, String apellido, String pass, Pais pais)
			throws SQLException, ContrasegnaIncorrectaException {
		super(email, nombreUsuario, nombre, apellido, pass, pais);
		// TODO Auto-generated constructor stub
	}

	
	

	

}
