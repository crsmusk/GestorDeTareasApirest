package com.api.gestiondetareas.Model.DTOs;

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
public class usuarioDTO {
    @NotBlank(message = "este espacio no puede ir en blanco")
    private String email;
    private String password;
    private String nickname;
}
