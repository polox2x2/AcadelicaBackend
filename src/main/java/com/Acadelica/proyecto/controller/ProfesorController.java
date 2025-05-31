package com.Acadelica.proyecto.controller;

import com.Acadelica.proyecto.DTO.Profesor.ProfesorClassDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorCreateDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorDetalleDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorResponseDTO;
import com.Acadelica.proyecto.Model.Profesor;
import com.Acadelica.proyecto.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService){
        this.profesorService = profesorService;
    }


   /* @PostMapping("/crear")
    public Profesor crearProfesor (Profesor profesor){
        return profesorService.crearProfesor(profesor);
    }*/

    @GetMapping("/buscar")
    public List<Profesor>buscarProfesro(){
        return profesorService.buscarProfesor();
    }
    @GetMapping("/buscar/[id]")
    public  Profesor getProfesorById (Long id){
        return profesorService.getProfesorById(id);
    }

    //CRUD CON DTO


    @PostMapping("/crear")
    public ResponseEntity<ProfesorResponseDTO> ProfesorCreate (@RequestBody ProfesorCreateDTO createDTO){
            ProfesorResponseDTO create = profesorService.crearProfesor(createDTO);
            return ResponseEntity.status(201).body(create);
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<ProfesorDetalleDTO>> obtenerProfesor(){
        List<Profesor>profesor = profesorService.buscarProfesor();
        List<ProfesorDetalleDTO>detalleDTOS = profesorService.detalleDTO(profesor);
        return ResponseEntity.ok(detalleDTOS);
    }
    @GetMapping("/clases")
    public  ResponseEntity<List<ProfesorClassDTO>>profesorClass(){
        List<Profesor>profesor = profesorService.buscarProfesor();
        List<ProfesorClassDTO>classDTOS = profesorService.ProfesorClass(profesor);
        return ResponseEntity.ok(classDTOS);
    }
    @PutMapping("/actualizar/datos/{id}")
    public ResponseEntity<?>ActualizarProfesor(@PathVariable Long id, @RequestBody ProfesorDetalleDTO detalleDTO){
        return ResponseEntity.ok(profesorService.upDateProfesor(id,detalleDTO));
    }
    @PutMapping("/actualizar/correo/{id}")
    public ResponseEntity<?>ActualizarProfesorCorreo(@PathVariable Long id, @RequestBody ProfesorResponseDTO responseDTO){
        return ResponseEntity.ok(profesorService.upDateProfesorCorreo(id,responseDTO));
    }
    @DeleteMapping("/eliminar/profesor/{id}")
    public ResponseEntity<?>EliminarProfesor(@PathVariable Long id){
        profesorService.eliminaProfesor(id);
        return ResponseEntity.ok("Profesor Eliminado");
    }



}
