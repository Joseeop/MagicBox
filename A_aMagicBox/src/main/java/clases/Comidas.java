package clases;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enumeraciones.TipoComida;
import excepciones.RestauranteNoExisteException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;

public class Comidas extends Actividad {
	
	/**
	 * variable del enum TipoComida
	 */
	private TipoComida tipoComida;

	public Comidas(String nombre, String foto, String descripcion, TipoComida tipoComida) {
		super(nombre, foto, descripcion);
		this.tipoComida = tipoComida;
	}
	
	/**
	 * Constructor de clase en el que hacemos una consulta a la BBDD y rescatamos los datos de un restaurante según su nombre.
	 * @param nombre del restaurante 
	 * @throws SQLException 
	 * @throws RestauranteNoExisteException excepción que salta cuando el restaurante no existe en la BBDD
	 */
	protected Comidas(String nombre) throws SQLException, RestauranteNoExisteException {
		
		super();
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from comida where nombreRestaurante='" + nombre + "'");
		// Aqu� podemos usar if en vez de while porque si el restaurante está, solo va a estar
		// una vez, porque es la PK
		if (cursor.next()) {
			String nombreRes = cursor.getString("nombreRestaurante");
			String rutaFoto = cursor.getString("foto");
			String descripcion = cursor.getString("descripcion");
			TipoComida tipoComida = TipoComida.valueOf(cursor.getString("tipoComida"));
			Comidas comida = new Comidas(nombreRes, rutaFoto, descripcion, tipoComida);
			
			//this.nombre = cursor.getString("nombre");
			
		} else {
			ConexionBD.desconectar();
			throw new RestauranteNoExisteException("No existe ese restaurante en la BD");
		}
		ConexionBD.desconectar();
	}
	
	 public Comidas() {
		// TODO Auto-generated constructor stub
	}

/**
 * función de ArrayList para devolver todas las comidas que tenemos alamacenadas en la BBDD mediante una consulta select.
 * @return resultado de las consultas
 */
	public static ArrayList<Comidas>getTodos(){
		 ArrayList<Comidas> ret=new ArrayList<Comidas>();
		 
		 Statement smt=ConexionBD.conectar();
		 
		 ResultSet cursor;
		try {
			cursor = smt.executeQuery("select * from comida;");
			 while(cursor.next()) {
				 Comidas c = new Comidas();
				 
				 c.descripcion=cursor.getString("descripcion");
				 c.foto=cursor.getString("foto");
				 c.tipoComida=TipoComida.valueOf(cursor.getString("tipoComida"));
				 //u.nombre=cursor.getString("nombre");

				 ret.add(c);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
		 {
			 
		 }
		ConexionBD.desconectar();
		 
		 return ret;
	 }
	

	@Override
	public String toString() {
		return super.toString()+" Comidas [tipoComida=" + tipoComida + "]";
	}

	



	
	
	
	

}
