package clases;

import java.time.LocalDateTime;
/**
 * Clase que hereda de compra y que representa una compra que te permite eliminar uan actividad de un objeto SeleccionCuidado o SeleccionViaje
 * @author José Oña Pineda
 *
 */
public final class ActividadEliminar extends Compra {

	
	/**
	 * Constructor de la clase con todas las variables internas.
	 * @param cliente
	 * @param fechaDeCompra
	 * @param precioDeCompra
	 */
	public ActividadEliminar(Usuario cliente, LocalDateTime fechaDeCompra, float precioDeCompra) {
		super(cliente, fechaDeCompra, precioDeCompra);
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
