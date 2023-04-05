package fakepokemon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import batalla.Pokemon;

@SuppressWarnings("serial")
public final class Selector extends JDialog{
	
	private ArrayList<Pokemon> pokedex;
	private PanelPokemon panelPokemon; //Referencia al panel de jugador que invoca este selector
	
	public Selector(Frame parent, boolean modal, PanelPokemon pnPok) {
		super(parent, modal);
		panelPokemon = pnPok;
		construirPokedex();
		
		setLayout(new BorderLayout());
		PanelMensajes pnMensaje = new PanelMensajes();
		pnMensaje.setMensaje("Selecciona un personaje Pokemon");
		add(pnMensaje, BorderLayout.NORTH);
		
		JPanel roaster = new JPanel();
		roaster.setLayout(new GridLayout(2, 4)); //Grilla para los 8 pokemons
		for (Pokemon pok: pokedex)
			roaster.add(new PanelPersonaje(pok));
		
		add(roaster, BorderLayout.CENTER);
		
		setTitle("Seleccionar Pokemon");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	
	private void construirPokedex() {
		pokedex = new ArrayList<Pokemon>();
		pokedex.add(new Pokemon("Bulbasaur", 200, "img/bulbasaur_p1.png", "img/bulbasaur_p2.png"));
		pokedex.add(new Pokemon("Caterpie", 200, "img/caterpie_p1.png", "img/caterpie_p2.png"));
		pokedex.add(new Pokemon("Charmander", 200, "img/charmander_p1.png", "img/charmander_p2.png"));
		pokedex.add(new Pokemon("Pidgey", 200, "img/pidgey_p1.png", "img/pidgey_p2.png"));
		pokedex.add(new Pokemon("Pikachu", 200, "img/pikachu_p1.png", "img/pikachu_p2.png"));
		pokedex.add(new Pokemon("Rattata", 200, "img/rattata_p1.png", "img/rattata_p2.png"));
		pokedex.add(new Pokemon("Squirtle", 200, "img/squirtle_p1.png", "img/squirtle_p2.png"));
		pokedex.add(new Pokemon("Weedle", 200, "img/weedle_p1.png", "img/weedle_p2.png"));
	}
	
	private void cerrarDialogo() {
		dispose();
	}
	
	private class PanelPersonaje extends JPanel implements MouseListener{
		
		public Pokemon personaje;
		
		public PanelPersonaje(Pokemon pok) {
			personaje = pok;
			ImageIcon imagen = new ImageIcon(
					Selector.class.getClassLoader().getResource(personaje.getImgP1())); 

			add(new JLabel(imagen));
			setToolTipText(personaje.getNombre());
			setBorder(new MatteBorder(15, 15, 15, 15, Color.DARK_GRAY));
			setBackground(Color.WHITE);
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			panelPokemon.setPokemon(personaje);
			cerrarDialogo();
		}
		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		@Override
		public void mouseEntered(MouseEvent e) {
			setBackground(Color.YELLOW);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(Color.WHITE);
		}
	}

}
