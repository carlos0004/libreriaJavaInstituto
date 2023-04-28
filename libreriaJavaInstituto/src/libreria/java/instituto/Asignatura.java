package libreria.java.instituto;

public class Asignatura {
	private int codAsignatura;
	private String nombre;
	private String profesor;
	private int dniProfesor;
	
	public Asignatura(int codAsignatura, String nombre, String profesor, int dniProfesor) {
		this.codAsignatura = codAsignatura;
		this.nombre = nombre;
		this.profesor = profesor;
		this.dniProfesor = dniProfesor;
	}

	public int getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(int dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	@Override
	public String toString() {
		return "Asignatura [codAsignatura=" + codAsignatura + ", nombre=" + nombre + ", profesor=" + profesor
				+ ", dniProfesor=" + dniProfesor + "]";
	}

	
}
