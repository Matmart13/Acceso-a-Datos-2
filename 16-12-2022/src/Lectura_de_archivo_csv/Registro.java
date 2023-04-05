package Lectura_de_archivo_csv;

public class Registro {
	String nombre;
	String apellido;
	int edad;
	char genero;
		public Registro() {
			// TODO Auto-generated constructor stub
		}
		public Registro(String _nombre,String _apellido, int _edad, char _genero) {
			// TODO Auto-generated constructor stub
			this.nombre = _nombre;
			this.apellido = _apellido;
			this.edad = _edad;
			this.genero = _genero;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public char getGenero() {
			return genero;
		}
		public void setGenero(char genero) {
			this.genero = genero;
		}
		
}
