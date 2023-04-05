package Proyecto_Pokemon01;

public class P_Agua extends Pokemon{

	P_Agua(String nombre, int ph, int fuerza, boolean estado) {
		super(nombre, ph, fuerza, estado);
		super.settipo_Pokemon(tipo.Agua);
	}


}
