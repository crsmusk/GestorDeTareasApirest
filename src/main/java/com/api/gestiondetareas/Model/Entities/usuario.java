package com.api.gestiondetareas.Model.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "users")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

   @Column(unique=true)
 private String userName;
 private String password;
 @Column(name = "is_enable")
 private Boolean isEnable;
 @Column(name = "account_no_expired")
 private Boolean accountNoExpired;
 @Column(name = "account_no_locked")
 private Boolean accountNoLocked;
 @Column(name = "credential_no_expired")
 private Boolean credentialNoExpired;
 
   @Column(unique = true) 
 private String nickname;
   @OneToMany(mappedBy = "usuario")
   private List<tarea> tareas;
   @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   @JoinTable(
    name = "roles_user",joinColumns =@JoinColumn(name = "usuario_id"),inverseJoinColumns = @JoinColumn(name="role_id")
   )
   private List<rol>roles;
}
