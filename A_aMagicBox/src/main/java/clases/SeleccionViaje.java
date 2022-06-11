package clases;

import java.util.ArrayList;

public class SeleccionViaje extends ElementoConNombre {
	

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
