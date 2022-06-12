package clases;

import java.sql.SQLException;

/**
 * Superclase de la que heredarán las clases que necesiten un nombre para la creación del objeto.
 * @author José Oña Pineda
 *
 */
public abstract class ElementoConNombre {

		/**
		 * variable interna tipo String que determinará el nombre.
		 */
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
