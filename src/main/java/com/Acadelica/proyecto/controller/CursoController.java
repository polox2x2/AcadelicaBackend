package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.DTO.Curso.CursoCreateDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoResponseDTO;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
