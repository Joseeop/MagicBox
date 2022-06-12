package excepciones;

/**
 * Excepción que salta si el usuario que intentamos buscar no existe.
 * @author José Oña Pineda
 *
 */
public class UsuarioNoExisteException extends Exception{
	public UsuarioNoExisteException(String m) {
		super(m);
	}
}
