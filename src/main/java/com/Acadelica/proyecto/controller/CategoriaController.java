package com.Acadelica.proyecto.controller;

import com.Acadelica.proyecto.DTO.Categoria.CategoriaCreateDTO;
import com.Acadelica.proyecto.DTO.Categoria.CategoriaResponseDTO;
import com.Acadelica.proyecto.Model.Categoria;
import com.Acadelica.proyecto.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController (CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    @GetMapping("/lista")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.listarCategoria();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping("/crear")
    public ResponseEntity<CategoriaResponseDTO>crearCategoria (@RequestBody CategoriaCreateDTO dto){
        CategoriaResponseDTO responseDTO = categoriaService.crearCategoria(dto);
        return ResponseEntity.status(201).body(responseDTO);
    }

    // 2. Listar todas las categorías con DTO }
    @GetMapping("/obtener")
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategoriasDTO() {
        List<Categoria> categorias = categoriaService.listarCategoria();
        List<CategoriaResponseDTO> listaDTO = categoriaService.categoriaLista(categorias);
        return ResponseEntity.ok(listaDTO);
    }


    @PutMapping("actualizar/curso/{id}")
    public ResponseEntity<?>actualizarCategoria (@PathVariable Long id , @RequestBody CategoriaResponseDTO responseDTO){
        return ResponseEntity.ok(categoriaService.upDateCategoria(id,responseDTO));




    }

}
