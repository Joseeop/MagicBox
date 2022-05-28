package clases;

public class Paquetes extends ElementoConNombre  {
	
private String calidad;
private float precio;
private SeleccionViaje actividadViaje;
private SeleccionComida actividadComida;
private SeleccionCuidado actividadCuidado;



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
