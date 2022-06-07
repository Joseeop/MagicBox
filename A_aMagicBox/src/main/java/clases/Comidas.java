package clases;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enumeraciones.TipoComida;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;

public class Comidas extends Actividad {
	
	private TipoComida tipoComida;

	public Comidas(String nombre, String foto, String descripcion, TipoComida tipoComida) {
		super(nombre, foto, descripcion);
		this.tipoComida = tipoComida;
	}
	
	
	protected Comidas(String nombre) throws SQLException, UsuarioNoExisteException {
		
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
			throw new UsuarioNoExisteException("No existe ese restaurante en la BD");
		}
		ConexionBD.desconectar();
	}
	
	 public Comidas() {
		// TODO Auto-generated constructor stub
	}


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
