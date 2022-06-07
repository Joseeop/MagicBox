package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class PantallaMasaje extends JPanel {
	
	private Ventana ventana;
	
	public PantallaMasaje (Ventana v,String ruta) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MASAJE");
		lblNewLabel.setBounds(226, 151, 126, 91);
		add(lblNewLabel);
		

		
		JLabel labelImagenCuidado = new JLabel("New label");
		labelImagenCuidado.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/facial.png")));
		labelImagenCuidado.setBounds(532, 0, 268, 500);
		add(labelImagenCuidado);
		
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
		labelFondo.setIcon(new ImageIcon(PantallaMasaje.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
	}

}
