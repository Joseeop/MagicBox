package excepciones;

/**
 * Excepción que salta cuando elegimos más opciones de las que podemos en las pantallas(no aplicada)
 * @author José Oña Pineda
 *
 */
public class OpcionesMaximasException extends Exception {
	
	public OpcionesMaximasException (String m) {
		super(m);
	}

}
