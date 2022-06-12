package clases;

import java.time.LocalDateTime;
/**
 * clase que hereda de Compra cuya funcionalidad es almacenar el paquete comprado.
 * @author José Oña Pineda
 *
 */
public final class PaqueteComprado extends Compra{
	
/**
 * variable interta tipo paquete
 */
	private Paquetes paquete;
	/**
	 * variable interna tipo actividad, donde se define la actividad elegida.
	 */
	private Actividad actividadElegida;
	
	
	public PaqueteComprado(Usuario cliente, LocalDateTime fechaDeCompra, float precioDeCompra, Paquetes paquete,
			Actividad actividadElegida) {
		super(cliente, fechaDeCompra, precioDeCompra);
		this.paquete = paquete;
		this.actividadElegida = actividadElegida;
	}


	public Paquetes getPaquete() {
		return paquete;
	}


	public void setPaquete(Paquetes paquete) {
		this.paquete = paquete;
	}


	public Actividad getActividadElegida() {
		return actividadElegida;
	}


	public void setActividadElegida(Actividad actividadElegida) {
		this.actividadElegida = actividadElegida;
	}


	@Override
	public String toString() {
		return "PaqueteComprado [paquete=" + paquete + ", actividadElegida=" + actividadElegida + "]";
	}
	
	

}
