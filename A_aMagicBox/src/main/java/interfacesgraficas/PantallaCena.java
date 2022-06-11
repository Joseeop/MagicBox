package interfacesgraficas;

import javax.swing.JPanel;

import clases.Comidas;
import componentesvisuales.BotonEleccion;

import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *  * Pantalla en la que seleccionaremos nuestras opciones preferidas para cenes, se hará 
 * un sorteo entre nuestros seleccionados y posteriormente se lo pasaremos mediante parámetros 
 * a PantallaDestinoFinal
 * @author José Oña
 *
 */
public class PantallaCena extends JPanel {
	
	private Ventana ventana;
	/**
	 * ArrayList que nos alamacerá las cenas una vez las vamos agregando a nuestras opciones preferentes.
	 */
	private ArrayList<String> listaCena = new ArrayList<String>();
	
	public PantallaCena(Ventana v, String ruta) {
		this.ventana=v;
		setLayout(null);
		
		JLabel logoVerum = new JLabel("Verum");
		
		/**
		 * Agregamos logos de cada opción(4).
		 */
		logoVerum.setIcon(new ImageIcon(PantallaCena.class.getResource("/imagenes/VerumLogo.jpg")));
		logoVerum.setBounds(89, 29, 160, 120);
		add(logoVerum);
		

		
		JLabel logoAtrezzo = new JLabel("Atrezzo");
		logoAtrezzo.setIcon(new ImageIcon(PantallaCena.class.getResource("/imagenes/logo-Atrezzo.png")));
		logoAtrezzo.setBounds(329, 29, 160, 120);
		add(logoAtrezzo);
		
		JLabel logoTiki = new JLabel("Tiki");
		logoTiki.setIcon(new ImageIcon(PantallaCena.class.getResource("/imagenes/tiki-logo.jpg")));
		logoTiki.setBounds(89, 257, 160, 120);
		add(logoTiki);
		
		JLabel logoSole = new JLabel("LaSole");
		logoSole.setIcon(new ImageIcon(PantallaCena.class.getResource("/imagenes/LaSole.png")));
		logoSole.setBounds(329, 245, 160, 120);
		add(logoSole);
		
		
		/**
		 * Agregamos los 4 botones de las 4 opciones posibles.En cada uno de ellos comprobaremos mediante un if si ya se encuentran
		 * en nuestro arraylist, si no es así lo agregaremos.
		 */
		BotonEleccion botonTiki = new BotonEleccion("Tiki");
		botonTiki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaCena.contains("Tiki")) {
							listaCena.add("Tiki");
						}
			
			}
		});
		botonTiki.setText("Tiki");
		botonTiki.setBounds(89, 376, 160, 23);
		add(botonTiki);
		
		BotonEleccion botonSole = new BotonEleccion("LaSole");
		botonSole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaCena.contains("LaSole")) {
							listaCena.add("LaSole");
						}
			
			}
		});
		botonSole.setText("La Sole");
		botonSole.setBounds(329, 376, 160, 23);
		add(botonSole);
		
		BotonEleccion botonAtrezzo = new BotonEleccion("Atrezzo");
		botonAtrezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaCena.contains("Atrezzo")) {
							listaCena.add("Atrezzo");
						}
			
			}
		});
		botonAtrezzo.setText("Atrezzo");
		botonAtrezzo.setBounds(329, 150, 160, 23);
		add(botonAtrezzo);
		
		
		JButton botonVerum = new BotonEleccion("Verum");
		botonVerum.setText("Verum");
		botonVerum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaCena.contains("Verum")) {
							listaCena.add("Verum");
						}
			
			}
		});
		botonVerum.setBounds(89, 150, 160, 23);
		add(botonVerum);
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(PantallaCena.class.getResource("/imagenes/dinning-table.png")));
		lblNewLabel_4.setBounds(516, 0, 284, 500);
		add(lblNewLabel_4);
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
		
		
		/**
		 * Botón encargado de, una vez seleccionados todos los destinos preferentes y añadidos al ArrayList
		 * generará un destino aleatorio y lo igualará al destino final. Más adelante comprobará ese destino final
		 * y le asignará una imagen. Finalmente le pasaremos a la PantallaDestinoFinal los argumentos 
		 * destinoFinal(nombre ganador) e imagenDestino (foto del lugar ganador)
		 */
		JButton botonSorteo = new BotonEleccion("SORTEO");
		botonSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String destinoFinal="";
				ImageIcon imagenDestino = null;
				if(!listaCena.isEmpty()) {
					
					 int destinoAleatorio = (int)Math.floor(Math.random()*(listaCena.size()-1-0+1)+0);
					
					 destinoFinal=		listaCena.get(destinoAleatorio);
					 
					 System.out.println(destinoFinal);
				
				
				}
				

				if(destinoFinal.equals("Verum")) {
					
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/Verum.jpg");
					
				}
				if(destinoFinal.equals("Tiki")) {
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/tiki.jpg");
					
				}
				if(destinoFinal.equals("LaSole")) {
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/sole.png");
					
				}
				if(destinoFinal.equals("Atrezzo")) {
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/atrezzo.jpeg");
					
				}

				
				ventana.irAPantalla("destinoFinal",destinoFinal,imagenDestino);
				
				//destinofinal pantalla (destinoFinal,imagenDestino)
				
				
				
				
			}
		});
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(232, 410, 122, 35);
		add(botonSorteo);
		
		/**
		 * Label que nos lleva a la pantalla información donde explicamos el funcionamiento del sorteo
		 */
		JLabel labelInformacion = new JLabel("New label");
		labelInformacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("informacion");
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
		

		labelInformacion.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/informacion.png")));
		labelInformacion.setBounds(12, 388, 60, 53);
		add(labelInformacion);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaCena.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
	}

}
