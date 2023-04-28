package libreria.java.instituto;

public class Recibe {
	private int numMatricula;
	private int codAsignatura;
	private String cursoEscolar;
	
	public Recibe(int numMatricula, int codAsignatura, String cursoEscolar) {
		this.numMatricula = numMatricula;
		this.codAsignatura = codAsignatura;
		this.cursoEscolar = cursoEscolar;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public int getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public String getCursoEscolar() {
		return cursoEscolar;
	}

	public void setCursoEscolar(String cursoEscolar) {
		this.cursoEscolar = cursoEscolar;
	}

	@Override
	public String toString() {
		return "recibe [numMatricula=" + numMatricula + ", codAsignatura=" + codAsignatura + ", cursoEscolar="
				+ cursoEscolar + "]";
	}
	
	
	
}
