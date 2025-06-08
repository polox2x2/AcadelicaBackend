package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.Profesor.ProfesorClassDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorCreateDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorDetalleDTO;
import com.Acadelica.proyecto.DTO.Profesor.ProfesorResponseDTO;
import com.Acadelica.proyecto.Mappers.ProfesorMappers;
import com.Acadelica.proyecto.Model.Profesor;
import com.Acadelica.proyecto.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import javax.swing.text.html.parser.Entity;
import java.util.List;



@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository){
        this.profesorRepository = profesorRepository;
    }

    public Profesor crearProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }
    public List<Profesor>buscarProfesor (){
        return profesorRepository.findAll();
    }
    public Profesor getProfesorById (Long idProfesor){
        return profesorRepository.findById(idProfesor).orElseThrow();
    }



    //Logica por DTO

    public ProfesorResponseDTO crearProfesor (ProfesorCreateDTO createDTO){
        Profesor profesor = ProfesorMappers.mapToProfesor(createDTO);
        Profesor create = profesorRepository.save(profesor);
        return ProfesorMappers.mapToResponse(create);
    }

    public List<ProfesorDetalleDTO> detalleDTO (List<Profesor> profesor){
        return ProfesorMappers.mapList(profesor);
    }

    public List<ProfesorClassDTO>ProfesorClass(List<Profesor>profesor){
        return ProfesorMappers.mapClass(profesor);
    }

    public Profesor upDateProfesor( Long id, ProfesorDetalleDTO detalleDTO){
        Profesor profesor = profesorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profesor no encontrado"));
        ProfesorMappers.upDateProfesor(profesor ,detalleDTO);
        return profesorRepository.save(profesor);
    }
    public Profesor upDateProfesorCorreo(Long id, ProfesorResponseDTO responseDTO){
        Profesor profesor = profesorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Correo no encontrado")
        );
        ProfesorMappers.upDateProfesorCorreo(profesor,responseDTO);
        return profesorRepository.save(profesor);
    }
    public void eliminaProfesor(Long id){
        Profesor profesor = profesorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profesor no Eliminado")
        );
        profesorRepository.deleteById(id);
    }




}
