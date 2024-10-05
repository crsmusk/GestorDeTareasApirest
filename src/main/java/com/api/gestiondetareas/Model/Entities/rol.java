package com.api.gestiondetareas.Model.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "roles")
public class rol {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
   
  private String nombre;
  
  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="permission_id"))
  private List<permiso>permisos;
}
