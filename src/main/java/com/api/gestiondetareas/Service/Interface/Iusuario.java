package com.api.gestiondetareas.Service.Interface;

import java.util.List;


import com.api.gestiondetareas.Model.DTOs.usuarioDTO;


public interface Iusuario {

 public List<usuarioDTO>findAll();

  public usuarioDTO findByNickName(String nickname);

  public  usuarioDTO findByEmail(String email);

  public void save(usuarioDTO usuarioDTO);

  public void delete(Long id);

  public  usuarioDTO findById(long id);

  public usuarioDTO update(Long id,usuarioDTO usuarioDT);

  

  
}
