package com.api.gestiondetareas.Model.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class usuarioDTO {
    @NotBlank(message = "este espacio no puede ir en blanco")
    private String email;
    @NotBlank(message = "este espacio no puede ir en blanco")
    private String password;
    private String nickname;
}
