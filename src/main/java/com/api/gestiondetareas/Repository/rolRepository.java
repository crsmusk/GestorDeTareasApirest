package com.api.gestiondetareas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestiondetareas.Model.Entities.rol;

@Repository
public interface rolRepository extends JpaRepository<rol,Long>{

  Optional<rol>findByNombreIgnoreCase(String nombre);
}
