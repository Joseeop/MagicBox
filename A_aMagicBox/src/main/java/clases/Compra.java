package clases;

import java.time.LocalDateTime;

public class Compra {
	
	private Cliente usuarios;
	private LocalDateTime fechaCompra;
	private float precioCompra;
	
	
	//Constructor
	public Compra(Cliente usuarios, LocalDateTime fechaCompra, float precioCompra) {
		super();
		this.usuarios = usuarios;
		this.fechaCompra = fechaCompra;
		this.precioCompra = precioCompra;
	}


	
	//Getters AND Setters
	public Cliente getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Cliente usuarios) {
		this.usuarios = usuarios;
	}


	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public float getPrecioCompra() {
		return precioCompra;
	}


	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}


	
	//ToString

	@Override
	public String toString() {
		return "Compra [usuarios=" + usuarios + ", fechaCompra=" + fechaCompra + ", precioCompra=" + precioCompra + "]";
	}
	
	
	
	
	

}
