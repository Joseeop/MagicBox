package clases;

import java.awt.image.BufferedImage;

/**
 * Clase que hereda de Actividad. Cuya función es definir el destino elegido.
 * @author José Oña Pineda
 *
 */
public class Destinos extends Actividad {
	
/**
 * variable interna tipo String para definir la ubicación del destino (redundante).
 */
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
