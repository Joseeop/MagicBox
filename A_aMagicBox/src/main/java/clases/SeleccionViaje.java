package clases;

import java.util.ArrayList;

public class SeleccionViaje extends ElementoConNombre {
	
	//Plural o singular?
	private  ArrayList<Destinos> destinos;
	
	//Constructor

	public SeleccionViaje(ArrayList<Destinos> destinos) {
		super();
		this.destinos = destinos;
	}

	
	//Getters AND Setters
	public ArrayList<Destinos> getDestinos() {
		return destinos;
	}

	public void setDestinos(ArrayList<Destinos> destinos) {
		this.destinos = destinos;
	}

	//ToString
	@Override
	public String toString() {
		return "SeleccionViaje [destinos=" + destinos + "]";
	}
	
		
	

}
