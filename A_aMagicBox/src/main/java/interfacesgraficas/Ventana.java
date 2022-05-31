package interfacesgraficas;

import java.awt.Cursor;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;

public class Ventana extends JFrame{
	/**
	 * Representa la pantalla actual por la que estoy navegando.
	 */
	private JPanel pantallaActual;
	/**
	 * Es el usuario que inicia sesión en la pantalla login, hasta entonces, vale null
	 * Lo tenemos aquí para que esté disponible en todas las pantallas.
	 */
	protected Usuario usuarioLogado;
	public Ventana() {
		
		
		
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		
		//Pantalla completa las dos lineas siguentes
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		this.setTitle("MAGIC BOX");
		this.setIconImage(new ImageIcon("./iconos/iconoVentana.png").getImage());
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		//this.setAlway	sOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);
		this.setVisible(true);
	}
	
	public void irAPantalla(String nombrePantalla) {
		
	this.pantallaActual.setVisible(false);
	this.pantallaActual=null;
	switch(nombrePantalla) {
	case "login":
		this.pantallaActual=new PantallaLogin(this);
		break;
	case "registro":
		this.pantallaActual=new PantallaRegistro(this);
		break;
	case "listarUsuarios":
		this.pantallaActual=new PantallaListarUsuario(this);
		
		break;
	case "seleccion":
		this.pantallaActual=new PantallaEleccion(this);
		break;
	case "comida":
		this.pantallaActual=new PantallaComida(this);
		break;
	case "cuidado":
		this.pantallaActual=new PantallaCuidado(this);
		break;
	case "destino":
		this.pantallaActual=new PantallaDestino(this);
		break;
	case "usuario":
		this.pantallaActual=new PantallaUsuario(this);
		break;
	}
	
	
	this.pantallaActual.setVisible(true);
	this.setContentPane(pantallaActual);
		
	}
}
