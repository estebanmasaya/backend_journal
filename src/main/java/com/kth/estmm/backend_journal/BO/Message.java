package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long messageId;
    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;
    private LocalDateTime date;

    @OneToMany(mappedBy = "encounter")
    private List<Observation> observations;



}
