package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class PanelMensajes extends JPanel{
	
	private JLabel mensajes;
	
	public PanelMensajes() {
		JPanel display = new JPanel();
		mensajes = new JLabel("Clicka las Pokeball para escoger Pokemon");
		mensajes.setFont(new Font("Calibri", Font.PLAIN, 38));
		mensajes.setForeground(new Color(243, 81, 55 ));
		display.add(mensajes);
		
		setLayout(new GridLayout(1, 1));
		add(display);
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15),
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED)));
		display.setBackground(new Color(230, 234, 160 ));
	}
	
	/*
	 * Recibe y muestra los mensajes que los Pokemon generan
	 * en cada ataque.
	 */
	public void setMensaje(String mensaje) {
		mensajes.setText(mensaje);
	}

}
