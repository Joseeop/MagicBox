package clases;

public class Usuario extends ElementoConNombre {

	private String nombreUsuario;
	private String email;
	private String password;
	private String apellido;
	
	//Constructor
	public Usuario(String nombreUsuario, String email, String password, String apellido) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.apellido = apellido;
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
