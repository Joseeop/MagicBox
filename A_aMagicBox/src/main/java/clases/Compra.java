package clases;

import java.time.LocalDateTime;

public class Compra {
	
	private Usuario cliente;
	private LocalDateTime fechaDeCompra;
	private float precioDeCompra;
	
	
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
