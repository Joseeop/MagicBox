package clases;

import java.time.LocalDateTime;

/**
 * Clase compra en la  que fijaremos los detalles de la compra.
 * @author Spanys
 *
 */
public class Compra {
	
	/**
	 * variable de tipo usuario para el cliente
	 */
	private Usuario cliente;
	/**
	 * variable tipo localdatetime para almacenar la fecha de compra
	 */
	private LocalDateTime fechaDeCompra;
	/**
	 * variable tipo float en la que alamacenaremos el precio de compra
	 */
	private float precioDeCompra;
	
	/**
	 * constructor de clase
	 * @param cliente logueado
	 * @param fechaDeCompra del paquete
	 * @param precioDeCompra del paquete 
	 */
	public Compra(Usuario cliente, LocalDateTime fechaDeCompra, float precioDeCompra) {
		super();
		this.cliente = cliente;
		this.fechaDeCompra = fechaDeCompra;
		this.precioDeCompra = precioDeCompra;
	}


	public Usuario getCliente() {
		return cliente;
	}


	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}


	public LocalDateTime getFechaDeCompra() {
		return fechaDeCompra;
	}


	public void setFechaDeCompra(LocalDateTime fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}


	public float getPrecioDeCompra() {
		return precioDeCompra;
	}


	public void setPrecioDeCompra(float precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}


	@Override
	public String toString() {
		return "Compra [cliente=" + cliente + ", fechaDeCompra=" + fechaDeCompra + ", precioDeCompra=" + precioDeCompra
				+ "]";
	}
	
	
	
	
	
	
	
	

}
