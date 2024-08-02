package com.api.gestiondetareas.Model.DTOs;

import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class tareaDTO {
   @NotBlank(message = "este campo no puede estar en blanco")
 private String nombre;
 private String contenido;
 private boolean estado;
 private LocalDate fechaLimite;
}
