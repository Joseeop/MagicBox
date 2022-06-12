package clases;

/**
 * clase que hereda de ElementoCoNombre, encargada de almacenar las actividades
 * @author José Oña Pineda
 *
 */
public class Paquetes extends ElementoConNombre  {

	/**
	 * variable interna tipo String, que determina la calidad del paquete
	 */
private String calidad;
	/**
	 * variable interna tipo String, que determina el precio del paquete.
	 */
private float precio;
/**
 * Variable interta tipo SeleccionViaje, encargada de almacenar el viaje.
 */
private SeleccionViaje actividadViaje;
/**
 * Variable interna tipo SeleccionComida encargada de almacenar la actividad comida.
 */
private SeleccionComida actividadComida;
/**
 * Variable interna tipo SeleccionCuidado encargada de almacenar la actividad cuidado.
 */
private SeleccionCuidado actividadCuidado;


/**
 * Constructor de clase
 * @param nombre del paquete
 * @param calidad del paquete 
 * @param precio del paquete
 * @param actividadViaje
 * @param actividadComida
 * @param actividadCuidado
 */
public Paquetes(String nombre, String calidad, float precio, SeleccionViaje actividadViaje,
		SeleccionComida actividadComida, SeleccionCuidado actividadCuidado) {
	super(nombre);
	this.calidad = calidad;
	this.precio = precio;
	this.actividadViaje = actividadViaje;
	this.actividadComida = actividadComida;
	this.actividadCuidado = actividadCuidado;
}



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



public SeleccionViaje getActividadViaje() {
	return actividadViaje;
}



public void setActividadViaje(SeleccionViaje actividadViaje) {
	this.actividadViaje = actividadViaje;
}



public SeleccionComida getActividadComida() {
	return actividadComida;
}



public void setActividadComida(SeleccionComida actividadComida) {
	this.actividadComida = actividadComida;
}



public SeleccionCuidado getActividadCuidado() {
	return actividadCuidado;
}



public void setActividadCuidado(SeleccionCuidado actividadCuidado) {
	this.actividadCuidado = actividadCuidado;
}



@Override
public String toString() {
	return "Paquete [calidad=" + calidad + ", precio=" + precio + ", actividadViaje=" + actividadViaje
			+ ", actividadComida=" + actividadComida + ", actividadCuidado=" + actividadCuidado + "]";
}




	
	
	
	
	

}
