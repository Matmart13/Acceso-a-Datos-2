package Proyecto_Pokemon01;

public class P_Tierra extends Pokemon {

	P_Tierra(String nombre, int ph, int fuerza, boolean estado) {
		super(nombre, ph, fuerza, estado);
		super.settipo_Pokemon(tipo.Tierra);
	}
}
