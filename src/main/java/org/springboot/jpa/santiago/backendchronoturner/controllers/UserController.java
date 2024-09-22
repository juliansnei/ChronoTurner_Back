package org.springboot.jpa.santiago.backendchronoturner.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springboot.jpa.santiago.backendchronoturner.entities.User;
import org.springboot.jpa.santiago.backendchronoturner.exceptions.EntityNotFoundException;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@Tag(name = "Users")
public class UserController {
        //Atributos de UserController
    @Autowired
    private UserService userService;

    //Constructores de UserController
    //Asignadores de atributos de UserController (setters)
    //Lectores de atributos de UserController (getters)
        //Métodos de UserController
    @GetMapping("/show/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = this.userService.findById(id)
                .orElseThrow(
                    () -> new EntityNotFoundException("Error! The user you're looking for does not exist")
                );  //Para un manejo de excepciones bien poderoso
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> saveNewUser(@RequestBody User user){   //Dejar así un momento antes de añadir la anotación @Valid
        User newUser = this.userService.save(user);
        return ResponseEntity.ok("A new user has been successfully logged in" /*+ newUser.getId()*/);   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@RequestBody String id){
        this.userService.deleteById(id);    //Acá se captura la excepción, en caso tal de que ocurra
        return ResponseEntity.ok("The user has been successfully deleted");
    }
}
