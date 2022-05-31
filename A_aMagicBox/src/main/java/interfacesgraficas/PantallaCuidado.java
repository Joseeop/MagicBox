package interfacesgraficas;

import javax.swing.JPanel;

import clases.Comidas;
import clases.Cuidados;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

import enumeraciones.TipoComida;
import enumeraciones.TipoCuidado;
import utils.ConexionBD;

import javax.swing.JButton;

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
		
		final JComboBox seleccionCuidado = new JComboBox();
		seleccionCuidado.setModel(new DefaultComboBoxModel(TipoCuidado.values()));
		seleccionCuidado.setBounds(163, 150, 107, 22);
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
						Cuidados cuidado=new Cuidados(nombreCuidado, foto, descripcion, tipoCuidado);
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
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.irAPantalla("seleccion");
			}
		});
		botonAtras.setBounds(351, 266, 89, 23);
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label"); //CAMBIAR RUTA A RELATIVA
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Spanys\\Desktop\\PROYECTO PROGRAMACION\\MagicBox\\A_aMagicBox\\iconos\\EligeCuidado.png"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		add(lblNewLabel);
		
		
	}

}
