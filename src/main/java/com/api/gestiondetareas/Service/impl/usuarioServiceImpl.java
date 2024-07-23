package com.api.gestiondetareas.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.usuarioNoEncontradoException;
import com.api.gestiondetareas.Map.usuarioMapper;
import com.api.gestiondetareas.Model.DTOs.usuarioDTO;

import com.api.gestiondetareas.Model.Entities.usuario;
import com.api.gestiondetareas.Repository.usuarioRepository;
import com.api.gestiondetareas.Service.IusuarioDAO;
@Service
public class usuarioServiceImpl implements IusuarioDAO {

    @Autowired
    private usuarioRepository usuarioRepo;
    @Autowired
    usuarioMapper mapper;

    @Override
    public List<usuarioDTO> findAll() {
       List<usuarioDTO>list=usuarioRepo.findAll().stream().map(usuario->usuarioDTO.builder()
       .email(usuario.getEmail())
       .password(usuario.getPassword())
       .nickname(usuario.getNickname())
       .build()).toList();
       return list;
    }


    @Override
    public Optional<usuarioDTO> findByNickName(String nickname) {
        usuario user=usuarioRepo.findByNicknameIgnoreCase(nickname).orElseThrow(()-> new usuarioNoEncontradoException("no se encontro al usuario")); 
        usuarioDTO usuario=usuarioDTO.builder()
        .email(user.getEmail())
        .password(user.getPassword())
        .nickname(user.getNickname())
        .build();
        return Optional.of(usuario);
    }
       


    @Override
    public Optional<usuarioDTO> findByEmail(String email) {
       usuario user=usuarioRepo.findByEmailIgnoreCase(email).orElseThrow(()-> new usuarioNoEncontradoException("no se encontro al usuario"));
       usuarioDTO usuario=usuarioDTO.builder()
       .email(user.getEmail())
       .password(user.getPassword())
       .nickname(user.getNickname())
       .build();
       return Optional.of(usuario);
    }


    @Override
    public void save(usuarioDTO usuarioDTO) {
        usuario usuario=new usuario();
        usuario=mapper.toUsuario(usuarioDTO);
        usuarioRepo.save(usuario);
    }


    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }


    @Override
    public Optional<usuarioDTO> findById(long id) {
        usuario user=usuarioRepo.findById(id).orElseThrow(()-> new usuarioNoEncontradoException("no se encontro al usuario"));
        usuarioDTO usuario=usuarioDTO.builder()
        .email(user.getEmail())
        .password(user.getPassword())
        .nickname(user.getNickname())
        .build();
        return Optional.of(usuario);
    }

    @Override
    public usuarioDTO update(Long id, usuarioDTO usuarioDT) {
       usuario user=usuarioRepo.findById(id).orElseThrow(()->new usuarioNoEncontradoException("no se encontro al usuario con el id"+id));
       user.setEmail(usuarioDT.getEmail());
       user.setPassword(usuarioDT.getPassword());
       user.setNickname(usuarioDT.getNickname());

       usuarioDTO usuario=usuarioDTO.builder()
       .email(user.getEmail())
       .password(user.getPassword())
       .nickname(user.getNickname())
       .build();
        return usuario;
    }


}
