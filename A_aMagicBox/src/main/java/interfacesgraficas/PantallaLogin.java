package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import clases.Usuario;
import componentesvisuales.BotonAzul;
import componentesvisuales.BotonRojo;
import componentesvisuales.BotonVerde;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaInvalidaException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoContraseña;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonAzul("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email=campoEmail.getText();
				String contraseña=new String(campoContraseña.getPassword()); //array de char.
				try {
					ventana.usuarioLogado=new Usuario(email,contraseña);
					JOptionPane.showMessageDialog(ventana,"Bienvenido "+ventana.usuarioLogado.getNombre(),
							"Inicio de sesión con éxito",JOptionPane.INFORMATION_MESSAGE);
					ventana.irAPantalla("seleccion");
				} catch (SQLException | ContrasegnaIncorrectaException | UsuarioNoExisteException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		botonLogin.setToolTipText("Pincha aquí para iniciar sesión");
		
		botonLogin.setBounds(95, 179, 160, 44);
		this.add(botonLogin);
		
		JButton botonRegistro = new BotonAzul("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");
			}
		});

		botonRegistro.setBounds(283, 179, 143, 46);
		add(botonRegistro);
		
		JLabel etiquetaTitulo = new JLabel("Iniciar Sesión");
		etiquetaTitulo.setForeground(new Color(255, 0, 0));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Miriam Libre", Font.ITALIC, 27));
		etiquetaTitulo.setBounds(10, 11, 480, 44);
		add(etiquetaTitulo);
		
		JLabel email = new JLabel("Email");
		email.setForeground(new Color(255, 0, 0));
		email.setBounds(108, 88, 46, 14);
		add(email);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setForeground(new Color(255, 0, 0));
		labelContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraseña.setBounds(95, 129, 78, 14);
		add(labelContraseña);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(184, 85, 242, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setEchoChar('*');
		campoContraseña.setBounds(183, 126, 243, 20);
		add(campoContraseña);
		
		JButton BotonSalir = new BotonRojo("Salir");
		BotonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.dispose();
			}
		});
		BotonSalir.setBounds(200, 251, 102, 33);
		add(BotonSalir);
		
		JLabel lblNewLabel = new JLabel("New label");// CAMBIAR RELATIVA
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Spanys\\Desktop\\PROYECTO PROGRAMACION\\MagicBox\\A_aMagicBox\\iconos\\fondoMagic.jpg"));
		lblNewLabel.setBounds(0, 0, 536, 379);
		add(lblNewLabel);
	}
}
