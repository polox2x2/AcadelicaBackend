package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.Model.Horario;
import com.Acadelica.proyecto.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public  HorarioService (HorarioRepository horarioRepository){
        this.horarioRepository = horarioRepository;
    }

    public List<Horario>obtenerHorario(){
        return  horarioRepository.findAll();
    }

    public Horario crearHorario(Horario horario){
        return horarioRepository.save(horario);
    }


}
