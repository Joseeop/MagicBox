package clases;

import java.time.LocalDateTime;

public final class PaqueteComprado extends Compra{
	
	private Paquete paquete;
	private Actividad actividadElegida;
	
	
	//Constructor
	public PaqueteComprado(Cliente usuarios, LocalDateTime fechaCompra, float precioCompra, Paquete paquete,
			Actividad actividadElegida) {
		super(usuarios, fechaCompra, precioCompra);
		this.paquete = paquete;
		this.actividadElegida = actividadElegida;
	}


	
	//Getters AND Setters
	public Paquete getPaquete() {
		return paquete;
	}


	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}


	public Actividad getActividadElegida() {
		return actividadElegida;
	}


	public void setActividadElegida(Actividad actividadElegida) {
		this.actividadElegida = actividadElegida;
	}



	//ToString
	@Override
	public String toString() {
		return "PaqueteComprado [paquete=" + paquete + ", actividadElegida=" + actividadElegida + "]";
	}
	
	
	
	
	

}
