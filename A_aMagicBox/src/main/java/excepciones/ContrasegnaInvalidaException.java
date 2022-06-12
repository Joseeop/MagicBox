package excepciones;

/**
 * Excepción que salta si la contraseña que queremos definir tiene menos de 3 caracteres
 * @author Spanys
 *
 */
public class ContrasegnaInvalidaException extends Exception {
	public ContrasegnaInvalidaException(String msg) {
		super(msg);
	}
}
