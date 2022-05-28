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

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaEleccion extends JPanel {
	
	private Ventana ventana;
	
	
	public PantallaEleccion(Ventana v) {
		this.ventana=v;
try {
            
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
		setBackground(Color.ORANGE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelEleccion = new JLabel("ELIGE EXPERIENCIA");
		labelEleccion.setForeground(Color.BLUE);
		labelEleccion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		GridBagConstraints gbc_labelEleccion = new GridBagConstraints();
		gbc_labelEleccion.gridheight = 3;
		gbc_labelEleccion.gridwidth = 3;
		gbc_labelEleccion.insets = new Insets(0, 0, 5, 5);
		gbc_labelEleccion.gridx = 1;
		gbc_labelEleccion.gridy = 0;
		add(labelEleccion, gbc_labelEleccion);
		
		JButton botonComidas = new BotonAzul("Comidas");
		botonComidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("comida");
			}
		});
		GridBagConstraints gbc_botonComidas = new GridBagConstraints();
		gbc_botonComidas.anchor = GridBagConstraints.SOUTH;
		gbc_botonComidas.insets = new Insets(0, 0, 5, 5);
		gbc_botonComidas.gridx = 2;
		gbc_botonComidas.gridy = 4;
		add(botonComidas, gbc_botonComidas);
		
		JButton botonCuidados = new BotonAzul("Cuidados");
		GridBagConstraints gbc_botonCuidados = new GridBagConstraints();
		gbc_botonCuidados.insets = new Insets(0, 0, 5, 5);
		gbc_botonCuidados.gridx = 2;
		gbc_botonCuidados.gridy = 6;
		add(botonCuidados, gbc_botonCuidados);
		
		JButton botonViajes = new BotonAzul("Viajes");
		GridBagConstraints gbc_botonViajes = new GridBagConstraints();
		gbc_botonViajes.insets = new Insets(0, 0, 5, 5);
		gbc_botonViajes.gridx = 2;
		gbc_botonViajes.gridy = 8;
		add(botonViajes, gbc_botonViajes);
try {
            
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
		
		
		
	}

}
