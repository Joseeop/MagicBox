package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
/**
 * Clase que nos mostrará los datos del usuario que actualmente está logueado en el programa.
 * @author Spanys
 *
 */
public class PantallaUsuario extends JPanel{
	
	private Ventana ventana;
	/**
	 * Constructor de clase ventana que recibe por parámetros las propiedades heredadas en la que incluimos la funcionalidad de la misma
	 * @param Ventana que recibe y construye por argumentos
	 */
	public PantallaUsuario(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel botonAtras = new JLabel("New label");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("seleccion");
			}
		});
	
		
		JLabel labelNombre = new JLabel("Nombre: "+ventana.usuarioLogado.getNombre());
		labelNombre.setForeground(new Color(112, 128, 144));
		labelNombre.setFont(new Font("Roboto Black", Font.BOLD, 11));
		labelNombre.setBounds(98, 166, 301, 25);
		add(labelNombre);
		
		JLabel labelPais = new JLabel("País: "+ventana.usuarioLogado.getPais().toString());
		labelPais.setForeground(new Color(112, 128, 144));
		labelPais.setFont(new Font("Roboto Black", Font.BOLD, 11));
		labelPais.setBounds(98, 238, 224, 25);
		add(labelPais);
		
		JLabel labelEmail = new JLabel("Email: "+ventana.usuarioLogado.getEmail());
		labelEmail.setFont(new Font("Roboto Black", Font.BOLD, 11));
		labelEmail.setForeground(new Color(112, 128, 144));
		labelEmail.setBounds(98, 202, 301, 25);
		add(labelEmail);
		
		JLabel labelUsuarioImagen = new JLabel("New label");
		labelUsuarioImagen.setIcon(new ImageIcon(PantallaUsuario.class.getResource("/imagenes/usuario.png")));
		labelUsuarioImagen.setBounds(516, 0, 284, 500);
		add(labelUsuarioImagen);
		
		JLabel labelVolver = new JLabel("New label");
		labelVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("seleccion");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		labelVolver.setIcon(new ImageIcon(PantallaUsuario.class.getResource("/imagenes/iconoVentanaInicio.png")));
		labelVolver.setBounds(0, 0, 60, 53);
		add(labelVolver);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaUsuario.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
	
		
	
		
	}
}
