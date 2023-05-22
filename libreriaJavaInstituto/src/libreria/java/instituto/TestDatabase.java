package libreria.java.instituto;
/**
 * Clase de pruebas
 * @author carlos
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;


public class TestDatabase {
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:mysql://localhost/instituto?" + "user=root&password=usuario");
		
		
		DatabaseManager dataBaseManager = new DatabaseManager(databaseConnection);
		ColunmOrder colunmOrderAlumno = new ColunmOrder("numMatricula", "DESC");
		ColunmOrder colunmOrder2Alumno = new ColunmOrder("nombre", "ASC");
		ColunmOrder colunmOrderProfesor = new ColunmOrder("nombre", "ASC");
		ColunmOrder colunmOrderAsignatura = new ColunmOrder("codAsignatura", "ASC");

		
		ArrayList<Alumno> Alumnos = new ArrayList<>();
		Alumnos = dataBaseManager.getAlumnos();
		Alumnos.stream().forEach(b->System.out.println(b));
		Alumnos = dataBaseManager.getAlumnos( new ColunmOrder[] {colunmOrderAlumno, colunmOrder2Alumno});
		Alumnos.stream().forEach(b->System.out.println(b));
		
		ArrayList<Profesor> Profesores = new ArrayList<>();
		Profesores= dataBaseManager.getProfesores();
		Profesores.stream().forEach(b->System.out.println(b));
		Profesores= dataBaseManager.getProfesores(colunmOrderProfesor);
		Profesores.stream().forEach(b->System.out.println(b));
		
		ArrayList<Asignatura> Asignaturas = new ArrayList<>();
		Asignaturas = dataBaseManager.getAsignaturas(colunmOrderAsignatura);
		Asignaturas.stream().forEach(b->System.out.println(b));
		Asignaturas = dataBaseManager.getAsignaturas();
		Asignaturas.stream().forEach(b->System.out.println(b));

		
		Conversor conversor = new Conversor();
		conversor.profesoresToXml(dataBaseManager.getProfesores());
		conversor.alumnoToXml(dataBaseManager.getAlumnos());
		conversor.asignaturatoXml(dataBaseManager.getAsignaturas());
		
		


	}

}
