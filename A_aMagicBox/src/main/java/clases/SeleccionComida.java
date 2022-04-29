package clases;

import java.util.ArrayList;

public class SeleccionComida {

	//Plural o singular?
	private ArrayList<Comidas> comidas;
	
	//Constructor

	public SeleccionComida(ArrayList<Comidas> comidas) {
		super();
		this.comidas = comidas;
	}
	
	//Getters AND Setters

	public ArrayList<Comidas> getComidas() {
		return comidas;
	}

	public void setComidas(ArrayList<Comidas> comidas) {
		this.comidas = comidas;
	}

	
	//ToString
	@Override
	public String toString() {
		return "SeleccionComida [comidas=" + comidas + "]";
	}
	
	
	
}
