package interfacesgraficas;

import java.awt.Cursor;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Comidas;
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
	protected Comidas restaurante;
	public Ventana(String[] args) {
		
		
		
		this.setSize(800,500); //500,400
		this.setLocationRelativeTo(null);
		
		//Pantalla completa las dos lineas siguentes
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		this.setTitle("MAGIC BOX");
		this.setIconImage(new ImageIcon("./iconos/iconoVentana.png").getImage());
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		//this.setAlway	sOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		if (args.length > 0) {
            String email = args[0];
            String contraseña = args[1];
            try {
                usuarioLogado = new Usuario(email, contraseña);

                JOptionPane.showMessageDialog(this, "Bienvenid@ " + usuarioLogado.getNombre(),
                        "Inicio de sesion con éxito ", JOptionPane.INFORMATION_MESSAGE);
                this.pantallaActual = new PantallaEleccion(this);

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                this.pantallaActual = new PantallaLogin(this);
            }
        } else {
            this.pantallaActual = new PantallaLogin(this);
        }


    
		
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
	case "informacion":
		this.pantallaActual=new PantallaInformacion(this);
		break;
	}
	
	
	this.pantallaActual.setVisible(true);
	this.setContentPane(pantallaActual);
		
	}
	public void irAPantalla(String nombrePantalla,String ruta) {

		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch(nombrePantalla) {
		
		case "cena":
			this.pantallaActual=new PantallaCena(this,ruta);
			break;
		case "almuerzo":
			this.pantallaActual=new PantallaAlmuerzo(this, ruta);
			break;
		case "masaje":
			this.pantallaActual=new PantallaMasaje(this,ruta);
			break;
		case "spa":
			this.pantallaActual=new PantallaSpa(this,ruta);
			break;
		case "tratamiento":
			this.pantallaActual=new PantallaTratamiento(this,ruta);
			break;
		
		
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
		}
	
	/**
	 * Función para ir a la pantalla final del sorteo a la que pasaremos todos los datos de la elección ganadora.
	 * @param nombrePantalla
	 * @param destinoFinal
	 * @param imagenDestino
	 */
	public void irAPantalla(String nombrePantalla,String destinoFinal,ImageIcon imagenDestino) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch(nombrePantalla) {
		
		case "destinoFinal":
			this.pantallaActual=new PantallaDestinoFinal(this,destinoFinal,imagenDestino);
			break;
		
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	}

}
