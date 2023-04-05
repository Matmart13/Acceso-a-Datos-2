package Proyecto_Pokemon01;



public class Pokemon  extends Tipo implements I_Acciones{
//Variables
 private int ph;
 private int fuerza;
 private boolean estado;
 private tipo tipo_Pokemon;
 private String nombre;
 //Constructor
 Pokemon (String nombre,int ph, int fuerza, boolean estado){
	 this.nombre=nombre;
	 this.ph=ph;
	 this.fuerza=fuerza;
	 this.estado=estado;
 }
 //Getters y setters
 public String getNombre() {
	return nombre;
}

public  tipo gettipo_Pokemon() {
	return tipo_Pokemon;
 }
 public void settipo_Pokemon(tipo tipo_Pokemon) {
	 this.tipo_Pokemon = tipo_Pokemon;
 }
 int getPh() {
	 return ph;
 }
 void setph(int ph) {
	 this.ph=ph;
 }
 int getfuerza() {
	 return fuerza;
 }
 void setfuerza(int fuerza) {
	 this.fuerza=fuerza;
 }
 boolean isEstado() {
	 return estado;
 }
 void setEstado(boolean estado) {
	 this.estado=estado;
 }
 
@Override
public void atacar(Pokemon Px,int fuerza) {
	Px.ph -= fuerza;
	if (Px.getPh() <= 0 ) {
		System.out.println("Este pokemon se ha quedado sin energía");
		Px.setEstado(false) ;
	}
}
@Override
public void cambiar() {
	
}
 
}
