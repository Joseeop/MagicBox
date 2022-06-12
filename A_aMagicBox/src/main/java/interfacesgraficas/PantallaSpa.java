package interfacesgraficas;

import javax.swing.JPanel;

import componentesvisuales.BotonEleccion;

import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * clase que hereda de JPanel, cuya función es mostrar al usuario las posibilidades que tiene antes de realizar el sorteo
 * y conocer su destino final
 * @author José Oña Pineda
 *
 */
public class PantallaSpa extends JPanel {
	
	private Ventana ventana;
	
	/**
	 * ArrayList donde iremos ingresando las preferencias del usuario según los seleccione.
	 */
	private ArrayList<String> listaSpa = new ArrayList<String>();
	
	
	/**
	 * Constructor de clase ventana que recibe por parámetros las propiedades heredadas en la que incluimos la funcionalidad de la misma
	 * @param Ventana que recibe y construye por argumentos
	 */
	public PantallaSpa (Ventana v, String ruta) {
		this.ventana=v;
		setLayout(null);
		
		JLabel labelCarratraca = new JLabel("Carratraca");
		labelCarratraca.setIcon(new ImageIcon(PantallaSpa.class.getResource("/imagenes/spaCarratracaIcono.jpg")));
		labelCarratraca.setBounds(134, 284, 204, 155);
		add(labelCarratraca);
		
		JLabel labelHammam = new JLabel("Hammam");
		labelHammam.setIcon(new ImageIcon(PantallaSpa.class.getResource("/imagenes/HammamIcono.jpg")));
		labelHammam.setBounds(249, 98, 204, 155);
		add(labelHammam);
		
		JLabel labelBenahavis = new JLabel("Benahavis");
		labelBenahavis.setIcon(new ImageIcon(PantallaSpa.class.getResource("/imagenes/spaBenahavisIcono.jpg")));
		labelBenahavis.setBounds(22, 98, 204, 155);
		add(labelBenahavis);
		
		
		/**
		 * Botón 1
		 */
		BotonEleccion botonHammam;
		botonHammam = new BotonEleccion("Hammam");
		botonHammam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaSpa.contains("Hammam")) {
							listaSpa.add("Hammam");
						}else {
							listaSpa.remove("Hammam");
						}
			
			}
		});
		botonHammam.setText("Hammam");
		botonHammam.setBounds(261, 254, 160, 23);
		add(botonHammam);
		
		/**
		 * Botón 2
		 */
		BotonEleccion botonBenahavis = new BotonEleccion("Benahavis");
		botonBenahavis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaSpa.contains("Benahavis")) {
							listaSpa.add("Benahavis");
						}else {
							listaSpa.remove("Benahavis");
						}
			
			}
		});
		botonBenahavis.setText("Benahavis");
		botonBenahavis.setBounds(35, 254, 160, 23);
		add(botonBenahavis);
		/**
		 * Botón 3
		 */
		BotonEleccion botonCarratraca = new BotonEleccion("Carratraca");
		botonCarratraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaSpa.contains("Carratraca")) {
							listaSpa.add("Carratraca");
						}else {
							listaSpa.remove("Carratraca");
						}
			
			}
		});
		botonCarratraca.setText("Carratraca");
		botonCarratraca.setBounds(155, 442, 160, 23);
		add(botonCarratraca);
		

		
		JLabel labelImagenCuidado = new JLabel("New label");
		labelImagenCuidado.setIcon(new ImageIcon(PantallaSpa.class.getResource("/imagenes/facial.png")));
		labelImagenCuidado.setBounds(532, 0, 268, 500);
		add(labelImagenCuidado);
		
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
				if(!listaSpa.isEmpty()) {
					
					 int destinoAleatorio = (int)Math.floor(Math.random()*(listaSpa.size()-1-0+1)+0);
					
					 destinoFinal=		listaSpa.get(destinoAleatorio);
					 
					 System.out.println(destinoFinal);
				
				
				}
				

				if(destinoFinal.equals("Carratraca")) {
					
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/spaCarratracaG.jpg");
					
				}
				if(destinoFinal.equals("Benahavis")) {
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/spaBenahavisG.jpg");
					
				}
				if(destinoFinal.equals("Hammam")) {
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/HammamG.jpg");
					
				}
				
				ventana.irAPantalla("destinoFinal",destinoFinal,imagenDestino);
				
				
				
				
				
				
			}
		});
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(205, 0, 122, 35);
		add(botonSorteo);
		
	
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaSpa.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
		
	}
}
