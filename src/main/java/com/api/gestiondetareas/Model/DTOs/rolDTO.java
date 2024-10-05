package com.api.gestiondetareas.Model.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class rolDTO {
  String nombre;
  List<String>permisos;
}
