package org.springboot.jpa.santiago.backendchronoturner.services.serviceImplementations;

import org.springboot.jpa.santiago.backendchronoturner.entities.Category;
import org.springboot.jpa.santiago.backendchronoturner.repositories.CategoryRepository;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
        //Atributos de CategoryServiceImpl
    @Autowired
    private CategoryRepository repoCategory;

    //Constructores de CategoryServiceImpl
    //Asignadores de atributos de CategoryServiceImpl (setters)
    //Lectores de atributos de CategoryServiceImpl (getters)
        //Métodos de CategoryServiceImpl
    @Override
    public List<Category> findAll() {
        return this.repoCategory.findAll();
    }

    @Override
    public Category save(Category category) {
        return this.repoCategory.save(category);
    }

    @Override
    public void delete(Category category) {
        this.repoCategory.delete(category);
    }

    @Override
    public void deleteById(String id) {
        this.repoCategory.findById(id).ifPresentOrElse(
                c -> {this.repoCategory.deleteById(id);},
                () -> System.out.println("The category you're trying to delete hasn't been found")  //Aquí también se puede arrojar una excepción bien poderosa
        );
    }
}