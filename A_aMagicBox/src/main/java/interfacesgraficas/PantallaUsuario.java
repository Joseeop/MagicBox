package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaUsuario extends JPanel{
	
	private Ventana ventana;
	
	public PantallaUsuario(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel botonAtras = new JLabel("New label");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("seleccion");
			}
		});
		botonAtras.setIcon(new ImageIcon("C:\\Users\\Spanys\\Desktop\\PROYECTO PROGRAMACION\\MagicBox\\A_aMagicBox\\botones\\botonAtras.png"));
		botonAtras.setBounds(306, 251, 115, 25);
		add(botonAtras);
		
		JLabel labelNombre = new JLabel("Nombre: "+ventana.usuarioLogado.getNombre());
		labelNombre.setBounds(61, 68, 301, 25);
		add(labelNombre);
		
		JLabel labelPais = new JLabel("País: "+ventana.usuarioLogado.getPais().toString());
		labelPais.setBounds(57, 117, 107, 25);
		add(labelPais);
		
		JLabel labelEmail = new JLabel("Email: "+ventana.usuarioLogado.getEmail());
		labelEmail.setBounds(61, 93, 301, 25);
		add(labelEmail);
		
		
	}

}
