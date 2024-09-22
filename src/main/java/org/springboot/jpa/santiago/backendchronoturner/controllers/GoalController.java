package org.springboot.jpa.santiago.backendchronoturner.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springboot.jpa.santiago.backendchronoturner.entities.Goal;
import org.springboot.jpa.santiago.backendchronoturner.exceptions.EntityNotFoundException;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("api/goal")
@Tag(name = "Goals")
public class GoalController {
        //Atributos de GoalController
    @Autowired
    private GoalService goalService;

    //Constructores de GoalController
    //Asignadores de atributos de GoalController (setters)
    //Lectores de atributos de GoalController (getters)
        //Métodos de GoalController
    @GetMapping("/show-all")
    public ResponseEntity<List<Goal>> findAll(){
        List<Goal> goals = this.goalService.findAll();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Goal> findById(@PathVariable String id){
        Goal goal = this.goalService.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Error! The goal you're looking for hasn't been registered")
                );    //Para un manejo de excepciones bien poderoso
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/show-like/{name}")
    public ResponseEntity<Goal> findByNameContaining(@PathVariable String name){
        Goal goalLike = this.goalService.findByNameContaining(name);
        return ResponseEntity.ok(goalLike);
    }

    @PostMapping
    public ResponseEntity<?> saveNewGoal(@RequestBody Goal goal){   //Dejar así un momento antes de añadir la anotación @Valid
        Goal newGoal = this.goalService.save(goal);
        return ResponseEntity.ok("A new goal has been successfully logged in" /*+ newGoal.getId()*/);   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @RequestMapping(value = "/update/{id}", method = {PUT, PATCH})
    public ResponseEntity<?> updateGoal(@RequestBody Goal goal, @PathVariable String id){
        goal = this.goalService.save(goal);
        return ResponseEntity.ok("This goal has been successfully updated. See you next time");   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGoal(@RequestBody String id){
        this.goalService.deleteById(id);    //Acá se captura la excepción, en caso tal de que ocurra
        return ResponseEntity.ok("The goal has been successfully deleted");
    }
}
