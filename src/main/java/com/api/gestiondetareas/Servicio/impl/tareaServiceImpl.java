package com.api.gestiondetareas.Servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.gestiondetareas.Entidades.tarea;
import com.api.gestiondetareas.Entidades.DTO.tareaDTO;
import com.api.gestiondetareas.Repositorio.tareaRepository;
import com.api.gestiondetareas.Servicio.ItareaDAO;
@Service
public class tareaServiceImpl implements ItareaDAO{

    @Autowired
    private tareaRepository tareaRepo;

    public List<tarea> findAll() {
        return tareaRepo.findAll();
    }

    @Override
    public Optional<tarea> findByNombre(String nombre) {
        return tareaRepo.findByNombre(nombre);
    }

    @Override
    public void save(tareaDTO tareaDTO) {
      tarea tarea=new tarea();
      tarea.setCategoria(tareaDTO.getCategoria());
      tarea.setNombre(tareaDTO.getNombre());
      tarea.setContenido(tareaDTO.getContenido());
      tarea.setEstado(tareaDTO.isEstado());
      tarea.setFechaLimite(tareaDTO.getFechaLimite());
      tareaRepo.save(tarea);
    }

    @Override
    public void delete(Long id) {
       tareaRepo.deleteById(id);
       
    }

    @Override
    public Optional<tarea> findById(Long id) {
       return tareaRepo.findById(id);
    }

    @Override
    public List<tarea> findByCategoria(String categoria) {
        return tareaRepo.findByCategoria(categoria);
    }

    @Override
    public List<tarea> findByEstadoIsTrue(){
       return tareaRepo.encontrarTareasCompletadas();
    }

    @Override
    public List<tarea> findByEstadoIsFalse() {
       return tareaRepo.encontrarTareasNoCompletadas();
    }

    @Override
    public tarea update(Long id, tareaDTO tarea) {
       tarea Tarea=tareaRepo.findById(id).orElseThrow(()->new RuntimeException("no se encontro la tarea con el id "+id));
       Tarea.setCategoria(tarea.getCategoria());
       Tarea.setContenido(tarea.getContenido());
       Tarea.setEstado(tarea.isEstado());
       Tarea.setNombre(tarea.getNombre());
       Tarea.setFechaLimite(tarea.getFechaLimite());
        return tareaRepo.save(Tarea);
        
    }

}
