package clases;

import java.sql.SQLException;

import enumeraciones.Pais;
import excepciones.ContrasegnaIncorrectaException;

public final class Cliente extends Usuario {
	
	private float monedero;
	private int paquetesComprados;
	
	
	
	public Cliente(String email, String nombreUsuario, String nombre, String apellido, String pass, Pais pais,
			float monedero, int paquetesComprados) throws SQLException, ContrasegnaIncorrectaException {
		super(email, nombreUsuario, nombre, apellido, pass, pais);
		this.monedero = monedero;
		this.paquetesComprados = paquetesComprados;
	}
	public float getMonedero() {
		return monedero;
	}
	public void setMonedero(float monedero) {
		this.monedero = monedero;
	}
	public int getPaquetesComprados() {
		return paquetesComprados;
	}
	public void setPaquetesComprados(int paquetesComprados) {
		this.paquetesComprados = paquetesComprados;
	}
	@Override
	public String toString() {
		return "Cliente [monedero=" + monedero + ", paquetesComprados=" + paquetesComprados + "]";
	}
	
	
	

}
