package Proyecto_Pokemon01;



import java.util.Scanner;

public class Batalla_Principal {
//variables
static int  turno = 0;
static Scanner sc = new Scanner(System.in);
static int pok_act_1 , pok_act_2 ;
static int seleccion;
static Pokemon J1[] = new Pokemon[6];
static Pokemon J2[] = new Pokemon[6];
static int pociones1 = 5;
static int superpocion1 = 2;
static int pociones2 = 5;
static int superpocion2 = 2;
static int mochila ;
//Método Main
	public static void main(String[] args) {
//Creacion pokemon 
		Pokemon Vaporeon = new P_Agua("Dewgong", 207, 139, true);
		Pokemon Charmander = new P_Fuego("Charmander", 118, 116, true);
		Pokemon Piplup = new P_Agua("Piplup", 142, 112, true);
		Pokemon Arcanine = new P_Fuego("Arcanine", 207, 227, true);
		Pokemon Bulbasur = new P_Hoja("Bulbasaur", 128, 118, true);
		Pokemon Onix = new P_Tierra("Seismitoad", 233, 188, true);
		
		Pokemon Lumineon = new P_Agua("Lumineon", 170, 142, true);
		Pokemon Charmoleon = new P_Fuego("Charmeleon", 151, 158, true);
		Pokemon Oshawott = new P_Agua("Oshawott", 146, 117, true);
		Pokemon Entei = new P_Fuego("Typhlosion", 223, 186, true);
		Pokemon Sceptile   = new P_Hoja("Serperior", 235, 251, true);
		Pokemon Barboach = new P_Tierra("Rydhon", 223, 222, true);
//Poner los pokemon en el array 		
		J1[0] = Vaporeon;
		J1[1] = Charmander;
		J1[2] = Piplup;
		J1[3] = Arcanine;
		J1[4] = Bulbasur;
		J1[5] = Onix;
		
		J2[0] = Lumineon;
		J2[1] = Charmoleon;
		J2[2] = Oshawott;
		J2[3] = Entei;
		J2[4] = Sceptile;
		J2[5] = Barboach;
		
		menuPrincipal();
		juego();
		findeljuego();
	}
//Metodo turno dice el turno de quien es 
static void turno() {
	 if (turno == 0) {
		 turno = 0;
		 System.out.println("Es el turno del jugador 1 ");
	 }else {
		 turno = 1;
		 System.out.println("Es el turno del jugador 2");
	 }
}
//Metodo cambiar turno cambia el turno
static void cambiar_turno(){
	if (turno ==0) {
		turno ++;
		System.out.println("Es el turno del jugador 2 ");
	}else {
		turno  --;
		System.out.println("Es el turno del jugador 1 ");
	}
}
//Creacion de la funcion batalla_ataque 
//Pide dos parametros tipo Pokemon
static void batalla_ataque(Pokemon p1, Pokemon p2) {
	if(turno == 0) {
	//Si es el turno del jugador 1 ataca al jugador dos e imprime el nombre del pokemon con el que ha atacado
	p1.atacar(p2, p1.getfuerza());
	System.out.println("El jugador 1 ha atacado con " + J1[pok_act_1].getNombre());
	}else {
		//Si es el turno del jugador 2 ataca al jugador uno  e imprime el nombre del pokemon con el que ha atacado
	p1.atacar(p1,p2.getfuerza());
	System.out.println("El jugador 2 ha atacado con " + J2[pok_act_2].getNombre());
	}
	System.out.println();
	esperar();
}

//Metodo para ver el estado de los pokemons actuales 
//Pide dos objetos pokemon
static void ver_status_batalla(Pokemon p1, Pokemon p2) {
	System.out.println("--------------------------------------------------------");
	if (turno ==0) {
		System.out.println(p2.getNombre()+" "+ p2.getPh()+" "+p2.isEstado());
	}else {
	System.out.println(p1.getNombre() +" " + p1.getPh()+" "+p1.isEstado());
	}
	System.out.println("--------------------------------------------------------");
}
// Metodo que imprime turno del jugador 
static void imprimir_turno_jugador() {
	System.out.println("Turno del jugador " + turno );
}
//Este metodo sirve para que haya un segundo de delay
static void esperar() {
	try {
		Thread.sleep(1000);
	}catch(InterruptedException e) {}
}
//Metodo que imprime el menu
static void menu() {
	System.out.println("Que quiere hacer ? ");
	System.out.println("1)Ataque \t 2)Cambiar ");
	System.out.println("3)Bolsa \t 4) Huir" );
}
//Metodo que imprime el menu principal
static void menuPrincipal() {
	System.out.println("\t \t Bienviendo a POKEMON_01_JAVA");
	System.out.println("------------------------------------------------------");
	System.out.println("Empieza la batalla con  " + J1[pok_act_1].getNombre() + " vs " +J2[pok_act_1].getNombre());
	System.out.println("Empieza el jugador 1");
	esperar();
}
//Metodo donde se desarrolla la mochila 
static void mochila(){
	if (turno ==0) {
		System.out.println("1) " + pociones1 +" pocion normal (Incrementa la salud del pokemon actual en 10 ph) \t 2) " + superpocion1 + " superpocion (Incrementa la salud del pokemon en 20 ph \n"
				+ "3)Salir " );
		mochila = sc.nextInt();
		int pokemon = J1[pok_act_1].getPh();
		switch (mochila) {
		case 1:
			if(pociones1 !=0) {
			J1[pok_act_1].setph(J1[pok_act_1].getPh()+10);
			System.out.println("La vida de " + J1[pok_act_1].getNombre() + " pasa de " +pokemon +" ph a " + J1[pok_act_1].getPh()+ " ph.");
			pociones1 --;
			esperar();
			break;
			}else {
				System.out.println("Listillo que no tienes pociones");
				break;
			}
			
		case 2:
			if(superpocion1 !=0) {
			J1[pok_act_1].setph(J1[pok_act_1].getPh()+20);
			System.out.println("La vida de " + J1[pok_act_1].getNombre() + " pasa de " +pokemon +" ph a " + J1[pok_act_1].getPh()+ " ph.");
			superpocion1 --;
			break;
			}else {
				System.out.println("JAJAJAJA que no te quedan");
				
			}
		case 3:
			break;
		}
		esperar();
	}else {
		System.out.println("1) " + pociones2 +" pocion normal (Incrementa la salud del pokemon actual en 10 ph) \t 2) " + superpocion2 + " superpocion (Incrementa la salud del pokemon en 20 ph \n "
				+ "3)Salir " );
		  mochila = sc.nextInt();
		 int pokemon1 = J2[pok_act_2].getPh();
		switch (mochila) {
		case 1:
			if(pociones2 !=0) {
			J2[pok_act_2].setph(J2[pok_act_2].getPh()+10);
			System.out.println("La vida de " + J2[pok_act_2].getNombre() + " pasa de " + pokemon1 + " ph a " +J2[pok_act_2].getPh()+ " ph");
			pociones2 --;
			break;
			}else {
				System.out.println("Listillo que no tienes pociones");
				break;
			}
		case 2:
			if(superpocion2 !=0) {
			J2[pok_act_2].setph(J2[pok_act_2].getPh()+20);
			System.out.println("La vida de " + J2[pok_act_2].getNombre() + " pasa de " + pokemon1 + " ph a  " +J2[pok_act_2].getPh()+ "ph ");
			superpocion2 --;
			break;
			}else {
				System.out.println("JAJAJAJA que no te quedan");
			}
		case 3:
			break;
		}
		esperar();
		
	}
}
//En este metodo se desarrolla el juego 
static void juego() {
	do {
		menu();
		seleccion=sc.nextInt();
		switch (seleccion) {
		case 1:
			
			if(turno ==0) {
			if(J1[pok_act_1].isEstado()==true) {
				batalla_ataque((Pokemon)J1[pok_act_1], (Pokemon)J2[pok_act_2]);
				esperar();
				ver_status_batalla((Pokemon)J1[pok_act_1], (Pokemon)J2[pok_act_2]);
				cambiar_turno();
				esperar();
			}else {
				System.out.println("Tienes que cambiar de pokemon");
			}
			}else if(J2[pok_act_2].isEstado()==true){
			 
				batalla_ataque((Pokemon)J1[pok_act_1],(Pokemon)J2[pok_act_2]);
				esperar();
				ver_status_batalla((Pokemon)J1[pok_act_1], (Pokemon)J2[pok_act_2]);
				cambiar_turno();
				esperar();
			}else {
				System.out.println("Tienes que cambiar de pokemon");
			}
			break;
		case 2:
			int seleccion2 = 0;
			Pokemon clon[] = J1.clone();
			Pokemon clon2[] = J2.clone();
			esperar();
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Nombre " + " Vida " + " Daño " + " Estado");
			if (turno == 0) {
				for (int i = 0; i < J1.length; i++) {
					System.out.println(J1[i].getNombre() + " |" + J1[i].getPh() + " |" + J1[i].getfuerza() + " |" + J1[i].isEstado());	
				}
				System.out.println("Cual eliges?");
				seleccion2 = sc.nextInt();
				J1[0] = J1[seleccion2];
				J1[seleccion2] = clon[0];
				System.out.println("------------------------------------------------------------------------------");
				esperar();
				break;
			}else {
				for (int i = 0; i < J2.length; i++) {
					System.out.println(J2[i].getNombre() + " " + J2[i].getPh() + " " + J2[i].getfuerza() + " " + J2[i].isEstado());	
				}
				System.out.println("Cual eliges?");
				seleccion2 = sc.nextInt();
				J2[0] = J2[seleccion2];
				J2[seleccion2] = clon2[0];
				System.out.println("------------------------------------------------------------------------------");
				esperar();
				break;
			}
		case 3:
			esperar();
			mochila();
			break;
		}
	} while (seleccion != 4);
}

//Imprime el fin del juego 
static void findeljuego() {
	System.out.println("Ha finalizado el combate");
	System.out.println("\r\n"
			+ "               _,........__\r\n"
			+ "            ,-'            \"`-.\r\n"
			+ "          ,'                   `-.\r\n"
			+ "        ,'                        \\\r\n"
			+ "      ,'                           .\r\n"
			+ "      .'\\               ,\"\".       `\r\n"
			+ "     ._.'|             / |  `       \\\r\n"
			+ "     |   |            `-.'  ||       `.\r\n"
			+ "     |   |            '-._,'||       | \\\r\n"
			+ "     .`.,'             `..,'.'       , |`-.\r\n"
			+ "     l                       .'`.  _/  |   `.\r\n"
			+ "     `-.._'-   ,          _ _'   -\" \\  .     `\r\n"
			+ "`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\r\n"
			+ ".'        `\"-..___      __,'\\          \\  \\     \\\r\n"
			+ "\\_ .          |   `\"\"\"\"'    `.           . \\     \\\r\n"
			+ "  `.          |              `.          |  .     L\r\n"
			+ "    `.        |`--...________.'.        j   |     |\r\n"
			+ "      `._    .'      |          `.     .|   ,     |\r\n"
			+ "         `--,\\       .            `7\"\"' |  ,      |\r\n"
			+ "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\r\n"
			+ "             \\ `.     .          /      |  '      |  ,'          `.\r\n"
			+ "              \\  v.__  .        '       .   \\    /| /              \\\r\n"
			+ "               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\r\n"
			+ "                `        .        `._ ___,j.  `/ .-       ,---.     |\r\n"
			+ "                ,`-.      \\         .\"     `.  |/        j     `    |\r\n"
			+ "               /    `.     \\       /         \\ /         |     /    j\r\n"
			+ "              |       `-.   7-.._ .          |\"          '         /\r\n"
			+ "              |          `./_    `|          |            .     _,'\r\n"
			+ "              `.           / `----|          |-............`---'\r\n"
			+ "                \\          \\      |          |\r\n"
			+ "               ,'           )     `.         |\r\n"
			+ "                7____,,..--'      /          |\r\n"
			+ "                                  `---.__,--.'");
	System.out.println("Enrique poh favo,  Vamoh a calmarno");
}
}