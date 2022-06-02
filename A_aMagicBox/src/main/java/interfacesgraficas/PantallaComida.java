package interfacesgraficas;

import javax.swing.JPanel;

import clases.Actividad;
import clases.Comidas;
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


public class PantallaComida extends JPanel {
	private Ventana ventana;
	
	
	public PantallaComida(Ventana v) {
		 this.ventana=v;
		setLayout(null);
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(PantallaComida.class.getResource("/imagenes/dinning-table.png")));
				lblNewLabel.setBounds(516, 0, 284, 500);
				add(lblNewLabel);
		
				final JComboBox seleccionComida = new JComboBox();
				seleccionComida.setBounds(256, 228, 182, 20);
				add(seleccionComida);
				seleccionComida.setModel(new DefaultComboBoxModel(TipoComida.values()));
				
				
		seleccionComida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Statement smt = ConexionBD.conectar();
				ResultSet cursor;
				try {
					cursor = smt.executeQuery("select * from comida where tipoComida='" + seleccionComida.getSelectedItem().toString() + "'");
					while (cursor.next()) {
						
						String nombreRes=cursor.getString("nombreRestaurante");
						String rutaFoto=cursor.getString("foto");
						String descripcion=cursor.getString("descripcion");
						TipoComida tipoComida=TipoComida.valueOf(cursor.getString("tipoComida"));
						
						File file=new File("C:/Users/Spanys/Desktop/PROYECTO PROGRAMACION/MagicBox/A_aMagicBox/iconos/fondoMagic.jpg");
						BufferedImage foto=ImageIO.read(file);
						Comidas comida=new Comidas(nombreRes, foto, descripcion, tipoComida);
						Actividad actividad=new Actividad(nombreRes,foto,descripcion);
						System.out.println(comida.toString());
						
						
						//PRUEBA
						JLabel labelPrueba = new JLabel("Descripción: "+((Actividad) comida).getDescripcion());
						GridBagConstraints gbc_labelPrueba = new GridBagConstraints();
						gbc_labelPrueba.insets = new Insets(0, 0, 0, 5);
						gbc_labelPrueba.gridx = 2;
						gbc_labelPrueba.gridy = 3;
						add(labelPrueba, gbc_labelPrueba);
						
					
					
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
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaComida.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
	}

}
