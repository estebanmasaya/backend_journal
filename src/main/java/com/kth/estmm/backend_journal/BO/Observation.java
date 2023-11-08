package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "observation_id")
    private long observationId;


    @ManyToOne
    @JoinColumn(name= "encounter_id")
    @JsonBackReference
    private Encounter encounter;
    private String description;

    public Observation() {
    }

    public Observation(Encounter encounter, String description) {
        this.encounter = encounter;
        this.description = description;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
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
