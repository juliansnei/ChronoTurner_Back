package org.springboot.jpa.santiago.backendchronoturner.services.serviceImplementations;

import org.springboot.jpa.santiago.backendchronoturner.entities.Task;
import org.springboot.jpa.santiago.backendchronoturner.repositories.TaskRepository;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
        //Atributos de TaskServiceImpl
    @Autowired
    private TaskRepository repoTask;

    //Constructores de TaskServiceImpl
    //Asignadores de atributos de TaskServiceImpl (setters)
    //Lectores de atributos de TaskServiceImpl (getters)
        //Métodos de TaskServiceImpl
    @Override
    public List<Task> findAll() {
        return this.repoTask.findAll();
    }

    @Override
    public Optional<Task> findById(String id) {
        return this.repoTask.findById(id);
    }

    @Override
    public Task save(Task task) {
        return this.repoTask.save(task);
    }

    @Override
    public void delete(Task task) {
        this.repoTask.delete(task);
    }

    @Override
    public void deleteById(String id) {
        this.repoTask.findById(id).ifPresentOrElse(
                t -> {this.repoTask.deleteById(id);},
                () -> System.out.println("The task you're trying to delete hasn't been found")  //Aquí también se puede arrojar una excepción bien poderosa
        );
    }
}
