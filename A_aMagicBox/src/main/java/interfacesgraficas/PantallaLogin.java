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
import componentesvisuales.BotonLogin;
import componentesvisuales.BotonRojo;
import componentesvisuales.BotonSalir;
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
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	/**
	 * Variable JText para el campo e-mail.
	 */
	private JTextField campoEmail;
	/**
	 * variable para JPassWordField para el campo contraseña
	 */
	private JPasswordField campoContraseña;
	/**
	 * variables internas para hacer crear una label y que la pantalla se mueva.
	 */
	private int xMouse,yMouse;

	/**
	 * Constructor de clase ventana que recibe por parámetros las propiedades heredadas en la que incluimos la funcionalidad de la misma
	 * @param Ventana que recibe y construye por argumentos
	 */
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setForeground(Color.PINK);
		panelFondo.setBounds(0, 0, 800, 500);
		add(panelFondo);
		panelFondo.setLayout(null);
		
		JLabel etiquetaTitulo = new JLabel("INICIAR SESIÓN");
		etiquetaTitulo.setBounds(34, 61, 267, 44);
		panelFondo.add(etiquetaTitulo);
		etiquetaTitulo.setForeground(new Color(112, 128, 144));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaTitulo.setFont(new Font("Roboto Black", Font.BOLD, 27));
		
		/**
		 * Hacemos un evento para comprobar cuando presionamos sobre el campo de usuario, aún no hemos introducido los datos
		 * si campo email está igual que cuando lo pusimos por defecto, dejará ese campo en blanco y cambiará la letra
		 * hacemos lo mismo con contraseña para que no deshaga los cambios si cambiamos de campo.
		 */
		campoEmail = new JTextField();
		campoEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
		        if (campoEmail.getText().equals("Ingrese su email")) {
		        	campoEmail.setText("");
		        	campoEmail.setForeground(Color.black);
		        }
		        if (String.valueOf(campoContraseña.getPassword()).isEmpty()) {
		        	campoContraseña.setText("********");
		        	campoContraseña.setForeground(Color.gray);
		        }
		    }
			}
		);
		campoEmail.setOpaque(false);
		campoEmail.setBackground(new Color(168, 228, 252));
		campoEmail.setBorder(null);
		campoEmail.setForeground(Color.GRAY);
		campoEmail.setText("Ingrese su email");
		campoEmail.setBounds(34, 154, 242, 20);
		panelFondo.add(campoEmail);
		campoEmail.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			     if (String.valueOf(campoContraseña.getPassword()).equals("********")) {
			    	 campoContraseña.setText("");
			    	 campoContraseña.setForeground(Color.black);
			        }
			        if (campoEmail.getText().isEmpty()) {
			        	campoEmail.setText("Ingrese su email");
			        	campoEmail.setForeground(Color.gray);
			        }
			    }
				
			}
		);
		campoContraseña.setOpaque(false);
		campoContraseña.setBackground(new Color(168, 228, 252));
		campoContraseña.setBorder(null);
		campoContraseña.setBounds(34, 232, 243, 20);
		panelFondo.add(campoContraseña);
		campoContraseña.setEchoChar('*');
		
		
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		email.setBounds(34, 137, 78, 14);
		panelFondo.add(email);
		email.setForeground(new Color(112, 128, 144));
		
		JLabel labelContraseña = new JLabel("CONTRASEÑA");
		labelContraseña.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		labelContraseña.setBounds(34, 217, 242, 14);
		panelFondo.add(labelContraseña);
		labelContraseña.setForeground(new Color(112, 128, 144));
		labelContraseña.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton botonRegistro = new BotonLogin("Registrarse");
		botonRegistro.setBounds(644, 0, 156, 26);
		panelFondo.add(botonRegistro);
		
		JButton botonLogin = new BotonLogin("Login");
		botonLogin.setFont(new Font("Roboto Black", Font.BOLD, 20));
		botonLogin.setBounds(34, 263, 113, 44);
		panelFondo.add(botonLogin);
		/**
		 * boton login que comprobará si los datos introducidos son válidos, si lo son te mostrará mensaje emergente de bienvenida
		 * sino, lanzará una excepción.
		 */
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
		
		JButton BotonSalir = new BotonSalir("Salir");
		BotonSalir.setText("X");
		BotonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BotonSalir.setBounds(0, 0, 35, 26);
		panelFondo.add(BotonSalir);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(34, 185, 243, 7);
		panelFondo.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(33, 256, 243, 7);
		panelFondo.add(separator_1);
		
		JLabel labelTextoBienvenida = new JLabel("Hay una sorpresa para ti...¡Regístrate para descubrirla!");
		labelTextoBienvenida.setForeground(new Color(112, 128, 144));
		labelTextoBienvenida.setBackground(new Color(112, 128, 144));
		labelTextoBienvenida.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		labelTextoBienvenida.setBounds(359, 3, 282, 26);
		panelFondo.add(labelTextoBienvenida);
		
		JLabel labelIcono = new JLabel("New label");
		labelIcono.setIcon(new ImageIcon("./iconos/iconoVentana.png"));
		labelIcono.setBounds(476, 26, 324, 474);
		panelFondo.add(labelIcono);
		
		
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon("./iconos/fondoLogin1.jpg"));
		labelFondo.setBounds(0, 0, 800, 500);
		panelFondo.add(labelFondo);

	
		
		
		/**
		 * Creamos un label en la parte superior de la pantalla para poder moverla.
		 */
		JLabel labelMoverVentana = new JLabel("");
		labelMoverVentana.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				 int x = e.getXOnScreen();
			        int y = e.getYOnScreen();
			        this.setLocation(x - xMouse, y - yMouse);
			}

			private void setLocation(int i, int j) {
				// TODO Auto-generated method stub
				
			}
		});
		labelMoverVentana.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				  xMouse = e.getX();
			        yMouse = e.getY();
			}
		});
		labelMoverVentana.setBounds(34, 0, 766, 33);
		panelFondo.add(labelMoverVentana);
		
		/**
		 * Botón para salir del programa.
		 */
		BotonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.dispose();
			}
		});
		
		/**
		 * boton para ir a la pantalla registros.
		 */
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");
			}
		});
	}
}
