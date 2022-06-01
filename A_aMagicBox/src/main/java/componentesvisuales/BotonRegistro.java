package componentesvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BotonRegistro extends JButton {

	public BotonRegistro(String s){
		super(s);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.white);
				setBackground(new Color(112,128,144));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
	}
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(255, 255, 255));
		this.setBackground(new Color(135, 206, 235));
		this.setFocusable(false);
//		this.setBorder(
//				new MatteBorder(3,3,3,3,new Color(200,0,0)));
		this.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		
	}
}
