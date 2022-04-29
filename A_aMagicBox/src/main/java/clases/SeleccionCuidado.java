package clases;

import java.util.ArrayList;

public class SeleccionCuidado {

	//Plural o singular?
	private ArrayList<Cuidados> cuidados;

	//Constructor
	public SeleccionCuidado(ArrayList<Cuidados> cuidados) {
		super();
		this.cuidados = cuidados;
	
	}
	
	//Getters AND Setters

	public ArrayList<Cuidados> getCuidados() {
		return cuidados;
	}

	public void setCuidados(ArrayList<Cuidados> cuidados) {
		this.cuidados = cuidados;
	}

	
	//ToString
	@Override
	public String toString() {
		return "SeleccionCuidado [cuidados=" + cuidados + "]";
	}
	
	
}
