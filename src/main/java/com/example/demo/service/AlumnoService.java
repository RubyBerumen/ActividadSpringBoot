package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;

public interface AlumnoService {
	
	//Altas
	Alumno guardarAlumno(Alumno alumno);
	
	//Bajas
	boolean eliminarAlumno(String id);
	
	//Cambios
	Alumno modificarAlumno(Alumno alumno);
	
	//Consultas
	List<Alumno> obtenerTodos(); //getAll
	Alumno obtenerAlumnoPorID(String id);
	
}
