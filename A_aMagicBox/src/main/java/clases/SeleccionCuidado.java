package clases;

import java.util.ArrayList;

/**
 * Clase que hereda de ElementoCoNombre y encargada de almacenar la lista de cuidados
 * @author José Oña Pineda
 *
 */
public class SeleccionCuidado extends ElementoConNombre{

	/**
	 * Variable de tipo arraylist encargada de almacenar la lista de cuidados.
	 */
	private ArrayList<Cuidados>cuidado;

	public SeleccionCuidado(String nombre, ArrayList<Cuidados> cuidado) {
		super(nombre);
		this.cuidado = cuidado;
	}

	public ArrayList<Cuidados> getCuidado() {
		return cuidado;
	}

	public void setCuidado(ArrayList<Cuidados> cuidado) {
		this.cuidado = cuidado;
	}

	@Override
	public String toString() {
		return "SeleccionCuidado [cuidado=" + cuidado + "]";
	}
	
	
}
