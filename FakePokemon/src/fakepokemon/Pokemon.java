package batalla;

import java.util.Random;

public class Pokemon{
	
	private String nombre;
	private int vida;
	private Random azar = new Random();
	private String imgP1; //Ruta a la imagen cuando es player1
	private String imgP2; //Ruta a la imagen cuando es player2, misma que P1, pero invertida
	
	public String mensaje; //Mensaje que se genera tras un ataque
	public boolean suTurno; //Indica si es el turno de ataque de este Pokemon
	
	public Pokemon(String nombrePok, int vidaPok, String img1, String img2) {
		nombre = nombrePok;
		vida = vidaPok;
		mensaje = "";
		imgP1 = img1;
		imgP2 = img2;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int v) {
		vida = v;
	}
	
	public String getImgP1() {
		return imgP1;
	}

	public String getImgP2() {
		return imgP2;
	}

	public int atacar() {
		
		mensaje = ""; //Se generará un nuevo mensaje
		int ataque = azar.nextInt(11) + 10;
		
		if (esCritico()) {
			mensaje += "¡Ataque crítico! ";
			ataque =  (int)(ataque * 1.5);
		}
		
		mensaje += "Daño: " + ataque + " puntos";
		return ataque;
	}
	
	public void perderVida(int ataque) {
		vida -= ataque;
	}
	
	private boolean esCritico() {
		int valor = azar.nextInt(100);
		/*
		 * Entre 0 y 100 hay diez valores que son
		 * múltiplos de 10.
		 * Es decir, hay un 10% de posibilidades
		 * de obtener un valor múltiplo de 10.
		 */
		
		return valor%10 == 0;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nVida: " + vida;
	}

}
