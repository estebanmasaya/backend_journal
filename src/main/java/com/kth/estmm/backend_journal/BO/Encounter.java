package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "encounter_id")
    private long encounterId;
    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime date;

    @OneToMany(mappedBy = "encounter")
    private List<Observation> observations;


    public Encounter() {
    }



    public Encounter(Patient patient, Doctor doctor, LocalDateTime date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }
}
