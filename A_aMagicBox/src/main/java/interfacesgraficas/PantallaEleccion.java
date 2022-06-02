package interfacesgraficas;

import javax.swing.JPanel;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextField;

import componentesvisuales.BotonAzul;
import componentesvisuales.BotonLogin;
import componentesvisuales.BotonSalir;
import componentesvisuales.BotonVerde;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PantallaEleccion extends JPanel {
	
	private Ventana ventana;
	
	
	public PantallaEleccion(Ventana v) {
		this.ventana=v;

		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel labelEleccion = new JLabel("ELIGE EXPERIENCIA");
		labelEleccion.setBounds(146, 65, 278, 23);
		labelEleccion.setForeground(new Color(112, 128, 144));
		labelEleccion.setFont(new Font("Roboto Black", Font.BOLD, 27));
		add(labelEleccion);
		
		JButton botonComidas = new BotonLogin("Comidas");
		botonComidas.setBounds(373, 264, 139, 39);
		botonComidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("comida");
			}
		});
		add(botonComidas);
		
		JButton botonCuidados = new BotonLogin("Cuidados");
		botonCuidados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonCuidados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("cuidado");
			}
		});
		botonCuidados.setBounds(36, 264, 134, 39);
		add(botonCuidados);
		
		JButton botonViajes = new BotonLogin("Viajes");
		botonViajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("destino");
			}
		});
		botonViajes.setBounds(205, 264, 134, 39);
		add(botonViajes);
		
		JButton botonUsuario = new BotonLogin("Bienvenid@ "+ventana.usuarioLogado.getNombre());
		botonUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("usuario");
			}
		});
		botonUsuario.setBounds(496, 0, 304, 23);
		add(botonUsuario);
		
		JButton botonIrLogin = new BotonSalir("Logout");
		botonIrLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonIrLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		botonIrLogin.setBounds(0, 439, 89, 23);
		add(botonIrLogin);
		
		
		JLabel labelIcono = new JLabel("New label");
		labelIcono.setIcon(new ImageIcon(PantallaEleccion.class.getResource("/imagenes/IconoVentana.png")));
		labelIcono.setBounds(522, 0, 278, 500);
		add(labelIcono);
		
		
		JLabel labelIconoviaje = new JLabel("New label");
		labelIconoviaje.setIcon(new ImageIcon(PantallaEleccion.class.getResource("/imagenes/equipaje-de-viaje.png")));
		labelIconoviaje.setBounds(221, 177, 95, 76);
		add(labelIconoviaje);
		
		JLabel labelIconoComida = new JLabel("New label");
		labelIconoComida.setIcon(new ImageIcon(PantallaEleccion.class.getResource("/imagenes/restaurante.png")));
		labelIconoComida.setBounds(387, 177, 95, 76);
		add(labelIconoComida);
		
		
		JLabel labelIconoCuidado = new JLabel("");
		labelIconoCuidado.setIcon(new ImageIcon(PantallaEleccion.class.getResource("/imagenes/tratamiento-de-belleza (1).png")));
		labelIconoCuidado.setBounds(53, 171, 95, 82);
		add(labelIconoCuidado);
	
		
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaEleccion.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
	
		

	}
}
/*try {

// Se obtiene un Clip de sonido
Clip sonido = AudioSystem.getClip();

// Se carga con un fichero wav
sonido.open(AudioSystem.getAudioInputStream(new File("./musica/DARK VALLEY.wav")));

// Comienza la reproducción
sonido.start();

// Espera mientras se esté reproduciendo.
while (sonido.isRunning())
    Thread.sleep(1000);

// Se cierra el clip.
sonido.close();
} catch (Exception e) {
System.out.println("" + e);
}

*/	

