package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;
@Entity
public class Conditions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "condition_id")
    private long conditionId;
    @ManyToOne
    @JoinColumn(name = "id")
    private Patient patient;


    private String description;

}
