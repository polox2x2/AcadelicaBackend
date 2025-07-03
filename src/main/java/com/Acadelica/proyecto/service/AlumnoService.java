package com.Acadelica.proyecto.service;

import com.Acadelica.proyecto.DTO.Alumno.*;
import com.Acadelica.proyecto.Mappers.AlumnoMappers;
import com.Acadelica.proyecto.Model.Alumno;
import com.Acadelica.proyecto.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private static final Logger log = LoggerFactory.getLogger(AlumnoService.class);
    private  final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }


    public List<Alumno> listarAlumnosActivos() {
        return alumnoRepository.findByEstadoTrue();
    }
    public List<Alumno> listaAlumno(){
        return alumnoRepository.findAll();
    }


        //Logica para crear Alumno , utilizando DTO Y MAPPERS

    public  AlumnoResponseDTO crearAlumno(AlumnoCreateDTO dto){
        Alumno alumno = AlumnoMappers.mapToAlumno(dto); // le damos los valores del constructormapAlumno al objeto alumno de la clase alumno.
        Alumno crear = alumnoRepository.save(alumno);
        return AlumnoMappers.mapToResponseDTO(crear);
    }
    // Logica para obtener los datos Detallados utilizando DTO y MAPPERS
    public List<AlumnoDetalleDTO> obtenerDetalleAlumno(List<Alumno>alumnos){
        return AlumnoMappers.mapList(alumnos);
    }

    //obtener por ID
    public AlumnoDetalleDTO listarAlumnoPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        return AlumnoMappers.mapToDetalleDTO(alumno);
    }
    public List<AlumnoResponseDTO>listaAlumno(List<Alumno>alumnos){
        return AlumnoMappers.mapToList(alumnos);
    }
    public List<AlumnoDTO>Alumnos(List<Alumno>alumnos){
        return AlumnoMappers.ListAlumno(alumnos);
    }


    //Logica para actualizar los nombres, utilizando DTO Y MAPPERS

    public  Alumno upDateAlumnoName (Long id , AlumnoDetalleDTO detalleDTO){
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        AlumnoMappers.upDateAlumnoName(alumno,detalleDTO);
        return alumnoRepository.save(alumno);
    }
    //Logica para actualizar el correo, utilizando DTO Y MAPPERS
        public Alumno upDateAlumnoCorreo(Long id, AlumnoResponseDTO responseDTO){
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        AlumnoMappers.upDateAlumnoCorreo(alumno,responseDTO);
        return alumnoRepository.save(alumno);
        }


    // Logica para eliminar por completo al Alumno por ID
    public void deleteAlumno(Long id){
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Alumno no se encuntra"));
         alumnoRepository.delete(alumno);
    }

    //Logica para el Login

    public AlumnoLoginDTO Login(String correo , String clave){
        Optional<Alumno> alumnoOptional= alumnoRepository.findByCorreo(correo);
        if(alumnoOptional.isPresent()){
            Alumno alumno = alumnoOptional.get();
            if (alumno.getClave().equals(clave)){
                return AlumnoMappers.mapToLoginDTO(alumno);
            }

        }
            throw new RuntimeException("Correo o clave incorrecta");

    }
    //Logica para buscar por correo
    public AlumnoDetalleDTO obtenerAlumnoPorCorreo(String correo){
    Alumno alumno = alumnoRepository.findByCorreo(correo).orElseThrow(
            () -> new RuntimeException("Alumno no encontrado")
    );
    return AlumnoMappers.mapToDetalleDTO(alumno);
    }

    /*
    * Buscar Alumnos por id y marcar como conectado
    */
        @Transactional
    public Optional<Alumno>buscaryConectar(Long AlumnoId){

            Optional<Alumno>alumnoOptional = alumnoRepository.findById(AlumnoId);

        if(alumnoOptional.isPresent() && alumnoOptional.get().isEstado()){
            Alumno alumno = alumnoOptional.get();
            alumnoRepository.save(alumno);

            log.info("Alumno conectado: {}-{}",alumno.getId(),alumno.getNombre());
            return Optional.of(alumno);
        }
            log.warn("Intento de Conexion con ID invalido o inactivo : {}",AlumnoId);
            return  Optional.empty();
        }

        //validar si esta activo o si existe

        public boolean exiteYEstaActivo(Long alumnoId){
        return alumnoRepository.existsByIdAndEstadoTrue(alumnoId);
        }



}
