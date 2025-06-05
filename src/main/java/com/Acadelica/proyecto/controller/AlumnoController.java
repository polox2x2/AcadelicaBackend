package com.Acadelica.proyecto.controller;

import com.Acadelica.proyecto.DTO.Alumno.AlumnoCreateDTO;
import com.Acadelica.proyecto.DTO.Alumno.AlumnoDTO;
import com.Acadelica.proyecto.DTO.Alumno.AlumnoDetalleDTO;
import com.Acadelica.proyecto.DTO.Alumno.AlumnoResponseDTO;
import com.Acadelica.proyecto.Mappers.AlumnoMappers;
import com.Acadelica.proyecto.Model.Alumno;
import com.Acadelica.proyecto.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {


    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService=alumnoService;
    }
/*
@PostMapping("/crear")
public Alumno crearAlumnos(@RequestBody  Alumno alumno){
        return alumnoService.crearAlumnos(alumno);
}
*/
    

    @GetMapping("/activos")
    public ResponseEntity<List<Alumno>> listarActivos() {
        return ResponseEntity.ok(alumnoService.listarAlumnosActivos());
    }
   /** @GetMapping("/lista")
    public List<Alumno>listaAlumno(){
        return alumnoService.listaAlumno();
    }
    */


//  CRUD CON DTO
    @PostMapping("/crear")
    public ResponseEntity<AlumnoResponseDTO> crearAlumno (@RequestBody AlumnoCreateDTO dto){
        AlumnoResponseDTO creado = alumnoService.crearAlumno(dto);
        return ResponseEntity.status(201).body(creado);
    }
    @GetMapping("/lista")
    public ResponseEntity<List<AlumnoResponseDTO>>obtenerAlumnoResponse(){
        List<Alumno>alumnos=alumnoService.listaAlumno();
        List<AlumnoResponseDTO>responseDTOS = alumnoService.listaAlumno(alumnos);
        return ResponseEntity.ok(responseDTOS);
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<AlumnoDetalleDTO>>obtenerAlumnoDetalle(){
        List<Alumno>alumnos = alumnoService.listaAlumno();
        List<AlumnoDetalleDTO> alumnoDetalleDTOS= alumnoService.obtenerDetalleAlumno(alumnos);
        return ResponseEntity.ok(alumnoDetalleDTOS);
    }
    @GetMapping("/alumnos")
    public ResponseEntity<List<AlumnoDTO>>AlumnosList(){
        List<Alumno>alumnos=alumnoService.listaAlumno();
        List<AlumnoDTO>dto=alumnoService.Alumnos(alumnos);
        return ResponseEntity.status(201).body(dto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDetalleDTO> obtenerAlumnoPorId(@PathVariable Long id) {
        AlumnoDetalleDTO alumno = alumnoService.listarAlumnoPorId(id);
        return ResponseEntity.ok(alumno);
    }

    @PutMapping("actualizar/datos/{id}")
    public ResponseEntity<?>ActualizarAlumnoName(@PathVariable Long id, @RequestBody AlumnoDetalleDTO detalleDTO ){
        return ResponseEntity.ok(alumnoService.upDateAlumnoName(id,detalleDTO));
    }
    @PutMapping("actualizar/correo/{id}")
    public ResponseEntity<?>ActualizarAlumnoCorreo(@PathVariable Long id, @RequestBody AlumnoResponseDTO responseDTO){
        return ResponseEntity.ok(alumnoService.upDateAlumnoCorreo(id,responseDTO));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> EliminarAlumno(@PathVariable Long id){
        alumnoService.deleteAlumno(id);
        return ResponseEntity.ok("Alumno Eliminado Correctamente");
    }

}


