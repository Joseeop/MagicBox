package clases;

import java.util.ArrayList;
/**
 * clase que hereda de ElementoConNombre y encargada de almacenar la lista de destinos
 * @author José Oña Pineda
 *
 */
public class SeleccionViaje extends ElementoConNombre {
	
/**
 * variable tipo ArrayList de destino donde almacenaremos la lista de paises
 */
private ArrayList<Destinos>destino;

public SeleccionViaje(String nombre, ArrayList<Destinos> destino) {
	super(nombre);
	this.destino = destino;
}

public  ArrayList<Destinos> getDestino() {
	return destino;
}

public void setDestino(ArrayList<Destinos> destino) {
	this.destino = destino;
}

@Override
public String toString() {
	return "SeleccionViaje [destino=" + destino + "]";
}


		
	

}
