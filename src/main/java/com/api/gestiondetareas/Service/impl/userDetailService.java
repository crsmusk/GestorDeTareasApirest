package com.api.gestiondetareas.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.gestiondetareas.Exception.usuarioNoEncontradoException;

import com.api.gestiondetareas.Model.Entities.usuario;
import com.api.gestiondetareas.Repository.usuarioRepository;
@Service
public class userDetailService implements UserDetailsService{

    @Autowired
    usuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario usuario=usuarioRepo.findByUserNameIgnoreCase(username).orElseThrow(()->new usuarioNoEncontradoException("no se encontro el usuario con el nombre "+username));
        List<SimpleGrantedAuthority>authoritiesList=new ArrayList<>();
        usuario.getRoles()
        .forEach(rol->authoritiesList.add(new SimpleGrantedAuthority("ROLE_".concat(rol.getNombre()))));
        
        usuario.getRoles().stream()
        .flatMap(rol->rol.getPermisos().stream()).forEach(permisos->authoritiesList.add(new SimpleGrantedAuthority(permisos.getNombre())));

        return new User(usuario.getUserName(),usuario.getPassword(),usuario.getIsEnable()
        ,usuario.getAccountNoExpired(),usuario.getAccountNoLocked()
        ,usuario.getCredentialNoExpired(),authoritiesList);
    }

}
