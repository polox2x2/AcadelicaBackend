package com.Acadelica.proyecto.controller;


import com.Acadelica.proyecto.Model.Horario;
import com.Acadelica.proyecto.service.HorarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
