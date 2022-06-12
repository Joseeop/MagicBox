package clases;

import java.awt.image.BufferedImage;

public class Actividad extends ElementoConNombre {
/**
 * Variable foto que establece la imagen de cada destino	
 */
protected String foto;
/**
 * Variable descripción que establece la descripción de cada destino
 */
protected String descripcion;


/**
 * constructor actividad con todas las variables internas
 * @param nombre string de la actividad
 * @param foto string con la ruta de la foto
 * @param descripcion string con la descripción de la actividad
 */
public Actividad(String nombre, String foto, String descripcion) {
	super(nombre);
	this.foto = foto;
	this.descripcion = descripcion;
}


/**
 * Constructor vacio.
 */
public Actividad() {
	// TODO Auto-generated constructor stub
}


/**
 * getter de foto que devuelve la foto
 * @return la foto.
 */
public String getFoto() {
	return foto;
}


/**
 * setter de foto
 * @param la nueva foto que aplicamos
 */
public void setFoto(String foto) {
	this.foto = foto;
}


/**
 * getter de descripción que devuelve la descripción	
 * @return la descripción
 */
public String getDescripcion() {
	return descripcion;
}


/**
 * setter de descripcion
 * @param la nueva descripción descripción que insertamos
 */
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


/**
 * toString de la clase actividad.
 */
@Override
public String toString() {
	return super.toString()+ "  Actividad [foto=" + foto + ", descripcion=" + descripcion + "]";
}







	
	
	
	

}
