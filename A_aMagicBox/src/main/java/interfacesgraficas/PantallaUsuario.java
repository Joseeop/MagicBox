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
		
		
	}

}
