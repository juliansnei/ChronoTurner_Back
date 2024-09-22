package org.springboot.jpa.santiago.backendchronoturner.services.methodServices;

import java.util.Optional;

public interface FindByIdService<Entity, ID> {
    //Atributos de FindByIdService
    //Constructores de FindByIdService
    //Asignadores de atributos de FindByIdService (setters)
    //Lectores de atributos de FindByIdService (getters)
        //Métodos de FindByIdService
    public Optional<Entity> findById(ID id);
}
