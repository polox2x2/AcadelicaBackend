package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.DTO.Curso.CursoCreateDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoDTO;
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
    public ResponseEntity<CursoResponseDTO> crearCurso (@RequestBody  CursoCreateDTO dto){
        return ResponseEntity.ok(cursoService.crearCurso(dto));
    }
    @GetMapping("/lista")
    public ResponseEntity<List<CursoDetalleDTO>>obtenerCursos(){
        List<Curso>cursos = cursoService.buscarCurso();
        List<CursoDetalleDTO>detalleDTOS = CursoMappers.mapToList(cursos);
        return ResponseEntity.ok(detalleDTOS);
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<CursoResponseDTO>>obtenerCursoResponse(){
        List<Curso>cursos = cursoService.buscarCurso();
        List<CursoResponseDTO>responseDTOS =CursoMappers.mapToListResponse(cursos);
        return ResponseEntity.ok(responseDTOS);
    }
    @GetMapping("/cursos")
    public ResponseEntity<List<CursoDTO>>obtenerCursoDTO(){
        List<Curso>cursos = cursoService.buscarCurso();
        List<CursoDTO>dto = CursoMappers.mapToListDTO(cursos);
        return ResponseEntity.ok(dto);
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
