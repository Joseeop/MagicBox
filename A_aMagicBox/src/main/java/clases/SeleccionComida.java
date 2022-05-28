package clases;

import java.util.ArrayList;

public class SeleccionComida extends ElementoConNombre{


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
