package com.api.gestiondetareas.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tareas")
public class tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String categoria;
 private String nombre;
 private String contenido;
 private boolean estado;
 private LocalDate fechaLimite;
 public Long getId() {
     return id;
 }
 public void setId(Long id) {
     this.id = id;
 }
 public String getCategoria() {
     return categoria;
 }
 public void setCategoria(String categoria) {
     this.categoria = categoria;
 }
 public String getContenido() {
     return contenido;
 }
 public void setContenido(String contenido) {
     this.contenido = contenido;
 }
 public boolean isEstado() {
     return estado;
 }
 public void setEstado(boolean estado) {
     this.estado = estado;
 }
 public LocalDate getFechaLimite() {
     return fechaLimite;
 }
 public void setFechaLimite(LocalDate fechaLimite) {
     this.fechaLimite = fechaLimite;
 }
 public String getNombre() {
     return nombre;
 }
 public void setNombre(String nombre) {
     this.nombre = nombre;
 }
 
  
}
