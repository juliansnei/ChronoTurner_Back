package org.springboot.jpa.santiago.backendchronoturner.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springboot.jpa.santiago.backendchronoturner.utils.entityUtils.enumGoal.GoalStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "goals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goal {
        //Atributos de Goal
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @Column(nullable=false)
    private LocalDateTime startDate;
    @Column(nullable=false)
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private GoalStatus status;
    @OneToMany(mappedBy = "goal")
    private List<Task> taskList;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    //Constructores de Goal
    //Asignadores de atributos de Goal (setters)
    //Lectores de atributos de Goal (getters)
        //Métodos de Goal
    @PrePersist
    public void GoalCreation() {
        if (this.startDate == null) {
            this.startDate = LocalDateTime.now();
        }
        this.status = GoalStatus.STARTED;
    }
}
