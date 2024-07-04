package com.api.gestiondetareas.Entidades.DTO;

import java.time.LocalDate;


//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
///import lombok.Setter;
@Data
@Builder
public class tareaDTO {
    //@NotBlank(message = "este espacio no puede estar en blanco")
 private String categoria;
   //@NotBlank(message = "este campo no puede estar en blanco")
 private String nombre;
    //@NotBlank(message = "este espacio no puede estar en blanco")
 private String contenido;
    //@NotNull(message = "este espacio debe estar definido")
 private boolean estado;
    //@NotNull(message = "este espacio debe estar definido ")
 private LocalDate fechaLimite;
}
