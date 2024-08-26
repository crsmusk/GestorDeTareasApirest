package com.api.gestiondetareas.Service.Interface;

import java.util.List;
import java.util.Optional;

import com.api.gestiondetareas.Model.DTOs.usuarioDTO;


public interface Iusuario {

 public List<usuarioDTO>findAll();

  public Optional<usuarioDTO>findByNickName(String nickname);

  public Optional<usuarioDTO>findByEmail(String email);

  public void save(usuarioDTO usuarioDTO);

  public void delete(Long id);

  public Optional<usuarioDTO>findById(long id);

  public usuarioDTO update(Long id,usuarioDTO usuarioDT);

  
}
