package clases;

import java.awt.image.BufferedImage;

public class Destinos extends Actividad {
	

private String ubicacion;

public Destinos(String nombre, BufferedImage foto, String descripcion, String ubicacion) {
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





//
//	public void setUbicacion(String ubicacion) {
//		//Persistir
//		this.ubicacion = ubicacion;
//	}
//	
//	//hacer sobreescritura al setFoto, setDescripcion de Actividad, haciendo también persistencia aqui
//	//hacer también overrride al setNombre de ElementoConNombre para que también persista si cambia el nombre
//	//Hacer la mismo en lacase Comida y la clase Cuidado

	
	

	

}
