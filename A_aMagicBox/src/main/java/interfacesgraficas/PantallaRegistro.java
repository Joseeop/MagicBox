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
import componentesvisuales.BotonRegistro;

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
import java.awt.Cursor;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

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
		campoEmail.setBorder(null);
		campoEmail.setOpaque(false);
		campoEmail.setBounds(90, 77, 222, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		campoUsuario = new JTextField();
		campoUsuario.setOpaque(false);
		campoUsuario.setBorder(null);
		campoUsuario.setBounds(90, 133, 224, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBorder(null);
		campoContraseña.setOpaque(false);
		campoContraseña.setBounds(90, 180, 218, 20);
		add(campoContraseña);
		
		ButtonGroup grupoGenero=new ButtonGroup();
		
		JButton botonRegistrarse = new BotonRegistro("Registrarse");
		botonRegistrarse.setBounds(90, 394, 230, 23);
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		campoNombre = new JTextField();
		campoNombre.setBorder(null);
		campoNombre.setOpaque(false);
		campoNombre.setBounds(90, 239, 225, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoApellido = new JTextField();
		campoApellido.setBorder(null);
		campoApellido.setOpaque(false);
		campoApellido.setBounds(90, 282, 222, 20);
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
		seleccionPais.setOpaque(false);
		seleccionPais.setBounds(90, 363, 240, 20);
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
		
		
		
		JLabel labelEmail = new JLabel("EMAIL");
		labelEmail.setForeground(new Color(112, 128, 144));
		labelEmail.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelEmail.setBounds(92, 65, 216, 14);
		add(labelEmail);
		
		JLabel labelUsuario = new JLabel("USUARIO");
		labelUsuario.setForeground(new Color(112, 128, 144));
		labelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelUsuario.setBounds(90, 108, 216, 14);
		add(labelUsuario);
		
		JLabel labelContraseña = new JLabel("CONTRASEÑA");
		labelContraseña.setForeground(new Color(112, 128, 144));
		labelContraseña.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelContraseña.setBounds(90, 165, 218, 14);
		add(labelContraseña);
		
		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setForeground(new Color(112, 128, 144));
		labelNombre.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelNombre.setBounds(90, 216, 216, 14);
		add(labelNombre);
		
		JLabel labelApellido = new JLabel("APELLIDO");
		labelApellido.setForeground(new Color(112, 128, 144));
		labelApellido.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelApellido.setBounds(90, 270, 78, 14);
		add(labelApellido);
		
		JLabel labelPais = new JLabel("PAIS");
		labelPais.setForeground(new Color(112, 128, 144));
		labelPais.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelPais.setBounds(90, 338, 218, 14);
		add(labelPais);
		
		
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setBackground(Color.BLACK);
		separatorEmail.setBounds(92, 98, 243, 7);
		add(separatorEmail);
		
		JSeparator separatorUsuario = new JSeparator();
		separatorUsuario.setBackground(Color.BLACK);
		separatorUsuario.setBounds(89, 148, 243, 7);
		add(separatorUsuario);
		
		JSeparator separatorContraseña = new JSeparator();
		separatorContraseña.setBackground(Color.BLACK);
		separatorContraseña.setBounds(90, 198, 245, 14);
		add(separatorContraseña);
		
		JSeparator separatorNombre = new JSeparator();
		separatorNombre.setBackground(Color.BLACK);
		separatorNombre.setBounds(90, 256, 245, 3);
		add(separatorNombre);
	
		
		JLabel labelIrALogin = new JLabel("New label");
		labelIrALogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
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
		labelIrALogin.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imagenes/iconoVentanaInicio.png")));
		labelIrALogin.setBounds(0, 1, 60, 53);
		add(labelIrALogin);
	
		
		JSeparator separatorApellido = new JSeparator();
		separatorApellido.setBackground(Color.BLACK);
		separatorApellido.setBounds(90, 313, 245, 14);
		add(separatorApellido);

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imagenes/registro.png")));
		lblNewLabel.setBounds(534, 1, 266, 498);
		add(lblNewLabel);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 499);
		add(labelFondo);
	
		ventana=v;
	}
}
