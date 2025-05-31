package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.Curso.CursoCreateDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoDetalleDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoResponseDTO;
import com.Acadelica.proyecto.Mappers.CursoMappers;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService (CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> buscarCurso(){
        return cursoRepository.findAll();
    }
    public Curso buscarPorId(Long id){
        return  cursoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el curso"));
    }


    //Crear Curso;
    public CursoResponseDTO crearCurso(CursoCreateDTO createDTO){
            Curso curso = CursoMappers.mapToCurso(createDTO);
            Curso create = cursoRepository.save(curso);
            return CursoMappers.mapToResponseDTO(create);
    }
    //lista detallada de curso
    public List<CursoDetalleDTO> cursoDetalleDTO(List<Curso>cursos){
        return CursoMappers.mapToList(cursos);
    }
    //obtener por id
    public CursoDetalleDTO obtenerPorId (Long id){
        Curso curso = cursoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No se encontro El curso"));
        return CursoMappers.mapToCursoDetalleDTO(curso);
    }



}
