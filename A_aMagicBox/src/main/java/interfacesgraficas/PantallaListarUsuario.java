package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Usuario;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class PantallaListarUsuario extends JPanel {
	
	private Ventana ventana;
	
	public PantallaListarUsuario (Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelEste = new JPanel();
		add(panelEste, BorderLayout.WEST);
		panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));
		//Podemos cambiar X_AXIS por Y_AXIS para tener un menú en vertical.
		
		JButton btnNewButton = new JButton("New button");
		panelEste.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		final ArrayList<Usuario> todos= Usuario.getTodos();
		list.setModel(new AbstractListModel() {
			
			public int getSize() {
				return todos.size();
			}
			public Object getElementAt(int index) {
				return todos.get(index);
			}
		});
		scrollPane.setViewportView(list);
	}
	

}
