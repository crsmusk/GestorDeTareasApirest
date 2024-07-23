package com.api.gestiondetareas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestiondetareas.Model.Entities.usuario;
@Repository
public interface usuarioRepository extends JpaRepository<usuario,Long>{


   Optional<usuario>findByNicknameIgnoreCase(String nickname);
   
   Optional<usuario>findByEmailIgnoreCase(String email);

}
