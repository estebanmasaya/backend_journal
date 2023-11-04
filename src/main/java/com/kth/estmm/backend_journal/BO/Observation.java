package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "observation_id")
    private long observationId;

    @ManyToOne
    @JoinColumn(name= "encounter_id")
    private Encounter encounter;

    private String description;


}
