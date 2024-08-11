package com.sportreservation.optimisationdeslivraison.Entities;

import com.sportreservation.optimisationdeslivraison.utilities.CustomIdGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Entity@AllArgsConstructor@NoArgsConstructor
@Data

public class Partner {
    @Id
    @Column(name = "PartnerID", updatable = false, nullable = false)
    private String partnerId;
    @Column(name = "PartnerName")
    private String partnerName;
    private double latitude;
    private double longitude;
    private double amount;
    private double weight;
    private  float volume;

    @PrePersist
    public void prePersist() {
        if (this.partnerId == null || this.partnerId.isEmpty()) {
            this.partnerId = CustomIdGenerator.generateIdp();
        }
    }
}
