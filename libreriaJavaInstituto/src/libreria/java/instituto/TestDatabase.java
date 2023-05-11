package libreria.java.instituto;

import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;


public class TestDatabase {
	public static void main(String[] args) {
		DatabaseConnection databaseConnection = new DatabaseConnection();
		
		if(databaseConnection.connect("jdbc:mysql://localhost/instituto?" + "user=root&password=usuario"));
		
		DatabaseManager dataBaseManager = new DatabaseManager(databaseConnection.getConnection());
		System.out.println(databaseConnection.isConnected());
		ColunmOrder colunmOrderAlumno = new ColunmOrder("numMatricula", "ASC");
		ColunmOrder colunmOrderProfesor = new ColunmOrder("nombre", "ASC");
		ColunmOrder colunmOrderAsignatura = new ColunmOrder("codAsignatura", "ASC");

		
		ArrayList<Alumno> Alumnos = new ArrayList<>();
		Alumnos = dataBaseManager.getAlumnos();
		Alumnos.stream().forEach(b->System.out.println(b));
		Alumnos = dataBaseManager.getAlumnos(colunmOrderAlumno);
		Alumnos.stream().forEach(b->System.out.println(b));
		
		ArrayList<Profesor> Profesores = new ArrayList<>();
		Profesores= dataBaseManager.getProfesores();
		Profesores.stream().forEach(b->System.out.println(b));
		Profesores= dataBaseManager.getProfesores(colunmOrderProfesor);
		Profesores.stream().forEach(b->System.out.println(b));
		
		ArrayList<Asignatura> Asignaturas = new ArrayList<>();
		Asignaturas = dataBaseManager.getAsignaturas(colunmOrderAsignatura);
		Asignaturas.stream().forEach(b->System.out.println(b));

		
		Conversor conversor = new Conversor();
		conversor.sqlToXml(dataBaseManager.getProfesores());
		System.out.println(dataBaseManager.getProfesores());
	}

}
