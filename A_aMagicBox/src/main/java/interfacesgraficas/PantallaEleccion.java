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
import componentesvisuales.BotonVerde;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEleccion extends JPanel {
	
	private Ventana ventana;
	
	
	public PantallaEleccion(Ventana v) {
		this.ventana=v;

		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel labelEleccion = new JLabel("ELIGE EXPERIENCIA");
		labelEleccion.setBounds(100, 18, 113, 18);
		labelEleccion.setForeground(Color.BLUE);
		labelEleccion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		add(labelEleccion);
		
		JButton botonComidas = new BotonAzul("Comidas");
		botonComidas.setBounds(128, 91, 85, 39);
		botonComidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("comida");
			}
		});
		add(botonComidas);
		
		JButton botonCuidados = new BotonAzul("Cuidados");
		botonCuidados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("cuidado");
			}
		});
		botonCuidados.setBounds(122, 141, 91, 39);
		add(botonCuidados);
		
		JButton botonViajes = new BotonAzul("Viajes");
		botonViajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("destino");
			}
		});
		botonViajes.setBounds(132, 191, 63, 39);
		add(botonViajes);
		
		JButton botonUsuario = new BotonAzul("Area usuario");
		botonUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("usuario");
			}
		});
		botonUsuario.setBounds(329, 14, 150, 23);
		add(botonUsuario);
		
		JButton botonIrLogin = new JButton("Logout");
		botonIrLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		botonIrLogin.setBounds(436, 337, 89, 23);
		add(botonIrLogin);

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

