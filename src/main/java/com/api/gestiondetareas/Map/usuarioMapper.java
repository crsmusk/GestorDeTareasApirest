package com.api.gestiondetareas.Map;

import java.util.List;


import org.springframework.stereotype.Component;

import com.api.gestiondetareas.Model.DTOs.usuarioDTO;
import com.api.gestiondetareas.Model.Entities.usuario;

@Component
public class usuarioMapper {
   public usuarioDTO toUsuarioDto(usuario usuario){
    return usuarioDTO.builder()
    .userName(usuario.getUserName())
    .password(usuario.getPassword())
    .nickname(usuario.getNickname())
    .roles(usuario.getRoles().stream().map(rol->rol.getNombre()).toList())
    .build();
   }

   public List<usuarioDTO>toUsuariosDto(List<usuario>usuarios){
    return usuarios.stream().map(this::toUsuarioDto).toList();
   }

   public usuario toUsuario(usuarioDTO usuarioDTO){
    usuario usuario=new usuario();
    usuario.setUserName(usuarioDTO.getUserName());
    usuario.setPassword(usuarioDTO.getPassword());
    usuario.setNickname(usuarioDTO.getNickname());
    return usuario;
   }

}
