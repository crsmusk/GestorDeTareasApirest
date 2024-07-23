package com.api.gestiondetareas.Model.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tareas")
public class tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;
 private String contenido;
 private boolean estado;
 private LocalDate fechaLimite;
   @ManyToOne
   @JoinColumn(name = "usuario_id")
   private usuario usuario;
   
   @ManyToOne
   @JoinColumn(name = "categoria_id")
   private categoria categoria;
    
   
  
}
