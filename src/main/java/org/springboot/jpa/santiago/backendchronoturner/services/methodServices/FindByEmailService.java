package org.springboot.jpa.santiago.backendchronoturner.services.methodServices;

import java.util.Optional;

public interface FindByEmailService<Entity, Email> {
    //Atributos de FindByEmailService
    //Constructores de FindByEmailService
    //Asignadores de atributos de FindByEmailService (setters)
    //Lectores de atributos de FindByEmailService (getters)
        //Métodos de FindByEmailService
    public Optional<Entity> findByEmail(Email email);
}
