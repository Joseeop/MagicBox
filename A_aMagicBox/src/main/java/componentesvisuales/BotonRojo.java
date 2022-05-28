package componentesvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class BotonRojo extends JButton {
	public BotonRojo(String s){
		super(s);
		estilosPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.RED);
				setBackground(new Color(50, 0, 0));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
	}
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(102, 0, 153));
		this.setBackground(new Color(255, 000, 000));
		this.setFocusable(false);
		this.setBorder(
				new MatteBorder(3,3,3,3,new Color(200,0,0)));
		this.setFont(new Font("MV Boli", Font.BOLD, 20));
		
	}
}
