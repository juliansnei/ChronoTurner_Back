package org.springboot.jpa.santiago.backendchronoturner.services.methodServices;

public interface FindByNameService<Entity, ID> {
    //Atributos de FindByNameService
    //Constructores de FindByNameService
    //Asignadores de atributos de FindByNameService (setters)
    //Lectores de atributos de FindByNameService (getters)
        //Métodos de FindByNameService
    public Entity findByNameContaining(ID id);
}
