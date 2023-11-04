package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

@Entity
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "condition_id")
    private long conditionId;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;


    private String description;

}
