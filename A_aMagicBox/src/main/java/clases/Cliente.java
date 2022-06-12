package clases;

import java.sql.SQLException;

import enumeraciones.Pais;
import excepciones.ContrasegnaIncorrectaException;
/**
 * clase que hereda de Usuario y que determina la clase de usuario que es, en este caso cliente
 * @author Spanys
 *
 */
public final class Cliente extends Usuario {
	
	/**
	 * variable interna (float) que representa el dinero que tiene el usuario en su monedero
	 */
	private float monedero;
	/**
	 * variable interna (int) que representa el número de paquetes que ha comprado el cliente.
	 */
	private int paquetesComprados;
	
	
	/**
	 * Constructor de clase con todas las variable internas
	 * @param email del usuario
	 * @param nombreUsuario nombre de usuario, NO nombre de la persona
	 * @param nombre nombre del usuario
	 * @param apellido apellido del usuario
	 * @param pass password de ingreso del usuario
	 * @param pais pais al que pertenece el usuario
	 * @param monedero dinero que tiene el usuario en la aplicación
	 * @param paquetesComprados número de paquetes que ha adquirido el usuario en la aplicación
	 * @throws SQLException exepción de sql
	 * @throws ContrasegnaIncorrectaException excepción de contraseña incorrecta.
	 */
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
