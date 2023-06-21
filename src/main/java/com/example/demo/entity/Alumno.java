package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumnos")

public class Alumno {
	
	@Id
	private String numControl;
	
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Column(name = "Primer_Ap", nullable = false)
	private String primerAp;
	
	@Column(name = "Segundo_Ap", nullable = false)
	private String segundoAp;
	
	@Column(name = "Carrera", nullable = false)
	private String carrera;
	
	@Column(name = "Edad", nullable = false)
	private byte edad;
	
	@Column(name = "Semestre", nullable = false)
	private byte semestre;

	public Alumno() {}
	public Alumno(String numControl, String nombre, String primerAp, String segundoAp, String carrera, byte edad,
			byte semestre) {
		super();
		this.numControl = numControl;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.carrera = carrera;
		this.edad = edad;
		this.semestre = semestre;
	}


	public String getNumControl() {
		return numControl;
	}

	public void setNumControl(String numControl) {
		this.numControl = numControl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerAp() {
		return primerAp;
	}

	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}

	public String getSegundoAp() {
		return segundoAp;
	}

	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public byte getSemestre() {
		return semestre;
	}

	public void setSemestre(byte semestre) {
		this.semestre = semestre;
	}
	
	
	
	
	
	
}
