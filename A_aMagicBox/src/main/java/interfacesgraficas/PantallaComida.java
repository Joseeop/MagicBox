package interfacesgraficas;

import javax.swing.JPanel;

import clases.Actividad;
import clases.Comidas;
import componentesvisuales.BotonLogin;
import componentesvisuales.BotonRegistro;
import enumeraciones.Pais;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import enumeraciones.TipoComida;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Color;

public class PantallaComida extends JPanel {
	private Ventana ventana;
	
	private String eleccion;
	public  Comidas comida=null;

	public PantallaComida(Ventana v) {
		this.ventana = v;
		setLayout(null);
	
		
	

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaComida.class.getResource("/imagenes/dinning-table.png")));
		lblNewLabel.setBounds(516, 0, 284, 500);
		add(lblNewLabel);

		final JComboBox seleccionComida = new JComboBox();
		seleccionComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MusicaFondo musica= new MusicaFondo(new File("./musica/combosound.wav"));
				musica.start();
			}
		});
		seleccionComida.setBounds(191, 130, 182, 20);
		add(seleccionComida);
		seleccionComida.setModel(new DefaultComboBoxModel(TipoComida.values()));

		seleccionComida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Statement smt = ConexionBD.conectar();
				ResultSet cursor;
				try {
					cursor = smt.executeQuery("select * from comida where tipoComida='"
							+ seleccionComida.getSelectedItem().toString() + "'");
					while (cursor.next()) {

						String nombreRes = cursor.getString("nombreRestaurante");
						String rutaFoto = cursor.getString("foto");
						String descripcion = cursor.getString("descripcion");
						TipoComida tipoComida = TipoComida.valueOf(cursor.getString("tipoComida"));

						File file = new File(rutaFoto);
						BufferedImage foto = ImageIO.read(file);
						comida = new Comidas(nombreRes, rutaFoto, descripcion, tipoComida);
						Actividad actividad = new Actividad(nombreRes, rutaFoto, descripcion);
						//System.out.println(comida.toString());
						
//						if (TipoComida.ALMUERZO==("")){
//							
//						}

						
						// ventana.irAPantalla("login");

						// restaurante1= ventana.restaurante.getNombre();
						// PRUEBA
//						JLabel labelPrueba = new JLabel("Descripción: "+comida);
//						GridBagConstraints gbc_labelPrueba = new GridBagConstraints();
//						gbc_labelPrueba.insets = new Insets(0, 0, 0, 5);
//						gbc_labelPrueba.gridx = 2;
//						gbc_labelPrueba.gridy = 3;
//						add(labelPrueba, gbc_labelPrueba);

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ConexionBD.desconectar();

			}
		});
		/**
		 * Botón que nos llevará a la siguiente pantalla según la elección(Cena o almuerzo)
		 */
		JButton botonAdelante = new BotonRegistro("¡ADELANTE!");
		botonAdelante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String eleccion=seleccionComida.getSelectedItem().toString();
				
				if (eleccion=="ALMUERZO"){
			ventana.irAPantalla("almuerzo", eleccion);
		}else if(eleccion=="CENA") {
			ventana.irAPantalla("cena", eleccion);
		}
			}
		});
		botonAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAdelante.setBounds(162, 261, 168, 23);
		add(botonAdelante);
		/**
		 * label con evento que nos vuelve a la pantalla selección
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

		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaComida.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		


	}
}
