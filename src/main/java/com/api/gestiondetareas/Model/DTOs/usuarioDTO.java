package com.api.gestiondetareas.Model.DTOs;

import java.util.List;

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
public class usuarioDTO {
    private String userName;
    private String password;
    private String nickname;
    List<String>roles;
}
