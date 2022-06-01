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
	
		
		JLabel labelNombre = new JLabel("Nombre: "+ventana.usuarioLogado.getNombre());
		labelNombre.setBounds(98, 156, 301, 25);
		add(labelNombre);
		
		JLabel labelPais = new JLabel("País: "+ventana.usuarioLogado.getPais().toString());
		labelPais.setBounds(98, 205, 107, 25);
		add(labelPais);
		
		JLabel labelEmail = new JLabel("Email: "+ventana.usuarioLogado.getEmail());
		labelEmail.setBounds(98, 181, 301, 25);
		add(labelEmail);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaUsuario.class.getResource("/imagenes/fondoLogin1.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
		
	}

}
