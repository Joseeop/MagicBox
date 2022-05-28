package clases;

import java.time.LocalDateTime;

public final class PaqueteComprado extends Compra{
	

	private Paquetes paquete;
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
