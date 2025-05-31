package com.Acadelica.proyecto.Mappers;


import com.Acadelica.proyecto.DTO.Categoria.CategoriaCreateDTO;
import com.Acadelica.proyecto.DTO.Categoria.CategoriaResponseDTO;
import com.Acadelica.proyecto.Model.Categoria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMappers {


    public Categoria mapToCategoria(CategoriaCreateDTO dto){
        Categoria categoria = new Categoria();

        categoria.setNombre(dto.getNombre());
        categoria.setFechaCreacion(LocalDateTime.now());
        return categoria;
    }

    public static CategoriaResponseDTO mapToResponse(Categoria categoria){
        CategoriaResponseDTO dto = new CategoriaResponseDTO();
        dto.setNombre(categoria.getNombre());
        dto.setFechaCreacion(LocalDateTime.now());
        return dto;
    }
    public static void upDateCategoria(Categoria categoria,CategoriaResponseDTO dto){
        categoria.setNombre(dto.getNombre());
        categoria.setFechaCreacion(LocalDateTime.now());
    }
    public static List<CategoriaResponseDTO>mapToList(List<Categoria>cateogoria){
        return cateogoria.stream().map(
                CategoriaMappers::mapToResponse
        ).collect(Collectors.toList());
    }

}
