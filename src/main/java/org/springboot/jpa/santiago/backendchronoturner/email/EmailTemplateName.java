package org.springboot.jpa.santiago.backendchronoturner.email;

import lombok.Getter;

@Getter
public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activate_account");

        //Atributos de EmailTemplateName
    private final String name;

        //Constructores de EmailTemplateName
    EmailTemplateName(String name) {
            this.name = name;
    }

    //Asignadores de atributos de EmailTemplateName (setters)
    //Lectores de atributos de EmailTemplateName (getters)
    //Métodos de EmailTemplateName
}
