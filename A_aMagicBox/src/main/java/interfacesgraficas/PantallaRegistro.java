package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import enumeraciones.Pais;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaInvalidaException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextArea;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private JTextField campoEmail;
	private JTextField campoApellido;
	private JTextField campoNombre;
	
	public PantallaRegistro(Ventana v) {
		setBackground(Color.ORANGE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setFont(new Font("Arial Black", Font.PLAIN, 37));
		GridBagConstraints gbc_tituloRegistro = new GridBagConstraints();
		gbc_tituloRegistro.gridwidth = 3;
		gbc_tituloRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_tituloRegistro.gridx = 1;
		gbc_tituloRegistro.gridy = 1;
		add(tituloRegistro, gbc_tituloRegistro);
		
		JLabel labelEmail = new JLabel("Email");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.EAST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 2;
		add(labelEmail, gbc_labelEmail);
		
		campoEmail = new JTextField();
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 2;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);
		
		JLabel labelUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.anchor = GridBagConstraints.EAST;
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 3;
		add(labelUsuario, gbc_labelUsuario);
		
		campoUsuario = new JTextField();
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.gridwidth = 2;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 3;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.anchor = GridBagConstraints.EAST;
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 1;
		gbc_labelContraseña.gridy = 4;
		add(labelContraseña, gbc_labelContraseña);
		
		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.gridwidth = 2;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 4;
		add(campoContraseña, gbc_campoContraseña);
		
		ButtonGroup grupoGenero=new ButtonGroup();
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		
		JButton botonRegistrarse = new JButton("Registrarse");
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 5;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel labelApellido = new JLabel("Apellido");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 1;
		gbc_labelApellido.gridy = 8;
		add(labelApellido, gbc_labelApellido);
		
		campoApellido = new JTextField();
		GridBagConstraints gbc_campoApellido = new GridBagConstraints();
		gbc_campoApellido.gridwidth = 2;
		gbc_campoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_campoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoApellido.gridx = 2;
		gbc_campoApellido.gridy = 8;
		add(campoApellido, gbc_campoApellido);
		campoApellido.setColumns(10);
		
		final JRadioButton generoHombre = new JRadioButton("Hombre");
		GridBagConstraints gbc_generoHombre = new GridBagConstraints();
		gbc_generoHombre.insets = new Insets(0, 0, 5, 5);
		gbc_generoHombre.gridx = 1;
		gbc_generoHombre.gridy = 9;
		add(generoHombre, gbc_generoHombre);
		grupoGenero.add(generoHombre);
		
		final JRadioButton generoMujer = new JRadioButton("Mujer");
		GridBagConstraints gbc_generoMujer = new GridBagConstraints();
		gbc_generoMujer.insets = new Insets(0, 0, 5, 5);
		gbc_generoMujer.gridx = 2;
		gbc_generoMujer.gridy = 9;
		add(generoMujer, gbc_generoMujer);
		grupoGenero.add(generoMujer);
		
		final JRadioButton generoNoBinario = new JRadioButton("No binario");
		GridBagConstraints gbc_generoNoBinario = new GridBagConstraints();
		gbc_generoNoBinario.insets = new Insets(0, 0, 5, 5);
		gbc_generoNoBinario.gridx = 3;
		gbc_generoNoBinario.gridy = 9;
		add(generoNoBinario, gbc_generoNoBinario);
		grupoGenero.add(generoNoBinario);
		
		final JComboBox seleccionPais = new JComboBox();
		seleccionPais.setModel(new DefaultComboBoxModel(Pais.values()));
		GridBagConstraints gbc_seleccionPais = new GridBagConstraints();
		gbc_seleccionPais.gridwidth = 3;
		gbc_seleccionPais.insets = new Insets(0, 0, 5, 5);
		gbc_seleccionPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_seleccionPais.gridx = 1;
		gbc_seleccionPais.gridy = 10;
		add(seleccionPais, gbc_seleccionPais);
		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.fill = GridBagConstraints.BOTH;
		gbc_botonRegistrarse.gridwidth = 3;
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarse.gridx = 1;
		gbc_botonRegistrarse.gridy = 11;
		add(botonRegistrarse, gbc_botonRegistrarse);
		
		
		//Los listener siempre al final del código.
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=campoNombre.getText();
				String nombreUsuario=campoUsuario.getText();
				String contraseña=new String (campoContraseña.getPassword());
				String email=campoEmail.getText();
				String apellido=campoApellido.getText();
				Pais pais=(Pais) seleccionPais.getSelectedItem();
				char genero=0;
				if(generoHombre.isSelected()) {
					genero='h';
				}else if(generoMujer.isSelected()) {
					genero='m';
				}else if(generoNoBinario.isSelected()) {
					genero='n';
				}
				 try {
					new Usuario(email,nombreUsuario,nombre,apellido,contraseña,pais);
					//1.Ventana padre, se quedará por detrás oculta 2.Contenido mensaje 3. titulo Mensaje 4.Icono que muestra
					JOptionPane.showMessageDialog(ventana,"registrado con éxito","Registro completado",JOptionPane.PLAIN_MESSAGE);
					ventana.irAPantalla("login");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				} catch (ContrasegnaIncorrectaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 System.out.println(genero);
				 System.out.println(nombreUsuario);
				
				
				
				
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 3;
		gbc_botonAtras.gridy = 13;
		add(botonAtras, gbc_botonAtras);
		ventana=v;
	}
}
