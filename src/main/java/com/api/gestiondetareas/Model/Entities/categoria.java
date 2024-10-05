package com.api.gestiondetareas.Model.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

    @Column(name = "nombre_categoria",unique = true)
    private String nombreCategoria;
    @OneToMany(mappedBy = "categoria")
    private List<tarea>tareas;
   
}
