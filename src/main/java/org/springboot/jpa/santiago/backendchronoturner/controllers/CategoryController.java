package org.springboot.jpa.santiago.backendchronoturner.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springboot.jpa.santiago.backendchronoturner.entities.Category;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Tag(name = "Categories")
public class CategoryController {
        //Atributos de CategoryController
    @Autowired
    private CategoryService categoryService;

    //Constructores de CategoryController
    //Asignadores de atributos de CategoryController (setters)
    //Lectores de atributos de CategoryController (getters)
        //Métodos de CategoryController
    @GetMapping("/show-all")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = this.categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<?> saveNewGoal(@RequestBody Category category){   //Dejar así un momento antes de añadir la anotación @Valid
        Category newCategory = this.categoryService.save(category);
        return ResponseEntity.ok("A new category has been successfully logged in" /*+ newCategory.getId()*/);   //También se puede crear un interceptor para este método, de tal manera que devolvamos un Goal en lugar de un mensaje, y dejar el mensaje en el log
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@RequestBody String id){
        this.categoryService.deleteById(id);
        return ResponseEntity.ok("The category has been successfully deleted");
    }
}
