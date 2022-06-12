package clases;

import java.util.ArrayList;
/**
 *  clase que hereda de ElementoConNombre y encargada de almacenar la lista de comidas
 * @author José Oña Pineda
 *
 */

public class SeleccionComida extends ElementoConNombre{

/**
 * Variable tipo arraylist encargada de almacenar las comidas.
 */
	private ArrayList <Comidas>comida;

	public SeleccionComida(String nombre, ArrayList<Comidas> comida) {
		super(nombre);
		this.comida = comida;
	}

	public ArrayList<Comidas> getComida() {
		return comida;
	}

	public void setComida(ArrayList<Comidas> comida) {
		this.comida = comida;
	}

	@Override
	public String toString() {
		return "SeleccionComida [comida=" + comida + "]";
	}
	
	
}
