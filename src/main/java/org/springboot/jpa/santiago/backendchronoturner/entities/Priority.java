package org.springboot.jpa.santiago.backendchronoturner.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springboot.jpa.santiago.backendchronoturner.utils.entityUtils.enumPriority.Name;

import java.util.List;

@Entity
@Table(name = "priorities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Priority {
        //Atributos de Priority
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Name name;
    private String description;
    @OneToMany(mappedBy = "priority")
    private List<Task> taskList;

    //Constructores de Priority
    //Asignadores de atributos de Priority (setters)
    //Lectores de atributos de Priority (getters)
    //Métodos de Priority
}
