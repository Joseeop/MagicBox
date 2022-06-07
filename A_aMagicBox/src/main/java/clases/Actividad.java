package clases;

import java.awt.image.BufferedImage;

public class Actividad extends ElementoConNombre {
	
protected String foto;
protected String descripcion;



public Actividad(String nombre, String foto, String descripcion) {
	super(nombre);
	this.foto = foto;
	this.descripcion = descripcion;
}



public Actividad() {
	// TODO Auto-generated constructor stub
}



public String getFoto() {
	return foto;
}



public void String(String foto) {
	this.foto = foto;
}



public String getDescripcion() {
	return descripcion;
}



public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}



@Override
public String toString() {
	return super.toString()+ "  Actividad [foto=" + foto + ", descripcion=" + descripcion + "]";
}







	
	
	
	

}
