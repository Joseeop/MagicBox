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

public class PantallaMasaje extends JPanel {
	
	private Ventana ventana;
	/**
	 * arraylist donde ingresaremos las opciones de masajes mientras el usuario los va seleccionando.
	 */
	private ArrayList<String> listaMasaje = new ArrayList<String>();
	

	/**
	 * Constructor de clase ventana que recibe por parámetros las propiedades heredadas en la que incluimos la funcionalidad de la misma
	 * @param Ventana que recibe y construye por argumentos
	 */
	public PantallaMasaje (Ventana v,String ruta) {
		this.ventana=v;
		setLayout(null);
		
		JLabel labelAcupresion = new JLabel("acupresion");
		labelAcupresion.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/acupresionIcono.jpg")));
		labelAcupresion.setBounds(144, 288, 204, 155);
		add(labelAcupresion);
		
		JLabel labelMasaje1 = new JLabel("geotermal");
		labelMasaje1.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/acupunturaIcono.jpg")));
		labelMasaje1.setBounds(243, 99, 204, 155);
		add(labelMasaje1);
		
		JLabel labelGeotermal = new JLabel("Geotermal");
		labelGeotermal.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/geotermalIcono.jpg")));
		labelGeotermal.setBounds(29, 99, 204, 155);
		add(labelGeotermal);
		
		/**Dentro de cada uno de los botones añadimos un evento para ingresarlos en el arraylist si ya no lo están.
		 * Botón 1
		 */
		BotonEleccion botonAcupuntura;
		botonAcupuntura = new BotonEleccion("acupuntura");
		botonAcupuntura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaMasaje.contains("acupuntura")) {
							listaMasaje.add("acupuntura");
						}else {
							listaMasaje.remove("acupuntura");
						}
			
			}
		});
		botonAcupuntura.setText("Acupuntura");
		botonAcupuntura.setBounds(261, 254, 160, 23);
		add(botonAcupuntura);
		
		/**
		 * Botón 2
		 */
		BotonEleccion botonGeotermal = new BotonEleccion("geotermal");
		botonGeotermal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaMasaje.contains("geotermal")) {
							listaMasaje.add("geotermal");
						}else {
							listaMasaje.remove("geotermal");
						}
			
			}
		});
		botonGeotermal.setText("Geotermal");
		botonGeotermal.setBounds(35, 254, 160, 23);
		add(botonGeotermal);
		/**
		 * Botón 3
		 */
		BotonEleccion botonAcupresion = new BotonEleccion("acupresion");
		botonAcupresion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaMasaje.contains("acupresion")) {
							listaMasaje.add("acupresion");
						}else {
							listaMasaje.remove("acupresion");
						}
			
			}
		});
		botonAcupresion.setText("Acupresion");
		botonAcupresion.setBounds(154, 444, 160, 23);
		add(botonAcupresion);
		

		
		JLabel labelImagenCuidado = new JLabel("New label");
		labelImagenCuidado.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/facial.png")));
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
				if(!listaMasaje.isEmpty()) {
					
					 int destinoAleatorio = (int)Math.floor(Math.random()*(listaMasaje.size()-1-0+1)+0);
					
					 destinoFinal=		listaMasaje.get(destinoAleatorio);
					 
					 System.out.println(destinoFinal);
				
				
				}
				

				if(destinoFinal.equals("acupresion")) {
					
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/acupresionG.jpg");
					
				}
				if(destinoFinal.equals("geotermal")) {
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/geotermalG.jpg");
					
				}
				if(destinoFinal.equals("acupuntura")) {
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/acupunturaG.jpg");
					
				}

				
				ventana.irAPantalla("destinoFinal",destinoFinal,imagenDestino);
				
				//destinofinal pantalla (destinoFinal,imagenDestino)
				
				
				
				
			}
		});
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(205, 0, 122, 35);
		add(botonSorteo);
		
	
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
	}

}
