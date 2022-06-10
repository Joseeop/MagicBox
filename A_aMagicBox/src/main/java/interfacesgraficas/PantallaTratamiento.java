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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PantallaTratamiento extends JPanel {
	
	private Ventana ventana;
	private ArrayList<String> listaTratamiento = new ArrayList<String>();
	
	public PantallaTratamiento(Ventana v, String ruta) {
		
		this.ventana=v;
		setLayout(null);
		
		JLabel labelRadiofrecuencia = new JLabel("radiofrecuencia");
		labelRadiofrecuencia.setIcon(new ImageIcon(PantallaTratamiento.class.getResource("/imagenes/radiofrecuencia.jpg")));
		labelRadiofrecuencia.setBounds(137, 273, 204, 155);
		add(labelRadiofrecuencia);
		
		JLabel labellifting = new JLabel("LIFTING");
		labellifting.setIcon(new ImageIcon(PantallaTratamiento.class.getResource("/imagenes/lifting.jpg")));
		labellifting.setBounds(241, 84, 204, 155);
		add(labellifting);
		
		JLabel labelPeeling = new JLabel("peeling");
		labelPeeling.setIcon(new ImageIcon(PantallaTratamiento.class.getResource("/imagenes/peeling.jpg")));
		labelPeeling.setBounds(20, 84, 204, 155);
		add(labelPeeling);
		/**
		 * Botón 1
		 */
		BotonEleccion botonLifting;
		botonLifting = new BotonEleccion("lifting");
		botonLifting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaTratamiento.contains("lifting")) {
							listaTratamiento.add("lifting");
						}else {
							listaTratamiento.remove("lifting");
						}
			
			}
		});
		botonLifting.setText("lifting");
		botonLifting.setBounds(269, 250, 160, 23);
		add(botonLifting);
		
		/**
		 * Botón 2
		 */
		BotonEleccion botonPeeling = new BotonEleccion("peeling");
		botonPeeling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaTratamiento.contains("peeling")) {
							listaTratamiento.add("peeling");
						}else {
							listaTratamiento.remove("peeling");
						}
			
			}
		});
		botonPeeling.setText("peeling");
		botonPeeling.setBounds(45, 250, 160, 23);
		add(botonPeeling);
		/**
		 * Botón 3
		 */
		BotonEleccion botonRadiofrecuencia = new BotonEleccion("radiofrecuencia");
		botonRadiofrecuencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
						if(!listaTratamiento.contains("radiofrecuencia")) {
							listaTratamiento.add("radiofrecuencia");
						}else {
							listaTratamiento.remove("radiofrecuencia");
						}
			
			}
		});
		botonRadiofrecuencia.setText("radiofrecuencia");
		botonRadiofrecuencia.setBounds(159, 428, 160, 23);
		add(botonRadiofrecuencia);
		
	
		JLabel labelImagenCuidado = new JLabel("New label");
		labelImagenCuidado.setIcon(new ImageIcon(PantallaTratamiento.class.getResource("/imagenes/facial.png")));
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
				if(!listaTratamiento.isEmpty()) {
					
					 int destinoAleatorio = (int)Math.floor(Math.random()*(listaTratamiento.size()-1-0+1)+0);
					
					 destinoFinal=		listaTratamiento.get(destinoAleatorio);
					 
					 System.out.println(destinoFinal);
				
				
				}
				

				if(destinoFinal.equals("peeling")) {
					
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/peeling.jpg");
					
				}
				if(destinoFinal.equals("radiofrecuencia")) {
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/radiofrecuencia.jpg");
					
				}
				if(destinoFinal.equals("lifting")) {
					
					imagenDestino=new ImageIcon("./iconos/Cuidados/lifting.jpg");
					
				}

				
				ventana.irAPantalla("destinoFinal",destinoFinal,imagenDestino);
				
				//destinofinal pantalla (destinoFinal,imagenDestino)
				
				
				
				
			}
		});
		botonSorteo.setFont(new Font("Roboto Black", Font.BOLD, 15));
		botonSorteo.setBounds(205, 0, 122, 35);
		add(botonSorteo);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaTratamiento.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
	}
}
