package org.springboot.jpa.santiago.backendchronoturner.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springboot.jpa.santiago.backendchronoturner.entities.Goal;
import org.springboot.jpa.santiago.backendchronoturner.entities.Priority;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("api/priority")
@Tag(name = "Priorities")
public class PriorityControllers {
        //Atributos de PriorityControllers
    @Autowired
    private PriorityService priorityService;

    //Constructores de PriorityControllers
    //Asignadores de atributos de PriorityControllers (setters)
    //Lectores de atributos de PriorityControllers (getters)
        //Métodos de PriorityControllers
    public ResponseEntity<List<Priority>> findAll(){
        List<Priority> priorities = this.priorityService.findAll();
        return ResponseEntity.ok(priorities);
    }

    @PostMapping
    public ResponseEntity<?> saveNewPriority(@RequestBody Priority priority){   //Dejar así un momento antes de añadir la anotación @Valid
        Priority newPriority = this.priorityService.save(priority);
        return ResponseEntity.ok("A new priority has been successfully logged in" /*+ newPriority.getId()*/);   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @RequestMapping(value = "/update/{id}", method = {PUT, PATCH})
    public ResponseEntity<?> updateGoal(@RequestBody Priority priority, @PathVariable String id){   //Dejar así un momento antes de añadir la anotación @Valid
        priority = this.priorityService.save(priority);
        return ResponseEntity.ok("This priority has been successfully updated. See you next time");   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePriority(@RequestBody String id){
        this.priorityService.deleteById(id);
        return ResponseEntity.ok("The priority has been successfully deleted");
    }
}

