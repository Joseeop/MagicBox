package clases;

import java.sql.SQLException;

public abstract class ElementoConNombre {

	private String nombre;

	public ElementoConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	public ElementoConNombre() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException {
		
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ElementoConNombre [nombre=" + nombre + "]";
	}
	
	
}
