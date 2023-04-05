package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import batalla.Pokemon;

@SuppressWarnings("serial")
public class PanelPokemon extends JPanel{
	
	public Pokemon pokemon;
	private int numPanel;
	private JButton btAtacar;
	private JProgressBar barraVida;
	private PanelNombre pnNombre;
	private PanelImagen pnImagen;
	private PanelVida pnVida;
	
	//Autoreferencia para poder transmitirsela al JDialog que selecciona Pokemon
	private PanelPokemon estePanel;
	
	public PanelPokemon(String rutaImagen, int numero) {
		numPanel = numero;
		pnNombre = new PanelNombre();
		pnImagen = new PanelImagen(rutaImagen);
		pnVida = new PanelVida();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(pnNombre);
		add(pnImagen);
		add(pnVida);
		add(new PanelBoton());
		estePanel = this;
	}
	
	public void reiniciar() {
		if (numPanel == 1)
			pnImagen.setImagen("img/pokeball_215.png");
		else
			pnImagen.setImagen("img/pokeball_215_p2.png");
		btAtacar.setEnabled(false);
		pnNombre.setNombre("Escoge Pokemon");
		barraVida.setValue(0);
			
	}
	
	/*
	 * Este método lo invocará el JDialog que permite 
	 * seleccionar Pokemon, para setearle un Pokemon
	 * a esta clase PanelPokemon.
	 * Para poder invocar este método, el JDialog necesita
	 * recibir una referencia a esta clase para que haya
	 * visibilidad entre ellas.
	 */
	public void setPokemon(Pokemon pok) {
		pokemon = pok;
		pnNombre.setNombre(pokemon.getNombre());
		if (numPanel == 1) {
			pnImagen.setImagen(pokemon.getImgP1());
			pokemon.suTurno = true;
		}
		else {
			pnImagen.setImagen(pokemon.getImgP2());
			pokemon.suTurno = false;
		}
		barraVida.setMaximum(pokemon.getVida());
		barraVida.setValue(pokemon.getVida());
		btAtacar.setEnabled(pokemon.suTurno);
	}
	
	private class PanelNombre extends JPanel {
		
		private JLabel nombre;
		
		public PanelNombre() {
			nombre = new JLabel("Escoge Pokemon");
			nombre.setFont(new Font("Consolas", Font.BOLD, 34));
			nombre.setForeground(Color.WHITE);
			add(nombre);
			setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK));
			setBackground(new Color(23, 151, 238));
		}
		
		public void setNombre(String nombrePok) {
			nombre.setText(nombrePok);
		}
	}
	
	private class PanelImagen extends JPanel implements MouseListener{
		
		private JLabel icono;
		
		public PanelImagen(String rutaImagen) {
			ImageIcon imagen = new ImageIcon(PanelPokemon.class.getClassLoader().getResource(rutaImagen));
			icono = new JLabel(imagen);
			icono.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			add(icono);
			addMouseListener(this);
		}
		
		public void setImagen(String ruta) {
			ImageIcon imagen = new ImageIcon(PanelPokemon.class.getClassLoader().getResource(ruta));
			icono.setIcon(imagen);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			new Selector(null, true, estePanel); //JDialog recibe referencia a esta misma clase
		}
		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) {	}

	}
	
	private class PanelVida extends JPanel {
		
		public PanelVida() {
			
			barraVida = new JProgressBar();
			barraVida.setMaximum(0);
			barraVida.setValue(0);
			barraVida.setPreferredSize(new Dimension(200, 30));
			barraVida.setForeground(Color.BLUE);
			add(barraVida);
			barraVida.setBorder(BorderFactory.createRaisedSoftBevelBorder());
			
			TitledBorder bordeTitulado = new TitledBorder("Nivel de Vida");
			bordeTitulado.setTitleFont(new Font("Consolas", Font.ITALIC, 24));
			setBorder(bordeTitulado);
		}
	}
	
	private class PanelBoton extends JPanel {
		
		public PanelBoton() {
			btAtacar = new JButton("¡ATACAR!");
			btAtacar.setEnabled(false);
			btAtacar.setFont(new Font("Consolas", Font.BOLD, 30));
			add(btAtacar);
			setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 30));
		}
	}
	
	public void actualizarPanel() {
		barraVida.setValue(pokemon.getVida());
		btAtacar.setEnabled(pokemon.suTurno);
	}
	
	public void agregarAccion(ActionListener accion) {
		btAtacar.addActionListener(accion);
	}

}
