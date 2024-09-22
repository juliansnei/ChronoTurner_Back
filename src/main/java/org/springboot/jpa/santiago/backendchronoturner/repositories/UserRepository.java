package org.springboot.jpa.santiago.backendchronoturner.repositories;

import org.springboot.jpa.santiago.backendchronoturner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    //Atributos de UserRepository
    //Constructores de UserRepository
    //Asignadores de atributos de UserRepository (setters)
    //Lectores de atributos de UserRepository (getters)
        //Métodos de UserRepository
    @Query("select u from User u where u.email =?1")
    public Optional<User> findByEmail(String email);
}
