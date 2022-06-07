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

public class PantallaAlmuerzo extends JPanel {
	
	private Ventana ventana;
	/**
	 * ArrayList que nos alamacerá los almuerzos una vez los vamos agregando a nuestras opciones preferentes.
	 */
	private ArrayList<String> listaAlmuerzo = new ArrayList<String>();
	
	public PantallaAlmuerzo(Ventana v, String ruta) {
		this.ventana=v;
		setLayout(null);
		
		
		/**
		  * Agregamos los 4 botones de las 4 opciones posibles.En cada uno de ellos comprobaremos mediante un if si ya se encuentran
		 * en nuestro arraylist, si no es así lo agregaremos.
		 */
		
		BotonEleccion botonTercerActo = new BotonEleccion("Tercer Acto");
		botonTercerActo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaAlmuerzo.contains("Tercer Acto")) {
							listaAlmuerzo.add("Tercer Acto");
						}
			
			}
		});
		botonTercerActo.setText("Tercer Acto");
		botonTercerActo.setBounds(62, 401, 160, 23);
		add(botonTercerActo);
		
		BotonEleccion botonRefectorium = new BotonEleccion("Refectorium");
		botonRefectorium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaAlmuerzo.contains("Refectorium")) {
							listaAlmuerzo.add("Refectorium");
						}
			
			}
		});
		botonRefectorium.setText("Refectorium");
		botonRefectorium.setBounds(288, 401, 160, 23);
		add(botonRefectorium);
		
		BotonEleccion botonSoca = new BotonEleccion("Soca");
		botonSoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaAlmuerzo.contains("Soca")) {
							listaAlmuerzo.add("Soca");
						}
			
			}
		});
		botonSoca.setText("Soca");
		botonSoca.setBounds(288, 205, 160, 23);
		add(botonSoca);
		
		
		JButton botonOleo = new BotonEleccion("Oleo");
		botonOleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaAlmuerzo.contains("Oleo")) {
							listaAlmuerzo.add("Oleo");
						}
			
			}
		});
		botonOleo.setBounds(62, 205, 160, 23);
		add(botonOleo);

		/**
		 * Logo lateral de la pantalla
		 */
		JLabel labelIcono = new JLabel("New label");
		labelIcono.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/dinning-table.png")));
		labelIcono.setBounds(516, 0, 284, 500);
		add(labelIcono);
		
		/**
		 * Agregamos los logos de cada opción(4).
		 */
		
		JLabel logoOleo = new JLabel("OLEO");
		logoOleo.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/oleoLogo.jpg")));
		logoOleo.setBounds(62, 85, 160, 120);
		add(logoOleo);

		
		
		JLabel logoSoca = new JLabel("SOCA");
		logoSoca.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/socaLogo.png")));
		logoSoca.setBounds(288, 85, 160, 120);
		add(logoSoca);
		
		JLabel logoTercerActo = new JLabel("TERCER ACTO");
		logoTercerActo.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/tercerActoLogo.png")));
		logoTercerActo.setBounds(62, 281, 160, 120);
		add(logoTercerActo);
		
		JLabel logoRefectorium = new JLabel("REFECTORIUM");
		logoRefectorium.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/elRefectorium.png")));
		logoRefectorium.setBounds(288, 281, 160, 120);
		add(logoRefectorium);
		
		
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
		labelInformacion.setBounds(10, 412, 60, 53);
		add(labelInformacion);
		
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
				if(!listaAlmuerzo.isEmpty()) {
					
					 int destinoAleatorio = (int)Math.floor(Math.random()*(listaAlmuerzo.size()-1-0+1)+0);
					
					 destinoFinal=		listaAlmuerzo.get(destinoAleatorio);
					 
					 System.out.println(destinoFinal);
				
				
				}
				

				if(destinoFinal.equals("Oleo")) {
					
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/oleo.jpg");
					
				}
				if(destinoFinal.equals("Soca")) {
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/Soca.png");
					
				}
				if(destinoFinal.equals("Refectorium")) {
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/refectorium.png");
					
				}
				if(destinoFinal.equals("Tercer Acto")) {
					
					imagenDestino=new ImageIcon("./iconos/Restaurantes/Tercer_Acto.jpeg");
					
				}

				
				ventana.irAPantalla("destinoFinal",destinoFinal,imagenDestino);
				
				//destinofinal pantalla (destinoFinal,imagenDestino)
				
				
				
				
			}
		});
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(209, 435, 122, 35);
		add(botonSorteo);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
	}
}
