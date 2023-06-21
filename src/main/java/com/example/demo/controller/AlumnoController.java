package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Alumno;
import com.example.demo.service.AlumnoService;

@Controller
public class AlumnoController {

	private AlumnoService alumnoService;

	public AlumnoController(AlumnoService alumnoService) {
		super();
		this.alumnoService = alumnoService;
	}
	
	//metodo que gestione la lista de alumnos y la retorne a la vista
	@GetMapping("/alumnos")
	public String listarAlumnos(Model model) {
		model.addAttribute("alumnos", alumnoService.obtenerTodos());
		return "alumnos";
	}
	
	//altas
	@GetMapping("/alumnos/crear")
	public String crearAlumnoFormulario(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		return "crear_alumno";
	}
	
	@PostMapping("/alumnos")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoService.guardarAlumno(alumno);
		return "redirect:/alumnos";
	}
	
	//bajas
	@GetMapping("/alumnos/{numControl}")
	public String eliminarAlumno(@PathVariable String numControl) {
		alumnoService.eliminarAlumno(numControl);
		return "redirect:/alumnos";
	}
	
	//cambios
	@GetMapping("/alumnos/editar/{numControl}")
	public String editarAlumnoFormulario(@PathVariable String numControl, Model model) {
		model.addAttribute("alumno", alumnoService.obtenerAlumnoPorID(numControl));
		return "editar_alumno";
	}
	
	@PostMapping("/alumnos/{numControl}")
	public String actualizarAlumno(@PathVariable String numControl, @ModelAttribute("alumno") Alumno alumno, Model model) {
		// buscar alumno en la bd
		Alumno alumnoExistente = alumnoService.obtenerAlumnoPorID(numControl);
		
		alumnoExistente.setNombre(alumno.getNombre());
		alumnoExistente.setPrimerAp(alumno.getPrimerAp());
		alumnoExistente.setSegundoAp(alumno.getSegundoAp());
		alumnoExistente.setEdad(alumno.getEdad());
		alumnoExistente.setSemestre(alumno.getSemestre());
		alumnoExistente.setCarrera(alumno.getCarrera());
		
		//guardar alumno modificado
		alumnoService.modificarAlumno(alumnoExistente);
		return "redirect:/alumnos";
		
	}
	
	
	
}
