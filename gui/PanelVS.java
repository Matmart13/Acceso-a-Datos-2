package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelVS extends JPanel{
	
	public PanelVS() {
		ImageIcon imagen = new ImageIcon(PanelVS.class.getClassLoader().getResource("img/vs.png"));
		JLabel icono = new JLabel(imagen);
		add(icono);
	}

}
