package clases;

import java.awt.image.BufferedImage;

import enumeraciones.TipoComida;

public class Comidas extends Actividad {
	
	private TipoComida tipoComida;

	public Comidas(String nombre, BufferedImage foto, String descripcion, TipoComida tipoComida) {
		super(nombre, foto, descripcion);
		this.tipoComida = tipoComida;
	}
	
	
	

	@Override
	public String toString() {
		return super.toString()+" Comidas [tipoComida=" + tipoComida + "]";
	}

	



	
	
	
	

}
