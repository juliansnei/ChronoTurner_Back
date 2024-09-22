package org.springboot.jpa.santiago.backendchronoturner.repositories;

import org.springboot.jpa.santiago.backendchronoturner.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    //Atributos de TokenRepository
    //Constructores de TokenRepository
    //Asignadores de atributos de TokenRepository (setters)
    //Lectores de atributos de TokenRepository (getters)
        //Métodos de TokenRepository
    Optional<Token> findByToken(String token);
}
