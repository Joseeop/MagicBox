package interfacesgraficas;

import javax.swing.JPanel;

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


public class PantallaComida extends JPanel {
	private Ventana ventana;
	
	
	public PantallaComida(Ventana v) {
		 this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("COMIDAS");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(40, 40));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 5, 30, 5, 0 };
		gbl_panel.rowHeights = new int[] { 22, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JComboBox seleccionComida = new JComboBox();
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
						System.out.println(comida.toString());
					
						
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
		
		GridBagConstraints gbc_seleccionComida = new GridBagConstraints();
		gbc_seleccionComida.insets = new Insets(0, 0, 5, 5);
		gbc_seleccionComida.fill = GridBagConstraints.HORIZONTAL;
		gbc_seleccionComida.gridx = 1;
		gbc_seleccionComida.gridy = 1;
		panel.add(seleccionComida, gbc_seleccionComida);
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("seleccion");
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridx = 4;
		gbc_botonAtras.gridy = 3;
		add(botonAtras, gbc_botonAtras);
		
		
	}

}
