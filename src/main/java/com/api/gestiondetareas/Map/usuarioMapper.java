package com.api.gestiondetareas.Map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.gestiondetareas.Model.DTOs.usuarioDTO;
import com.api.gestiondetareas.Model.Entities.usuario;

@Mapper(componentModel = "spring")
public interface usuarioMapper {
    @Mappings({
        @Mapping(source = "email",target = "email"),
        @Mapping(source = "password",target = "password"),
        @Mapping(source = "nickname",target = "nickname"),
    })
    usuarioDTO toUsuarioDTO(usuario usuario);
    List<usuarioDTO>toUsuarioDTOs(List<usuario>usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "tareas",ignore = true)
    usuario toUsuario(usuarioDTO usuarioDTO);

}
