package clases;

import java.awt.image.BufferedImage;

public class Actividad extends ElementoConNombre {
	
	private BufferedImage foto;
	private String descripcion;
	
	//Constructor
	public Actividad(BufferedImage foto, String descripcion) {
		super();
		this.foto = foto;
		this.descripcion = descripcion;
	}
	
	
	//Getters and Setters

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


	
	//ToString
	@Override
	public String toString() {
		return "Actividad [foto=" + foto + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	

}
