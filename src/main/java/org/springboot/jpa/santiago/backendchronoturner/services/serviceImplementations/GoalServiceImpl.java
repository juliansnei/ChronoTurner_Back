package org.springboot.jpa.santiago.backendchronoturner.services.serviceImplementations;

import org.springboot.jpa.santiago.backendchronoturner.entities.Goal;
import org.springboot.jpa.santiago.backendchronoturner.repositories.GoalRepository;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GoalServiceImpl implements GoalService {
        //Atributos de GoalServiceImpl
    @Autowired
    private GoalRepository repoGoal;

    //Constructores de GoalServiceImpl
    //Asignadores de atributos de GoalServiceImpl (setters)
    //Lectores de atributos de GoalServiceImpl (getters)
        //Métodos de GoalServiceImpl
    @Override
    public List<Goal> findAll() {
        return this.repoGoal.findAll();
    }

    @Override
    public Optional<Goal> findById(String id) {
        return this.repoGoal.findById(id);
    }

    @Override
    public Goal findByNameContaining(String name) {
        return this.repoGoal.findByNameContaining(name.toLowerCase())
                .stream().findFirst()
                .orElseThrow();  //Para hacer una gestión de errores bien poderosa
    }

    @Override
    public Goal save(Goal goal) {
        return this.repoGoal.save(goal);
    }

    @Override
    public void delete(Goal goal) {
        this.repoGoal.delete(goal);
    }

    @Override
    public void deleteById(String id) {
        this.repoGoal.findById(id).ifPresentOrElse(
                g -> {this.repoGoal.deleteById(id);},
                () -> System.out.println("The goal you're trying to delete hasn't been found")  //Aquí también se puede arrojar una excepción bien poderosa
        );
    }
}
