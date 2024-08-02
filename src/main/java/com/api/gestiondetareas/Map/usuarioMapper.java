package com.api.gestiondetareas.Map;

import java.util.List;


import org.springframework.stereotype.Component;

import com.api.gestiondetareas.Model.DTOs.usuarioDTO;
import com.api.gestiondetareas.Model.Entities.usuario;

@Component
public class usuarioMapper {
   public usuarioDTO toUsuarioDto(usuario usuario){
    return usuarioDTO.builder()
    .email(usuario.getEmail())
    .password(usuario.getPassword())
    .nickname(usuario.getNickname())
    .build();
   }

   public List<usuarioDTO>toUsuariosDto(List<usuario>usuarios){
    return usuarios.stream().map(this::toUsuarioDto).toList();
   }

   public usuario toUsuario(usuarioDTO usuarioDTO){
    usuario usuario=new usuario();
    usuario.setEmail(usuarioDTO.getEmail());
    usuario.setPassword(usuarioDTO.getPassword());
    usuario.setNickname(usuarioDTO.getNickname());
    return usuario;
   }

}
