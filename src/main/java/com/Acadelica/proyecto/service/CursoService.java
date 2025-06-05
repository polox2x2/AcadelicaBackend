package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.Curso.CursoCreateDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoDetalleDTO;
import com.Acadelica.proyecto.DTO.Curso.CursoResponseDTO;
import com.Acadelica.proyecto.Mappers.CursoMappers;
import com.Acadelica.proyecto.Model.Categoria;
import com.Acadelica.proyecto.Model.Curso;
import com.Acadelica.proyecto.repository.CategoriaRepository;
import com.Acadelica.proyecto.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CategoriaRepository categoriaRepository;


    public List<Curso> buscarCurso(){
        return cursoRepository.findAll();
    }
    public Curso buscarPorId(Long id){
        return  cursoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el curso"));
    }

    //Crear Curso DTO
    public CursoResponseDTO crearCurso(CursoCreateDTO createDTO){

        Categoria categoria = categoriaRepository.findById(createDTO.getIdCategoria()).orElseThrow(
                () -> new RuntimeException("Categoria no encontrada"));
            Curso curso = CursoMappers.mapToCurso(createDTO ,categoria);
            Curso create = cursoRepository.save(curso);
            return CursoMappers.mapToResponseDTO(create);
    }


    //lista detallada de curso DTO
    public List<CursoDetalleDTO> cursoDetalleDTO(List<Curso>cursos){
        return CursoMappers.mapToList(cursos);
    }
    //obtener por id DTO
    public CursoDetalleDTO obtenerPorId (Long id){
        Curso curso = cursoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No se encontro El curso"));
        return CursoMappers.mapToCursoDetalleDTO(curso);
    }
    public List<CursoResponseDTO>cursoResponseDTO(List<Curso>cursos){
        return CursoMappers.mapToListResponse(cursos);
    }

    //obtener CursoDTO

    public List<CursoDTO>cursoDTO(List<Curso>cursos){
        return CursoMappers.mapToListDTO(cursos);
    }


    //Actualizar Curso DTO
    public Curso upDateCurso(Long id, CursoDetalleDTO detalleDTO){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no Encontrado"));
        CursoMappers.upDateCurso(curso,detalleDTO);
        return cursoRepository.save(curso);
    }
    public void deleteCurso(Long id){
        Curso curso = cursoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No se encontro el curso"));
        cursoRepository.delete(curso);
    }

}
