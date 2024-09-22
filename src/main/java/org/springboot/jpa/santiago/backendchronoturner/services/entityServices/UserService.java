package org.springboot.jpa.santiago.backendchronoturner.services.entityServices;

import org.springboot.jpa.santiago.backendchronoturner.entities.User;
import org.springboot.jpa.santiago.backendchronoturner.services.methodServices.*;

public interface UserService extends FindByIdService<User, String>,
                                     FindByEmailService<User, String>,
                                     SaveService<User>,
                                     DeleteService<User, String> {
    //Atributos de UserService
    //Constructores de UserService
    //Asignadores de atributos de UserService (setters)
    //Lectores de atributos de UserService (getters)
    //Métodos de UserService
}
