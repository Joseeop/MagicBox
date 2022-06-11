package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PantallaInformacion extends JPanel {
	
	private Ventana ventana;
	private JTextField textField;
	
	//HACER AQUI LECTURA DE FICHEROS.
	
	public PantallaInformacion (Ventana v) {
		
		this.ventana=v;
		setLayout(null);
		File file=new File("./informacion.txt");
		BufferedReader lector;
		String texto="\n";
		try {
			lector = new BufferedReader(new FileReader(file.getPath()));
			   String linea = lector.readLine();
		        
		        
		        while(linea!=null) {
		        	texto+=linea+"\n";
		        	System.out.println("\n");
		        	linea=lector.readLine();
		        }
		        
		        lector.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

     
		JLabel labelVolver = new JLabel("New label");
		labelVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("destino");
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
		
		System.out.println(texto);
		
		textField = new JTextField();
		textField.setText(texto);
		textField.setBounds(192, 73, 374, 294);
		add(textField);
		textField.setColumns(10);
		labelVolver.setIcon(new ImageIcon(PantallaUsuario.class.getResource("/imagenes/iconoVentanaInicio.png")));
		labelVolver.setBounds(0, 0, 60, 53);
		add(labelVolver);
		
		JLabel labelFondo = new JLabel("New label");
		labelFondo.setIcon(new ImageIcon(PantallaInformacion.class.getResource("/imagenes/fondoEleccion.jpg")));
		labelFondo.setBounds(0, 0, 800, 500);
		add(labelFondo);
		
		
	}
}
