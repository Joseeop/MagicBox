package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enumeraciones.TipoCuidado;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaDestino extends JPanel {
	
	
	private Ventana ventana;
	
	public PantallaDestino (Ventana v) {
		
		this.ventana=v;
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipoCuidado.values()));
		comboBox.setBounds(163, 137, 132, 22);
		add(comboBox);
	
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("seleccion");
			}
		});
		botonAtras.setBounds(361, 277, 89, 23);
		add(botonAtras);

		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 502, 350);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Spanys\\Desktop\\Elige tu destino.png"));
		add(lblNewLabel);
		
	}
}
