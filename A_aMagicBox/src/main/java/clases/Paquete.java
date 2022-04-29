package clases;

public class Paquete extends ElementoConNombre  {
	
	private String calidad;
	private float precio;
	//Revisar nombre de variables.
	private SeleccionViaje seleccionViaje;
	private SeleccionComida seleccionComida;
	private SeleccionCuidado seleccionCuidado;
	
	
	//Constructor
	public Paquete(String calidad, float precio, SeleccionViaje seleccionViaje, SeleccionComida seleccionComida,
			SeleccionCuidado seleccionCuidado) {
		super();
		this.calidad = calidad;
		this.precio = precio;
		this.seleccionViaje = seleccionViaje;
		this.seleccionComida = seleccionComida;
		this.seleccionCuidado = seleccionCuidado;
	}

	
	//Getters AND Setters

	public String getCalidad() {
		return calidad;
	}


	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public SeleccionViaje getSeleccionViaje() {
		return seleccionViaje;
	}


	public void setSeleccionViaje(SeleccionViaje seleccionViaje) {
		this.seleccionViaje = seleccionViaje;
	}


	public SeleccionComida getSeleccionComida() {
		return seleccionComida;
	}


	public void setSeleccionComida(SeleccionComida seleccionComida) {
		this.seleccionComida = seleccionComida;
	}


	public SeleccionCuidado getSeleccionCuidado() {
		return seleccionCuidado;
	}


	public void setSeleccionCuidado(SeleccionCuidado seleccionCuidado) {
		this.seleccionCuidado = seleccionCuidado;
	}


	
	//ToString
	@Override
	public String toString() {
		return "Paquete [calidad=" + calidad + ", precio=" + precio + ", seleccionViaje=" + seleccionViaje
				+ ", seleccionComida=" + seleccionComida + ", seleccionCuidado=" + seleccionCuidado + "]";
	}
	
	
	
	
	
	

}
