package com.api.gestiondetareas.Map;

import java.util.List;


import org.springframework.stereotype.Component;

import com.api.gestiondetareas.Model.DTOs.tareaDTO;
import com.api.gestiondetareas.Model.Entities.tarea;

@Component
public class tareaMapper {

    public tareaDTO toTareaDto(tarea tarea){
        return tareaDTO.builder()
        .nombre(tarea.getNombre())
        .estado(tarea.isEstado())
        .contenido(tarea.getContenido())
        .fechaLimite(tarea.getFechaLimite())
        .build();
    }

    public List<tareaDTO>toTareasDto(List<tarea>tareas){
        return tareas.stream().map(this::toTareaDto).toList();
    }

    public tarea toTarea(tareaDTO tareaDTO){
        tarea tarea=new tarea();
        tarea.setNombre(tareaDTO.getNombre());
        tarea.setEstado(tareaDTO.isEstado());
        tarea.setContenido(tareaDTO.getContenido());
        tarea.setFechaLimite(tareaDTO.getFechaLimite());
        return tarea;

    }
    
}
