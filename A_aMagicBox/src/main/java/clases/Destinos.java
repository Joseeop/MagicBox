package clases;

import java.awt.image.BufferedImage;

public class Destinos extends Actividad {
	
	private String ubicacion;
	
	
	//Constructor

	public Destinos(BufferedImage foto, String descripcion, String ubicacion) {
		super(foto, descripcion);
		this.ubicacion = ubicacion;
	}
	
	//Getters and Setters

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	//ToString
	@Override
	public String toString() {
		return "Destinos [ubicacion=" + ubicacion + "]";
	}


	

}
