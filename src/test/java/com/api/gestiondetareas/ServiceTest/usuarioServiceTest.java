package com.api.gestiondetareas.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.gestiondetareas.Exception.usuarioNoEncontradoException;
import com.api.gestiondetareas.Map.usuarioMapper;
import com.api.gestiondetareas.Model.DTOs.usuarioDTO;
import com.api.gestiondetareas.Model.Entities.usuario;
import com.api.gestiondetareas.Repository.usuarioRepository;
import com.api.gestiondetareas.Service.impl.usuarioServiceImpl;

@SpringBootTest
public class usuarioServiceTest {
  private usuarioDTO usuarioDTOEsperado;
  private Optional<usuario> usuario;

  @Autowired
  usuarioServiceImpl usuarioService;
  @Autowired
  usuarioRepository usuarioRepo;
  @Autowired
  usuarioMapper mapper;

  @BeforeEach
  public void setUp(){
    usuarioDTOEsperado=new usuarioDTO();
    usuarioDTOEsperado.setEmail("pepe@Gmail.com");
    usuarioDTOEsperado.setPassword("patronum");
    usuarioDTOEsperado.setNickname("supremo");

    usuarioService.save(usuarioDTOEsperado);
  }
  @Test
  public void usuario_find_by_id(){
    usuario=usuarioRepo.findByNicknameIgnoreCase("supremo");
    Optional<usuarioDTO> usuarioDTOPtenido=usuarioService.findById(usuario.get().getId());

    assertTrue(usuarioDTOPtenido.isPresent());
    assertEquals(usuarioDTOEsperado, usuarioDTOPtenido.get());
  }

  @Test
  public void usuario_find_by_nickname(){
    Optional<usuarioDTO> usuarioDTOPtenido=usuarioService.findByNickName("supremo");

    assertTrue(usuarioDTOPtenido.isPresent());
    assertEquals(usuarioDTOEsperado, usuarioDTOPtenido.get());
  }

  @Test
  public void usuario_find_by_email(){
    Optional<usuarioDTO> usuarioDTOPtenido=usuarioService.findByEmail("pepe@Gmail.com");

    assertTrue(usuarioDTOPtenido.isPresent());
    assertEquals(usuarioDTOEsperado, usuarioDTOPtenido.get());
  }

  @Test
  public void usuario_update(){
    usuario=usuarioRepo.findByNicknameIgnoreCase("supremo");
    usuarioDTOEsperado.setNickname("Overlord");
    usuarioService.update(usuario.get().getId(), usuarioDTOEsperado);

    Optional<usuarioDTO>usuarioDtoObtenido=usuarioService.findByNickName("overlord");

    assertTrue(usuarioDtoObtenido.isPresent());
    assertEquals(usuarioDTOEsperado, usuarioDtoObtenido.get() );
  }

  @Test 
  public void usuario_test_find_id_exception(){
     assertThrows(usuarioNoEncontradoException.class, ()->{
      usuarioService.findById(67L);
     });
  }


  @AfterEach
  public void delete(){
    usuario=usuarioRepo.findByNicknameIgnoreCase(usuarioDTOEsperado.getNickname());
    usuarioRepo.deleteById(usuario.get().getId());
  }

}
