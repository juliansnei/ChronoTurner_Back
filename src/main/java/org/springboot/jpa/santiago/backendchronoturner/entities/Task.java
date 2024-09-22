package org.springboot.jpa.santiago.backendchronoturner.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springboot.jpa.santiago.backendchronoturner.utils.entityUtils.enumTask.SubtaskStatus;
import org.springboot.jpa.santiago.backendchronoturner.utils.entityUtils.enumTask.TaskStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
        //Atributos de Task
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    /*@Column(nullable = false)*/   //Si no, habrá problemos con el DTO
    private String description;
    @Column(nullable = false)
    private LocalDateTime expirationDate;
        @Enumerated(EnumType.STRING)
        private TaskStatus taskStatus;  //Revisar entre todos la pertinencia de este atributo, lo veo innecesario
        @Enumerated(EnumType.STRING)
        private SubtaskStatus subtaskStatus;
    @ManyToOne  //Corregir cardinalidad
    @JoinColumn(name = "priority_id")
    private Priority priority;    //Una Task, una Priority
    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Constructores de Task
    //Asignadores de atributos de Task (setters)
    //Lectores de atributos de Task (getters)
    //Métodos de Task
}
