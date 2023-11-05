package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "observation_id")
    private long observationId;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime date;

    private String description;

    public Observation() {
    }

    public Observation(long observationId, String description) {
        this.observationId = observationId;
        this.description = description;
    }

    public void setObservationId(long observationId) {
        this.observationId = observationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getObservationId() {
        return observationId;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "observationId=" + observationId +

                ", description='" + description + '\'' +
                '}';
    }
}
