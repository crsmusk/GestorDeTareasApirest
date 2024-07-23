package com.api.gestiondetareas.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.tareaNoEncontradaException;
import com.api.gestiondetareas.Map.tareaMapper;
import com.api.gestiondetareas.Model.DTOs.tareaDTO;
import com.api.gestiondetareas.Model.Entities.tarea;
import com.api.gestiondetareas.Repository.tareaRepository;
import com.api.gestiondetareas.Service.ItareaDAO;
@Service
public class tareaServiceImpl implements ItareaDAO{

    @Autowired
    private tareaRepository tareaRepo;
    @Autowired
    tareaMapper mapper;


    @Override
    public List<tareaDTO> findAll() {
        List<tareaDTO>tasks=tareaRepo.findAll().stream().map(tarea->tareaDTO.builder()
        .nombre(tarea.getNombre())
        .estado(tarea.isEstado())
        .fechaLimite(tarea.getFechaLimite())
        .contenido(tarea.getContenido())
        .build()).toList();
        return tasks;
    }


    @Override
    public Optional<List<tareaDTO>> findByNombre(String nombre) {
       List<tarea>lista=tareaRepo.findByNombre(nombre).orElseThrow(()->new tareaNoEncontradaException("no se encontro una tarea con ese nombre"));
       List<tareaDTO>tareas=lista.stream().map(tarea->tareaDTO.builder()
       .nombre(tarea.getNombre())
       .estado(tarea.isEstado())
       .fechaLimite(tarea.getFechaLimite())
       .contenido(tarea.getContenido())
       .build()).toList();
       return Optional.of(tareas);
    }


    @Override
    public void save(tareaDTO tareaDTO) {
        tarea tarea=new tarea();
        tarea=mapper.toTarea(tareaDTO);
        tareaRepo.save(tarea);
        
    }


    @Override
    public void delete(Long id) {
       tareaRepo.deleteById(id);
    }


    @Override
    public Optional<tareaDTO> findById(Long id) {
        tarea task=tareaRepo.findById(id).orElseThrow(()-> new tareaNoEncontradaException("no se encontro la tarea"));
        tareaDTO tarea=tareaDTO.builder()
        .nombre(task.getNombre())
        .contenido(task.getContenido())
        .estado(task.isEstado())
        .fechaLimite(task.getFechaLimite())
        .build();
        return Optional.of(tarea);
    }


    @Override
    public List<tareaDTO> findByEstadoIsTrue() {
      List<tareaDTO>tareas=tareaRepo.findAllByEstadoTrueOrderByFechaLimite().stream().map(tarea-> tareaDTO.builder()
      .nombre(tarea.getNombre())
      .estado(tarea.isEstado())
      .fechaLimite(tarea.getFechaLimite())
      .contenido(tarea.getContenido())
      .build()).toList();
      return tareas;
    }


    @Override
    public List<tareaDTO> findByEstadoIsFalse() {
        List<tareaDTO>tasks=tareaRepo.findAllByEstadoFalseOrderByFechaLimite().stream().map(tarea-> tareaDTO.builder()
        .nombre(tarea.getNombre())
        .estado(tarea.isEstado())
        .fechaLimite(tarea.getFechaLimite())
        .contenido(tarea.getContenido())
        .build()).toList();
        return tasks;
    }


    @Override
    public tareaDTO update(Long id, tareaDTO tarea) {
        tarea Tarea=tareaRepo.findById(id).orElseThrow(()->new tareaNoEncontradaException("no se encontro la tarea con el id "+id));
        Tarea.setNombre(tarea.getNombre());
        Tarea.setContenido(tarea.getContenido());
        Tarea.setEstado(tarea.isEstado());
        Tarea.setFechaLimite(tarea.getFechaLimite());
        tareaRepo.save(Tarea);
        
        tareaDTO task=tareaDTO.builder()
        .nombre(Tarea.getNombre())
        .contenido(Tarea.getContenido())
        .estado(Tarea.isEstado())
        .fechaLimite(Tarea.getFechaLimite())
        .build();
        return task;
    }

   

}
