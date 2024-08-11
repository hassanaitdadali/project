package com.sportreservation.optimisationdeslivraison.Entities;

import com.sportreservation.optimisationdeslivraison.utilities.CustomIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
public class Trucks {
    @Id
    @Column(name = "matricule", updatable = false, nullable = false)
    private String matricule;
    private Double capacite;
    @PrePersist
    public void prePersist() {
        if (this.matricule == null || this.matricule.isEmpty()) {
            this.matricule = CustomIdGenerator.generateId();
        }
    }
}
