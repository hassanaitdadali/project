package com.sportreservation.optimisationdeslivraison.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Entity@AllArgsConstructor@NoArgsConstructor
@Data

public class Partner {
    @Id
    @GeneratedValue(generator = "11111111")
    @GenericGenerator(name = "11111111", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PartnerID", updatable = false, nullable = false)
    private String partnerId;
    @Column(name = "PartnerName")
    private String partnerName;
    private double latitude;
    private double longitude;
    private double amount;
    private double weight;
    private  float volume;

}
