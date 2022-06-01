package clases;

import java.awt.image.BufferedImage;

public class Actividad extends ElementoConNombre {
	
private BufferedImage foto;
private String descripcion;



public Actividad(String nombre, BufferedImage foto, String descripcion) {
	super(nombre);
	this.foto = foto;
	this.descripcion = descripcion;
}



public BufferedImage getFoto() {
	return foto;
}



public void setFoto(BufferedImage foto) {
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
