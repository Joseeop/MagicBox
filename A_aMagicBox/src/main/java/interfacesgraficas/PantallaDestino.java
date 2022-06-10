package interfacesgraficas;

import javax.swing.JPanel;

import componentesvisuales.BotonEleccion;
import componentesvisuales.BotonLogin;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import enumeraciones.TipoCuidado;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaDestino extends JPanel {
	
	/**
	 * ArrayList que nos alamacerá los destinos una vez los vamos agregando a nuestras opciones preferentes.
	 */
	private ArrayList<String> listaPaises = new ArrayList<String>();
	private Ventana ventana;
	
	public PantallaDestino (Ventana v) {
		
		this.ventana=v;
		setLayout(null);
		/**
		 *  Label que nos lleva a la pantalla información donde explicamos el funcionamiento del sorteo
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
		
		JLabel labelImagenDestino = new JLabel("New label");
		labelImagenDestino.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/viajar.png")));
		labelImagenDestino.setBounds(508, 0, 292, 500);
		add(labelImagenDestino);
		/**
		 * label con evento que nos vuelve a la pantalla selección.
		 */
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
		
		
		
		JLabel logoRoma = new JLabel("ROMA");
		logoRoma.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/coliseo.png")));
		logoRoma.setBounds(82, 11, 160, 120);
		add(logoRoma);
		
		JLabel logoParis = new JLabel("PARIS");
		logoParis.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/torre-eiffel.png")));
		logoParis.setBounds(300, 11, 160, 120);
		add(logoParis);
		
		JLabel logoLondres = new JLabel("LONDRES");
		logoLondres.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/puente-de-londres.png")));
		logoLondres.setBounds(82, 142, 160, 120);
		add(logoLondres);
		
		JLabel logoCope = new JLabel("COPE");
		logoCope.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/copenhague.png")));
		logoCope.setBounds(300, 142, 160, 120);
		add(logoCope);
		
		JLabel logoBruselas = new JLabel("BRUSELAS");
		logoBruselas.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/atomium.png")));
		logoBruselas.setBounds(82, 282, 160, 120);
		add(logoBruselas);
		
		JLabel logoAmsterdam = new JLabel("AMSTERDAM");
		logoAmsterdam.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/amsterdam.png")));
		logoAmsterdam.setBounds(300, 282, 160, 120);
		add(logoAmsterdam);
		


		
		
		/**
		 * Botón Roma, le añadimos un evento para agregarlo a la lista de paises seleccionados.
		 */
		JButton botonRoma = new BotonEleccion("Roma");
		botonRoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaPaises.contains("Roma")) {
							listaPaises.add("Roma");
						}
			//Cambiar el color.
			}
		});
		botonRoma.setBounds(92, 122, 150, 23);
		add(botonRoma);
		
	
		/**
		 * Botón parís, le añadimos un evento para agregarlo a la lista de paises seleccionados.
		 */
		JButton botonParis = new BotonEleccion("Paris");
		botonParis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaPaises.contains("Paris")) {
							listaPaises.add("Paris");
						}
			//Cambiar el color.
			}
		});
		botonParis.setBounds(300, 132, 150, 23);
		add(botonParis);
		
		
		/**
		 * Botón Londres, le añadimos un evento para agregarlo a la lista de paises seleccionados.
		 */
		JButton botonLondres = new BotonEleccion("Londres");
		botonLondres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaPaises.contains("Londres")) {
							listaPaises.add("Londres");
						}
			//Cambiar el color.
			}
		});
		botonLondres.setBounds(82, 259, 160, 23);
		add(botonLondres);
		/**
		 * Botón Copenhague, le añadimos un evento para agregarlo a la lista de paises seleccionados.
		 */
		JButton botonCope = new BotonEleccion("Copenhague");
		botonCope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaPaises.contains("Copenhague")) {
							listaPaises.add("Copenhague");
						}
			//Cambiar el color.
			}
		});
		botonCope.setFont(new Font("Roboto Black", Font.BOLD, 13));
		botonCope.setBounds(300, 259, 160, 23);
		add(botonCope);
		/**
		 * Botón Bruselas, le añadimos un evento para agregarlo a la lista de paises seleccionados.
		 */
		JButton botonBruselas = new BotonEleccion("Bruselas");
		botonBruselas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaPaises.contains("Bruselas")) {
							listaPaises.add("Bruselas");
						}
			
			}
		});
		botonBruselas.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonBruselas.setBounds(92, 402, 150, 23);
		add(botonBruselas);
		
		/**
		 * Botón Amsterdam, le añadimos un evento para agregarlo a la lista de paises seleccionados.
		 */
		JButton botonAmsterdam = new BotonEleccion("Amsterdam");
		botonAmsterdam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaPaises.contains("Amsterdam")) {
							listaPaises.add("Amsterdam");
						}
			
			}
		});
		botonAmsterdam.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonAmsterdam.setBounds(310, 402, 150, 23);
		add(botonAmsterdam);
		
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
				if(!listaPaises.isEmpty()) {
					
					 int destinoAleatorio = (int)Math.floor(Math.random()*(listaPaises.size()-1-0+1)+0);
					
					 destinoFinal=		listaPaises.get(destinoAleatorio);
					 
					 System.out.println(destinoFinal);
				
				
				}
				

				if(destinoFinal.equals("Roma")) {
					
					
					imagenDestino=new ImageIcon("./iconos/Destinos/roma.jpg");
					
				}
				if(destinoFinal.equals("Paris")) {
					
					imagenDestino=new ImageIcon("./iconos/Destinos/paris.jpg");
					
				}
				if(destinoFinal.equals("Londres")) {
					
					imagenDestino=new ImageIcon("./iconos/Destinos/viena.jpg");
					
				}
				if(destinoFinal.equals("Copenhague")) {
					
					imagenDestino=new ImageIcon("./iconos/Destinos/copenhague.jpg");
					
				}
				if(destinoFinal.equals("Amsterdam")) {
					
					imagenDestino=new ImageIcon("./iconos/Destinos/amsterdam.jpg");
					
				}
				if(destinoFinal.equals("Bruselas")) {
					
					imagenDestino=new ImageIcon("./iconos/Destinos/bruselas.jpg");
					
				}
				
				ventana.irAPantalla("destinoFinal",destinoFinal,imagenDestino);
				
				//destinofinal pantalla (destinoFinal,imagenDestino)
				
				
				
				
			}
		});
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(205, 0, 122, 35);
		add(botonSorteo);
		
		JLabel labelFondo = new JLabel("FONDO");
		labelFondo.setIcon(new ImageIcon(PantallaDestino.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
	}
}
