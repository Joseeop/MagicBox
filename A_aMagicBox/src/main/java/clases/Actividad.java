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



@Override
public String toString() {
	return super.toString()+ "  Actividad [foto=" + foto + ", descripcion=" + descripcion + "]";
}




	
	
	
	

}
