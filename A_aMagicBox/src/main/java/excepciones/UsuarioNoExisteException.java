package excepciones;

public class UsuarioNoExisteException extends Exception{
	public UsuarioNoExisteException(String m) {
		super(m);
	}
}
