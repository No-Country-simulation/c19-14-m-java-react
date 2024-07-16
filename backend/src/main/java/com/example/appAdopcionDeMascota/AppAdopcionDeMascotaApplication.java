package com.example.appAdopcionDeMascota;

import com.example.appAdopcionDeMascota.entity.Permission;
import com.example.appAdopcionDeMascota.entity.Role;
import com.example.appAdopcionDeMascota.entity.RoleEnum;
import com.example.appAdopcionDeMascota.entity.User;
import com.example.appAdopcionDeMascota.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AppAdopcionDeMascotaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAdopcionDeMascotaApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			// CREATE PERMISSIONS
			Permission createPermission = Permission.builder()
					.name("CREATE")
					.build();

			Permission readPermission = Permission.builder()
					.name("READ")
					.build();

			Permission updatePermission = Permission.builder()
					.name("UPDATE")
					.build();

			Permission deletePermission = Permission.builder()
					.name("DELETE")
					.build();

			Permission adoptPermission = Permission.builder()
					.name("ADOPT")
					.build();

			Permission adoptionPermission = Permission.builder()
					.name("ADOPTION")
					.build();

			// CREATE ROLES
			Role roleAdmin = Role.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
			Role roleAdopter = Role.builder()
					.roleEnum(RoleEnum.USER_ADOPTER)
					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission, adoptPermission))
					.build();
			Role roleShelter = Role.builder()
					.roleEnum(RoleEnum.USER_SHELTER)
					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission, adoptionPermission))
					.build();

			//CREATE USERS
			User userJuanPerez = User.builder()
					.username("admin")
					.password("admin")
					.name("Juan")
					.surname("Perez")
					.age(30)
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			User userLeandroCantero = User.builder()
					.username("leandro")
					.password("1234")
					.name("Leandro")
					.surname("Cantero")
					.age(24)
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleAdopter))
					.build();
			User userLeonardoVargas = User.builder()
					.username("leonardo")
					.password("4321")
					.name("Leonardo")
					.surname("Vargas")
					.age(25)
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleAdopter, roleShelter))
					.build();

			//SAVE USERS
			userRepository.saveAll(List.of(userJuanPerez, userLeandroCantero, userLeonardoVargas));
		};
	}*/
}
