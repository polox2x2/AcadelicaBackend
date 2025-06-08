package com.Acadelica.proyecto.service;


import com.Acadelica.proyecto.DTO.Categoria.CategoriaCreateDTO;
import com.Acadelica.proyecto.DTO.Categoria.CategoriaResponseDTO;
import com.Acadelica.proyecto.Mappers.CategoriaMappers;
import com.Acadelica.proyecto.Model.Categoria;

import com.Acadelica.proyecto.repository.CategoriaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService (CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponseDTO crearCategoria (CategoriaCreateDTO dto){
        Categoria categoria = CategoriaMappers.mapToCategoria(dto);
        Categoria crear = categoriaRepository.save(categoria);
        return CategoriaMappers.mapToResponse(crear);
    }


    public List<Categoria> listarCategoria(){
        return categoriaRepository.findAll();
    }
    public List<CategoriaResponseDTO>categoriaLista(List<Categoria>categorias ){
        return CategoriaMappers.mapToList(categorias);

    }
    public Categoria upDateCategoria(Long id,CategoriaResponseDTO dto){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro La categoria"));
        CategoriaMappers.upDateCategoria(categoria,dto);
        return categoriaRepository.save(categoria);
    }


}
