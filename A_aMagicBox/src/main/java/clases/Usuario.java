package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import enumeraciones.Pais;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;

public class Usuario extends ElementoConNombre {
	
	private String email;
	private String nombreUsuario;
	private String apellido;
	private String pass;
	private Pais pais;
	 
	

	/**
	 * Este constructor va a persistir en BD el usuario que estoy creando.
	 * 
	 * @param nombre nombre del usuario
	 * @param email  email del usuario
	 * @param pass   password del usuario
	 * @param activo true si está activo, false si no lo está
	 * @throws SQLException
	 * @throws ContrasegnaIncorrectaException
	 * @throws ContrasegnaIncorrectaException
	 */
	public Usuario(String email,String nombreUsuario,String nombre, String apellido,  String pass, Pais pais)
			throws SQLException, ContrasegnaIncorrectaException {
		super();

		if (!isPassValid(pass)) {
			throw new ContrasegnaIncorrectaException("La contrase�a debe tener al menos 3 caracteres.");
		}

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(										
				 "insert into usuario values('"+email+"','"+nombreUsuario+"','"+nombre+"','"+apellido+"'"
				 		+ ",'"+pass+"','"+pais.toString()+"');") > 0) {
			// Solo si todo ha ido bien insertando, se modifican las variables internas
			
			this.email = email;
			this.nombreUsuario=nombreUsuario;
			setNombre(nombre);
			this.apellido=apellido;
			this.pass = pass;
			this.pais=pais;
			
			
		} else {
			// Si no se ha podido insertar, lanzo un error: Algo ha ido mal.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
	}

	
	private Usuario() { //Este método vacio es para la función getTodo
	}

	
	/**
	 * Constructor para cargar un usuario existente al hacer un Login válido
	 * 
	 * @param email
	 * @param contrasegna
	 * @throws SQLException
	 * @throws ContrasegnaIncorrectaException
	 * @throws UsuarioNoExisteException
	 * @throws ContrasegnaIncorrectaException
	 */
	public Usuario(String email, String pass) throws SQLException, ContrasegnaIncorrectaException,
			UsuarioNoExisteException, ContrasegnaIncorrectaException {

		super();
		// Proteger los setters
		if (!isPassValid(pass)) {
			throw new ContrasegnaIncorrectaException("La contraseña debe tener al menos 3 caracteres.");
		}

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from usuario where email='" + email + "'");
		
		if (cursor.next()) {
			this.pass = cursor.getString("pass");
			//Si la contraseña por parámetro no coincide con la de BBDD, exception
			if (!this.pass.equals(pass)) {
				ConexionBD.desconectar();
				throw new ContrasegnaIncorrectaException("La contraseña no es correcta");
			}
			
			this.email = email;
			this.nombreUsuario=cursor.getString("nombreUsuario");
			super.setNombre(cursor.getString("nombre"));
			this.apellido=cursor.getString("apellido");
			this.pass=pass;
			this.pais=Pais.valueOf(cursor.getString("pais"));
			
			
		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese email en la BD");
		}
		ConexionBD.desconectar();
	}

	protected Usuario(String email) throws SQLException, UsuarioNoExisteException {

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from usuario where email='" + email + "'");
		// Aqu� podemos usar if en vez de while porque si el email est�, solo va a estar
		// una vez, porque es la PK
		if (cursor.next()) {
			this.pass = cursor.getString("pass");
			this.email = cursor.getString("email");
			//this.nombre = cursor.getString("nombre");
			
		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese email en la BD");
		}
		ConexionBD.desconectar();
	}



	/**
	 * Este setter persiste los cambios en la variable nombre
	 * 
	 * @param nombre el nuevo nombre del usuario
	 * @throws SQLException
	 */
	@Override
	public void setNombre(String nombre) throws SQLException {
		
		Statement smt = ConexionBD.conectar();
		
		if (smt.executeUpdate("update usuario set nombre='" + nombre + "' where email='" + this.email + "'") > 0) {
			// Solo modificamos si todo ha ido bien actualizando
			super.setNombre(nombre);
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el nombre");
		}
		ConexionBD.desconectar();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set email='" + email + "' where email='" + this.email + "'") > 0) {
			this.email = email;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el email");
		}
		ConexionBD.desconectar();
	}

	public String getPass() {
		return pass;
	}

	

	private static boolean isPassValid(String pass) {
		try {
			if (pass.length() < 3) {
				return false;
			} else {
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		}

	}

	public void setPass(String pass) throws SQLException, ContrasegnaIncorrectaException {
		// Proteger los setters
		if (!isPassValid(pass)) {
			throw new ContrasegnaIncorrectaException("La contrase�a debe tener al menos 3 caracteres.");
		}

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set pass='" + pass + "' where email='" + this.email + "'") > 0) {
			this.pass = pass;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el password");
		}
		ConexionBD.desconectar();
	}

	
	
	 public static ArrayList<Usuario>getTodos(){
		 ArrayList<Usuario> ret=new ArrayList<Usuario>();
		 
		 Statement smt=ConexionBD.conectar();
		 
		 ResultSet cursor;
		try {
			cursor = smt.executeQuery("select * from usuario;");
			 while(cursor.next()) {
				 Usuario u = new Usuario();
				 u.email=cursor.getString("email");
				 u.pass=cursor.getString("pass");
				 //u.nombre=cursor.getString("nombre");

				 ret.add(u);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
		 {
			 
		 }
		ConexionBD.desconectar();
		 
		 return ret;
	 }

	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + super.getNombre() + ", email=" + email+"]";
	}

	
	
	
}
