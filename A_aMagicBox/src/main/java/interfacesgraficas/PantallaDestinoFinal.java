package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PantallaDestinoFinal extends JPanel {
	
	private Ventana ventana;
	
	
	public PantallaDestinoFinal (Ventana v, String destino,ImageIcon foto) {
		this.ventana=v;
		setLayout(null);
		
		JLabel labelDestino = new JLabel(destino);
		labelDestino.setFont(new Font("Roboto Black", Font.BOLD, 18));
		labelDestino.setForeground(new Color(112, 128, 144));
		labelDestino.setBounds(375, 11, 261, 53);
		add(labelDestino);
		
		JLabel labelTitulo = new JLabel("TU DESTINO FINAL ES:");
		labelTitulo.setForeground(new Color(112, 128, 144));
		labelTitulo.setFont(new Font("Roboto Black", Font.BOLD, 16));
		labelTitulo.setBounds(101, 0, 427, 53);
		add(labelTitulo);
		

		JLabel labelFinal = new JLabel("New label");
//		lblNewLabel_1.setIcon((new ImageIcon(PantallaDestinoFinal.class.getResource(foto))));
		labelFinal.setIcon(foto);
		labelFinal.setBounds(101, 75, 600, 350);
		add(labelFinal);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaDestinoFinal.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
		
	}
}
