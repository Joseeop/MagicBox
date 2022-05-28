package clases;

import java.util.ArrayList;

public class SeleccionCuidado extends ElementoConNombre{


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
