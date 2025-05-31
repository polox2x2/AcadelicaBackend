package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.DTO.Curso.CursoCreateDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoDetalleDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoResponseDTO;
import com.Acadelica.proyecto.Mappers.CursoMappers;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController (CursoService cursoService){
        this.cursoService = cursoService;
    }




    //CRUD por DTO

    @PostMapping("/crear")
    public ResponseEntity<CursoResponseDTO> crearCurso (CursoCreateDTO dto){
        return ResponseEntity.ok(cursoService.crearCurso(dto));
    }
    @PostMapping("/obtener")
    public ResponseEntity<List<CursoDetalleDTO>>obtenerCursos(){
        List<Curso>cursos = cursoService.buscarCurso();
        List<CursoDetalleDTO>detalleDTOS = CursoMappers.mapToList(cursos);
        return ResponseEntity.ok(detalleDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDetalleDTO>obtenetPorId (@PathVariable Long id){
        CursoDetalleDTO curso = cursoService.obtenerPorId(id);
        return ResponseEntity.ok(curso);
    }
    @PutMapping("actualizar/curso/{id}")
    private ResponseEntity<?>actalizarCurso(@PathVariable Long id, @RequestBody CursoDetalleDTO dto){
        return ResponseEntity.ok(cursoService.upDateCurso(id,dto));
    }
    @PutMapping("/eliminar/{id}")
    private ResponseEntity<?>eliminarCurso(@PathVariable Long id){
        cursoService.deleteCurso(id);
        return ResponseEntity.ok("Curso eliminado Correctamente ");
    }

}
