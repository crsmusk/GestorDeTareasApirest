package com.api.gestiondetareas.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.tareaNoEncontradaException;
import com.api.gestiondetareas.Map.tareaMapper;
import com.api.gestiondetareas.Model.DTOs.tareaDTO;
import com.api.gestiondetareas.Model.Entities.tarea;
import com.api.gestiondetareas.Repository.tareaRepository;
import com.api.gestiondetareas.Service.Interface.Itarea;
@Service
public class tareaServiceImpl implements Itarea{

    @Autowired
    private tareaRepository tareaRepo;
    @Autowired
    tareaMapper mapper;


    @Override
    public List<tareaDTO> findAll() {
        List<tareaDTO>tasks=mapper.toTareasDto(tareaRepo.findAll());
        return tasks;
    }


    @Override
    public List<tareaDTO> findByNombre(String nombre) {
       List<tarea>lista=tareaRepo.findByNombre(nombre).orElseThrow(()->new tareaNoEncontradaException("no se encontro una tarea con ese nombre"));
       List<tareaDTO>tareas=mapper.toTareasDto(lista);
       return tareas;
    }


    @Override
    public void save(tareaDTO tareaDTO) {
        tareaRepo.save(mapper.toTarea(tareaDTO));
    }


    @Override
    public void delete(Long id) {
        if (tareaRepo.existsById(id)) {
            tareaRepo.deleteById(id);
        }else{
            throw new tareaNoEncontradaException("no se econtro la tarea con el id "+id);
        }
       
    }


    @Override
    public tareaDTO findById(Long id) {
        tarea task=tareaRepo.findById(id).orElseThrow(()-> new tareaNoEncontradaException("no se encontro la tarea"));
        tareaDTO tarea=mapper.toTareaDto(task);
        return tarea;
    }


    @Override
    public List<tareaDTO> findByEstadoIsTrue() {
      List<tareaDTO>tareas=mapper.toTareasDto(tareaRepo.findAllByEstadoTrueOrderByFechaLimite());
      return tareas;
    }


    @Override
    public List<tareaDTO> findByEstadoIsFalse() {
        List<tareaDTO>tasks=mapper.toTareasDto(tareaRepo.findAllByEstadoFalseOrderByFechaLimite());
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
        
        tareaDTO task=mapper.toTareaDto(Tarea);
        return task;
    }

   

}
