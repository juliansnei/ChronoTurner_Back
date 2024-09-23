package org.springboot.jpa.santiago.backendchronoturner.repositories;

import org.springboot.jpa.santiago.backendchronoturner.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, String> {
    //Atributos de GoalRepository
    //Constructores de GoalRepository
    //Asignadores de atributos de GoalRepository (setters)
    //Lectores de atributos de GoalRepository (getters)
        //Métodos de GoalRepository
    //@Query("select g from Goal g where g.name like %?%")
    public List<Goal> findByNameContaining(String name);
}
