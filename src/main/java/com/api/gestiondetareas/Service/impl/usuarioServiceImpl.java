package com.api.gestiondetareas.Service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.rolNoEncontradoException;
import com.api.gestiondetareas.Exception.usuarioNoEncontradoException;
import com.api.gestiondetareas.Map.usuarioMapper;
import com.api.gestiondetareas.Model.DTOs.usuarioDTO;
import com.api.gestiondetareas.Model.Entities.rol;
import com.api.gestiondetareas.Model.Entities.usuario;
import com.api.gestiondetareas.Repository.rolRepository;
import com.api.gestiondetareas.Repository.usuarioRepository;
import com.api.gestiondetareas.Service.Interface.Iusuario;
@Service
public class usuarioServiceImpl implements Iusuario  {

    @Autowired
    private usuarioRepository usuarioRepo;
    @Autowired
    usuarioMapper mapper;
    @Autowired
    rolRepository rolRepos;

    @Override
    public List<usuarioDTO> findAll() {
       List<usuarioDTO>list=mapper.toUsuariosDto(usuarioRepo.findAll());
       return list;
    }


    @Override
    public usuarioDTO findByNickName(String nickname) {
        usuario user=usuarioRepo.findByNicknameIgnoreCase(nickname).orElseThrow(()-> new usuarioNoEncontradoException("no se encontro al usuario")); 
        usuarioDTO usuario=mapper.toUsuarioDto(user);
        return usuario;
    }
       


    @Override
    public usuarioDTO findByEmail(String email) {
       usuario user=usuarioRepo.findByUserNameIgnoreCase(email).orElseThrow(()-> new usuarioNoEncontradoException("no se encontro al usuario"));
       usuarioDTO usuario=mapper.toUsuarioDto(user);
       return usuario;
    }


    @Override
    public void save(usuarioDTO usuarioDTO) {
        usuario usuario=mapper.toUsuario(usuarioDTO);
         List<rol>lista=new ArrayList<>();
         for(String rol:usuarioDTO.getRoles()){
            if (rolRepos.findByNombreIgnoreCase(rol).isPresent()) {
                lista.add(rolRepos.findByNombreIgnoreCase(rol).get());
            }else{
                throw new rolNoEncontradoException("no se encontro el rol con el nombre "+rol);
            }
         }
         usuario.setRoles(lista);
    }


    @Override
    public void delete(Long id) {
        if (usuarioRepo.existsById(id)) {
             usuarioRepo.deleteById(id);
        }else{
            throw new usuarioNoEncontradoException("no se encontro el usuario con el id "+id);
        }
       
    }


    @Override
    public usuarioDTO findById(long id) {
        usuario user=usuarioRepo.findById(id).orElseThrow(()-> new usuarioNoEncontradoException("no se encontro al usuario"));
        usuarioDTO usuario=mapper.toUsuarioDto(user);
        return usuario;
    }

    @Override
    public usuarioDTO update(Long id, usuarioDTO usuarioDT) {
       usuario user=usuarioRepo.findById(id).orElseThrow(()->new usuarioNoEncontradoException("no se encontro al usuario con el id"+id));
       user.setUserName(usuarioDT.getUserName());
       user.setPassword(usuarioDT.getPassword());
       user.setNickname(usuarioDT.getNickname());
       List<rol>lista=new ArrayList<>();
       for(String rol:usuarioDT.getRoles()){
        if (rolRepos.findByNombreIgnoreCase(rol).isPresent()) {
            lista.add(rolRepos.findByNombreIgnoreCase(rol).get());
        }else{
            throw new rolNoEncontradoException("no se encontro el rol con el nombre "+rol);
        }
        
       }
       user.setRoles(lista);
       usuarioRepo.save(user);
       usuarioDTO usuario=mapper.toUsuarioDto(user);
        return usuario;
    }


    
     
    
}
