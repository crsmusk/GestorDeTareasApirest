package com.api.gestiondetareas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gestiondetareas.Model.Entities.permiso;

@Repository
public interface permisosRepository extends JpaRepository<permiso,Long >{
Optional<permiso>findByNombreIgnoreCase(String nombre);
}
