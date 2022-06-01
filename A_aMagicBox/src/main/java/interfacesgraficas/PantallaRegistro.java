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
import javax.swing.ImageIcon;

public class PantallaRegistro extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private JTextField campoEmail;
	private JTextField campoApellido;
	private JTextField campoNombre;
	
	public PantallaRegistro(Ventana v) {
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel tituloRegistro = new JLabel("Registro");
		tituloRegistro.setBounds(136, 1, 172, 53);
		tituloRegistro.setFont(new Font("Arial Black", Font.PLAIN, 37));
		add(tituloRegistro);
		
		campoEmail = new JTextField();
		campoEmail.setOpaque(false);
		campoEmail.setBounds(92, 87, 222, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(90, 135, 224, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(92, 180, 222, 20);
		add(campoContraseña);
		
		ButtonGroup grupoGenero=new ButtonGroup();
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAtras.setBounds(568, 412, 59, 23);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(86, 412, 230, 23);
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		campoNombre = new JTextField();
		campoNombre.setBounds(89, 226, 225, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoApellido = new JTextField();
		campoApellido.setBounds(92, 271, 222, 20);
		add(campoApellido);
		campoApellido.setColumns(10);
		
		final JRadioButton generoHombre = new JRadioButton("Hombre");
		generoHombre.setBounds(0, 0, 0, 0);
		add(generoHombre);
		grupoGenero.add(generoHombre);
		
		final JRadioButton generoMujer = new JRadioButton("Mujer");
		generoMujer.setBounds(0, 0, 0, 0);
		add(generoMujer);
		grupoGenero.add(generoMujer);
		
		final JRadioButton generoNoBinario = new JRadioButton("No binario");
		generoNoBinario.setBounds(0, 0, 0, 0);
		add(generoNoBinario);
		grupoGenero.add(generoNoBinario);
		
		final JComboBox seleccionPais = new JComboBox();
		seleccionPais.setBounds(92, 315, 222, 20);
		seleccionPais.setModel(new DefaultComboBoxModel(Pais.values()));
		add(seleccionPais);
		add(botonRegistrarse);
		
		
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
		add(botonAtras);
		
		
		
		JLabel labelEmail = new JLabel("EMAIL");
		labelEmail.setForeground(new Color(112, 128, 144));
		labelEmail.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelEmail.setBounds(92, 73, 216, 14);
		add(labelEmail);
		
		JLabel labelUsuario = new JLabel("USUARIO");
		labelUsuario.setForeground(new Color(112, 128, 144));
		labelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelUsuario.setBounds(92, 118, 216, 14);
		add(labelUsuario);
		
		JLabel labelContraseña = new JLabel("CONTRASEÑA");
		labelContraseña.setForeground(new Color(112, 128, 144));
		labelContraseña.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelContraseña.setBounds(90, 166, 218, 14);
		add(labelContraseña);
		
		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setForeground(new Color(112, 128, 144));
		labelNombre.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelNombre.setBounds(92, 211, 216, 14);
		add(labelNombre);
		
		JLabel labelApellido = new JLabel("APELLIDO");
		labelApellido.setForeground(new Color(112, 128, 144));
		labelApellido.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelApellido.setBounds(92, 257, 78, 14);
		add(labelApellido);
		
		JLabel labelPais = new JLabel("PAIS");
		labelPais.setForeground(new Color(112, 128, 144));
		labelPais.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelPais.setBounds(96, 302, 218, 14);
		add(labelPais);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 499);
		add(labelFondo);
		
	
		ventana=v;
	}
}
