package componentesvisuales;

import javax.swing.JPanel;

import clases.Comidas;
import interfacesgraficas.Ventana;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

public class ElementoListaComida extends JPanel {

	private Ventana ventana;
	private Comidas comida;
	
	public ElementoListaComida(Ventana v,Comidas c) {
		this.comida=c;
		this.ventana=v;
		setLayout(null);
		
		JLabel fotoRestaurante = new JLabel("New label");
		fotoRestaurante.setBounds(0, 0, 111, 100);
		add(fotoRestaurante);
		
	}
}
