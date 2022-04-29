package clases;

public final class Cliente extends Usuario {
	
	private float monedero;
	private int paquetesComprados;
	
	
	//Constructor
	public Cliente(String nombreUsuario, String email, String password, String apellido, float monedero,
			int paquetesComprados) {
		super(nombreUsuario, email, password, apellido);
		this.monedero = monedero;
		this.paquetesComprados = paquetesComprados;
	}

	//Getters AND Setters

	public float getMonedero() {
		return monedero;
	}


	public void setMonedero(float monedero) {
		this.monedero = monedero;
	}


	public int getPaquetesComprados() {
		return paquetesComprados;
	}


	public void setPaquetesComprados(int paquetesComprados) {
		this.paquetesComprados = paquetesComprados;
	}

	
	//ToString
	@Override
	public String toString() {
		return "Cliente [monedero=" + monedero + ", paquetesComprados=" + paquetesComprados + "]";
	}
	
	
	
	

}
