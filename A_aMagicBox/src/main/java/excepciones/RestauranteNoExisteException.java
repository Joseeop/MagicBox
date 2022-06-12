package excepciones;

/**
 * Excepción que salta si el restaurante que intentamos buscar no existe.
 * @author José Oña Pineda
 *
 */
public class RestauranteNoExisteException extends Exception {
	
	public RestauranteNoExisteException (String m) {
		super(m);
	}

}
