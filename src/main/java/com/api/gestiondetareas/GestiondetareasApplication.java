package com.api.gestiondetareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.api.gestiondetareas")
public class GestiondetareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiondetareasApplication.class, args);
	}
   /*  @Bean
	public CommandLineRunner inicio(usuarioRepository userRepository){
		return args->{
			permisos readPermiso=permisos.builder()
			.nombre("READ")
			.build();

			permisos createPermiso=permisos.builder()
			.nombre("CREATE")
			.build();

			permisos deletePermiso=permisos.builder()
			.nombre("DELETE")
			.build();

			permisos updatePermiso=permisos.builder()
			.nombre("UPDATE")
			.build();

			rol admin=rol.builder()
			.nombre("ADMIN")
			.permisos(List.of(deletePermiso,createPermiso,readPermiso,updatePermiso))
			.build();
			
			rol user=rol.builder()
			.nombre("USER")
			.permisos(List.of(readPermiso,createPermiso))
			.build();

			usuario pedro=usuario.builder()
			.userName("Pedri")
			.nickname("Caillu")
			.password("1234")
			.accountNoExpired(true)
			.accountNoLocked(true)
			.credentialNoExpired(true)
			.isEnable(true)
			.roles(List.of(admin))
			.build();

			usuario  juan=usuario .builder()
			.nickname("juan134")
			.userName("juan")
			.password("0987")
			.accountNoExpired(true)
			.accountNoLocked(true)
			.credentialNoExpired(true)
			.isEnable(true)
			.roles(List.of(user))
			.build();
           userRepository.saveAll(List.of(juan,pedro));
		};
	}*/
	

}
