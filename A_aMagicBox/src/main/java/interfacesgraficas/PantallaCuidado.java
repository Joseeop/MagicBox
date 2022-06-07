package interfacesgraficas;

import javax.swing.JPanel;

import clases.Comidas;
import clases.Cuidados;
import componentesvisuales.BotonRegistro;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

import enumeraciones.TipoComida;
import enumeraciones.TipoCuidado;
import utils.ConexionBD;

import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PantallaCuidado extends JPanel {
	
	private Ventana ventana;
	
	public PantallaCuidado (Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel labelImagenCuidado = new JLabel("New label");
		labelImagenCuidado.setIcon(new ImageIcon(PantallaCuidado.class.getResource("/imagenes/facial.png")));
		labelImagenCuidado.setBounds(532, 0, 268, 500);
		add(labelImagenCuidado);
		
		final JComboBox seleccionCuidado = new JComboBox();
		seleccionCuidado.setModel(new DefaultComboBoxModel(TipoCuidado.values()));
		seleccionCuidado.setBounds(238, 192, 107, 22);
		add(seleccionCuidado);
		seleccionCuidado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Statement smt = ConexionBD.conectar();
				ResultSet cursor;
				try {
					cursor = smt.executeQuery("select * from cuidado where tipoCuidado='" + seleccionCuidado.getSelectedItem().toString() + "'");
					while (cursor.next()) {
						
						String nombreCuidado=cursor.getString("nombreCuidado");
						String rutaFoto=cursor.getString("foto");
						String descripcion=cursor.getString("descripcion");
						TipoCuidado tipoCuidado=TipoCuidado.valueOf(cursor.getString("tipoCuidado"));
						
						File file=new File("C:/Users/Spanys/Desktop/PROYECTO PROGRAMACION/MagicBox/A_aMagicBox/iconos/fondoMagic.jpg");
						BufferedImage foto=ImageIO.read(file);
						Cuidados cuidado=new Cuidados(nombreCuidado, rutaFoto, descripcion, tipoCuidado);
						System.out.println(cuidado.toString());
					
						
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
		 * Botón que nos llevará a la siguiente pantalla según la elección(SPA,MASAJE o TRATAMIENTO)
		 */
		JButton botonAdelante = new BotonRegistro("¡ADELANTE!");
		botonAdelante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final String eleccion=seleccionCuidado.getSelectedItem().toString();
				
				if (eleccion=="SPA"){
			ventana.irAPantalla("spa", eleccion);
		}else if(eleccion=="MASAJE") {
			ventana.irAPantalla("masaje", eleccion);
		}else if(eleccion=="TRATAMIENTO") {
			ventana.irAPantalla("tratamiento",eleccion);
		}
			}
		});
		botonAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAdelante.setBounds(162, 261, 168, 23);
		add(botonAdelante);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaCuidado.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
		
	}

}
