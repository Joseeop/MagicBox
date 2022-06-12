package clases;

import java.awt.image.BufferedImage;

import enumeraciones.TipoComida;
import enumeraciones.TipoCuidado;

/**
 * clase que hereda de actividad.
 * @author José Oña Pineda
 *
 */
public class Cuidados extends Actividad{
	/**
	 * variable interna para determinar el tipo de cuidado, predefinidos en un Enum.
	 */
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
