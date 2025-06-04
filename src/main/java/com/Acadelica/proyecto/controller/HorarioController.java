package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.DTO.Horario.HorarioCreateDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioDetalleDTO;
import com.Acadelica.proyecto.DTO.Horario.HorarioResponseDTO;
import com.Acadelica.proyecto.Mappers.HorarioMappers;
import com.Acadelica.proyecto.Model.Horario;
import com.Acadelica.proyecto.service.HorarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horario")
public class HorarioController {


    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping("/lista")
    public List<Horario>ObtenerHorario(){
        return horarioService.obtenerHorario();
    }
    //Crear Horario
    @PostMapping("/crear")
    public ResponseEntity<HorarioResponseDTO>crearHorario(@RequestBody HorarioCreateDTO dto){
            return ResponseEntity.ok(horarioService.crearHorario(dto));

    }
    @GetMapping("/obtener")
    public ResponseEntity<List<HorarioResponseDTO>>obtenerHorario(){
        List<Horario>horarios = horarioService.obtenerHorario();
        List<HorarioResponseDTO>responseDTOS =HorarioMappers.mapToListResponse(horarios);
        return ResponseEntity.ok(responseDTOS);
    }
    @GetMapping("/detalle")
    public ResponseEntity<List<HorarioDetalleDTO>>obtenerHorarioDetalle(){
        List<Horario>horarios = horarioService.obtenerHorario();
        List<HorarioDetalleDTO>detalleDTOS = HorarioMappers.mapToListDetalle(horarios);
        return ResponseEntity.ok(detalleDTOS);
    }

}
