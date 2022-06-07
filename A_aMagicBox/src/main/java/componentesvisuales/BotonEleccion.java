package componentesvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class BotonEleccion extends JButton {
	
	public BotonEleccion(String s){
		super(s);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
//				setForeground(Color.CYAN);
//				setBackground(new Color(112,128,144));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(000,255,000));
			}
	
			@Override
			public void mousePressed(MouseEvent e) {
				estilosPorDefecto();
			}


		});
	}
	
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(255, 255, 255));
		this.setBackground(new Color(135, 206, 235));
		this.setFocusable(false);
		this.setBorder(
				new MatteBorder(3,3,3,3,new Color(200,0,0)));
		this.setFont(new Font("Roboto Black", Font.BOLD, 15));
		
	}

}
