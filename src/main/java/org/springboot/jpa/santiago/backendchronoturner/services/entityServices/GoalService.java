package org.springboot.jpa.santiago.backendchronoturner.services.entityServices;

import org.springboot.jpa.santiago.backendchronoturner.entities.Goal;
import org.springboot.jpa.santiago.backendchronoturner.services.methodServices.*;

public interface GoalService extends FindAllService<Goal>,
                             FindByIdService<Goal, String>,
                             FindByNameService<Goal, String>,
                             SaveService<Goal>,
                             DeleteService<Goal, String> {
    //Atributos de GoalService
    //Constructores de GoalService
    //Asignadores de atributos de GoalService (setters)
    //Lectores de atributos de GoalService (getters)
    //Métodos de GoalService
}
