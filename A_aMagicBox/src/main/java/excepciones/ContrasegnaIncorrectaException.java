package excepciones;
/**
 * Excepción que salta si la contraseña ingresada no se corresponde con la almacenada en la BBDD
 * @author Spanys
 *
 */
public class ContrasegnaIncorrectaException extends Exception{
	public ContrasegnaIncorrectaException(String m) {
		super(m);
	}
}
