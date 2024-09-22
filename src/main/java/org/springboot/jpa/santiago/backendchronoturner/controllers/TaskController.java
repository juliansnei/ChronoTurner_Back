package org.springboot.jpa.santiago.backendchronoturner.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springboot.jpa.santiago.backendchronoturner.entities.Task;
import org.springboot.jpa.santiago.backendchronoturner.entities.User;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@Tag(name = "Tasks")
public class TaskController {
        //Atributos de TaskController
    @Autowired
    private TaskService taskService;

    //Constructores de TaskController
    //Asignadores de atributos de TaskController (setters)
    //Lectores de atributos de TaskController (getters)
        //Métodos de TaskController
    @GetMapping("/show-all")
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = this.taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id) {
        Task task = this.taskService.findById(id).orElseThrow();//Para un manejo de excepciones bien poderoso
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<?> saveNewUser(@RequestBody Task task){   //Dejar así un momento antes de añadir la anotación @Valid
        Task newtask = this.taskService.save(task);
        return ResponseEntity.ok("A new task has been successfully logged in" /*+ newTask.getId()*/);   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@RequestBody String id){
        this.taskService.deleteById(id);    //Acá se captura la excepción, en caso tal de que ocurra
        return ResponseEntity.ok("The user has been successfully deleted");
    }
}
