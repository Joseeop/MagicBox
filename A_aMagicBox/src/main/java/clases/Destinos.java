package clases;

import java.awt.image.BufferedImage;

public class Destinos extends Actividad {
	

private String ubicacion;

public Destinos(String nombre, String foto, String descripcion, String ubicacion) {
	super(nombre, foto, descripcion);
	this.ubicacion = ubicacion;
}

public String getUbicacion() {
	return ubicacion;
}

public void setUbicacion(String ubicacion) {
	this.ubicacion = ubicacion;
}

@Override
public String toString() {
	return "Destinos [ubicacion=" + ubicacion + "]";
}







	
	

	

}
