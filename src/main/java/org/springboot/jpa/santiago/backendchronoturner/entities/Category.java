package org.springboot.jpa.santiago.backendchronoturner.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
        //Atributos de Category
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String colour;
    @OneToMany(mappedBy = "category")
    private List<Task> taskList;

    //Constructores de Category
    //Asignadores de atributos de Category (setters)
    //Lectores de atributos de Category (getters)
    //Métodos de Category
}
