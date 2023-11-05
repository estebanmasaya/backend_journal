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

    public Observation() {
    }

    public Observation(long observationId, Encounter encounter, String description) {
        this.observationId = observationId;
        this.encounter = encounter;
        this.description = description;
    }

    public void setObservationId(long observationId) {
        this.observationId = observationId;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
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
                ", encounter=" + encounter +
                ", description='" + description + '\'' +
                '}';
    }
}
