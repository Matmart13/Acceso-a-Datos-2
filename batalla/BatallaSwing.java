package batalla;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.*;

@SuppressWarnings("serial")
public class BatallaSwing extends JFrame{
	
	private PanelMensajes pnMensajes;
	private PanelPokemon pnPok1;
	private PanelPokemon pnPok2;
	
	public BatallaSwing() {
		
		pnMensajes = new PanelMensajes();
		pnPok1 = new PanelPokemon("img/pokeball_215.png", 1);
		pnPok1.agregarAccion(new AccionAtacar());
		pnPok2 = new PanelPokemon("img/pokeball_215_p2.png", 2);
		pnPok2.agregarAccion(new AccionAtacar());
		
		setLayout(new BorderLayout());
		
		add(pnMensajes, BorderLayout.NORTH);
		JPanel pnCentro = new JPanel();
		pnCentro.add(pnPok1);
		pnCentro.add(new PanelVS()); //PanelVS no requiere referencia, no se interactúa con ella.
		pnCentro.add(pnPok2);
		add(pnCentro, BorderLayout.CENTER);
		
		setTitle("Batalla Pokemon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class AccionAtacar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (pnPok1.pokemon.suTurno) {
				pnPok2.pokemon.perderVida(pnPok1.pokemon.atacar());
				pnMensajes.setMensaje(pnPok1.pokemon.mensaje);
				pnPok1.pokemon.suTurno = false;
				pnPok2.pokemon.suTurno = true;
			}
			else {
				pnPok1.pokemon.perderVida(pnPok2.pokemon.atacar());
				pnMensajes.setMensaje(pnPok2.pokemon.mensaje);
				pnPok1.pokemon.suTurno = true;
				pnPok2.pokemon.suTurno = false;
			}
			
			pnPok1.actualizarPanel();
			pnPok2.actualizarPanel();
			
			if (pnPok1.pokemon.getVida() <= 0 || pnPok2.pokemon.getVida() <= 0) {
				String mensajeFinal = "Juego Terminado\n Ha ganado: ";
				mensajeFinal += pnPok1.pokemon.getVida()>0?pnPok1.pokemon.getNombre():pnPok2.pokemon.getNombre();
				
				JOptionPane.showMessageDialog(null, mensajeFinal, "Fin del Juego",
						JOptionPane.INFORMATION_MESSAGE);
				
				
				pnMensajes.setMensaje("Clicka las Pokeball para escoger Pokemon");
				pnPok1.reiniciar();
				pnPok2.reiniciar();
			}
			
			
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BatallaSwing();	
			}
		});
	}

}
