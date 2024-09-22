package org.springboot.jpa.santiago.backendchronoturner.repositories;

import org.springboot.jpa.santiago.backendchronoturner.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    //Atributos de RoleRepository
    //Constructores de RoleRepository
    //Asignadores de atributos de RoleRepository (setters)
    //Lectores de atributos de RoleRepository (getters)
        //Métodos de RoleRepository
    Optional<Role> findByName(String role);
}
