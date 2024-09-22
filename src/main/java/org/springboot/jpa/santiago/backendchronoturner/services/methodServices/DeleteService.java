package org.springboot.jpa.santiago.backendchronoturner.services.methodServices;

public interface DeleteService<Entity, ID> {
    //Atributos de RemoveService
    //Constructores de RemoveService
    //Asignadores de atributos de RemoveService (setters)
    //Lectores de atributos de RemoveService (getters)
        //Métodos de RemoveService
    public void delete(Entity entity);
    public void deleteById(ID id);
}
