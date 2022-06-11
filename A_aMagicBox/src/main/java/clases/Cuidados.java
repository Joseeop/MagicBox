package clases;

import java.awt.image.BufferedImage;

import enumeraciones.TipoComida;
import enumeraciones.TipoCuidado;

public class Cuidados extends Actividad{
	private TipoCuidado tipoCuidado;
	
	public Cuidados(String nombre, String foto, String descripcion,TipoCuidado tipoCuidado) {
		super(nombre, foto, descripcion);
	
		this.tipoCuidado=tipoCuidado;
	}
	
	

	public TipoCuidado getTipoCuidado() {
		return tipoCuidado;
	}



	public void setTipoCuidado(TipoCuidado tipoCuidado) {
		this.tipoCuidado = tipoCuidado;
	}



	@Override
	public String toString() {
		return "Cuidados [tipoCuidado=" + tipoCuidado + "]";
	}
	
	



}
