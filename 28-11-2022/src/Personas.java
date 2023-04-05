

public class Personas implements Comparable<Personas> {
	String nombre;
	int Dni;
	String apellidos;
	Integer nota;
	int curso;
	
	public Personas() {
		// TODO Auto-generated constructor stub
		
	}
	public Personas(String nombre, int dni, String apellidos, Integer nota, int curso) {
		this.nombre = nombre;
		this.Dni = dni;
		this.apellidos = apellidos;
		this.nota = nota;
		this.curso = curso;
	}
	@Override
	public int compareTo(Personas o) {
		// TODO Auto-generated method stub
		
		return(this.nota).compareTo(o.getNota());
		
	}
	
	
	public int compareToNombre(Personas p) {
		if(Ejercicio2.a == 1) {
			return(this.nombre).compareTo(p.getNombre());
		}else {	
			return(this.nota).compareTo(p.getNota());
		}
		
	}
	public boolean equals(Personas p) {
		
		return(this.nombre).equals(p.getNombre());
	}
	
	//Getters and Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	
	
}
