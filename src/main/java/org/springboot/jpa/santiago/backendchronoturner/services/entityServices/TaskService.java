package org.springboot.jpa.santiago.backendchronoturner.services.entityServices;

import org.springboot.jpa.santiago.backendchronoturner.entities.Task;
import org.springboot.jpa.santiago.backendchronoturner.services.methodServices.*;

public interface TaskService extends FindAllService<Task>,
                             FindByIdService<Task, String>,
                             SaveService<Task>,
        DeleteService<Task, String> {
    //Atributos de TaskService
    //Constructores de TaskService
    //Asignadores de atributos de TaskService (setters)
    //Lectores de atributos de TaskService (getters)
    //Métodos de TaskService
}
