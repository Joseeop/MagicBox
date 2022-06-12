package interfacesgraficas;

import javax.swing.JPanel;

import clases.Comidas;
import componentesvisuales.BotonEleccion;
import excepciones.OpcionesMaximasException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Pantalla en la que seleccionaremos nuestras opciones preferidas para almuerzos, se hará 
 * un sorteo entre nuestros seleccionados y posteriormente se lo pasaremos mediante parámetros 
 * a PantallaDestinoFinal
 * @author Spanys
 *
 */
public class PantallaAlmuerzo extends JPanel {
	
	/**
	 * Variable de tipo ventana que nos permitirá navegar entre éstas.
	 */
	private Ventana ventana;
	/**
	 * ArrayList que nos alamacerá los almuerzos una vez los vamos agregando a nuestras opciones preferentes.
	 */
	private ArrayList<String> listaAlmuerzo = new ArrayList<String>();
	

	/**
	 * Constructor de clase ventana que recibe por parámetros las propiedades heredadas en la que incluimos la funcionalidad de la misma
	 * @param Ventana que recibe y construye por argumentos la ventana y la ruta
	 */
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
						}else {
							listaAlmuerzo.remove("Tercer Acto");
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
						}else {
							listaAlmuerzo.remove("Refectorium");
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
						}else {
							listaAlmuerzo.remove("Soca");
						}
			
			}
		});
		botonSoca.setText("Soca");
		botonSoca.setBounds(288, 205, 160, 23);
		add(botonSoca);
		
		
		final JButton botonOleo = new BotonEleccion("Oleo");
		botonOleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaAlmuerzo.contains("Oleo")) {
							listaAlmuerzo.add("Oleo");
						}else {
							listaAlmuerzo.remove("Oleo");
						}
						if(listaAlmuerzo.size()>3) {
							botonOleo.setSelected(false);
						}
			
			}
		});
		botonOleo.setBounds(62, 205, 160, 23);
		ButtonGroup grupo =new ButtonGroup();
		grupo.add(botonOleo);
		grupo.add(botonSoca);
		grupo.add(botonRefectorium);
		grupo.add(botonOleo);
		
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
		
		
		/**
		 * Label que nos hará navegar a la pantalla selección.
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
				if(!listaAlmuerzo.isEmpty()/*&&listaAlmuerzo.size()<4*/) {
					
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
				
				
			
			}
		});
		
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(209, 435, 122, 35);
		add(botonSorteo);
		
		final MusicaFondo musica= new MusicaFondo(new File("./musica/miGranNoche.wav"));
		musica.start();
		
		JLabel botonMute = new JLabel("New label");
		botonMute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Parar música
			}
		});
		botonMute.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/mute.png")));
		botonMute.setBounds(415, 11, 60, 53);
		add(botonMute);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaAlmuerzo.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
	}
}
