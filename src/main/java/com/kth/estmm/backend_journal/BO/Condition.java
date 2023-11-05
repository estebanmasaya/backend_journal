package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

@Entity(name = "\"condition\"")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "condition_id")
    private long conditionId;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    private String description;

    public Condition() {
    }

    public Condition(long conditionId, Patient patient, String description) {
        this.conditionId = conditionId;
        this.patient = patient;
        this.description = description;
    }

    public long getConditionId() {
        return conditionId;
    }

    public void setConditionId(long conditionId) {
        this.conditionId = conditionId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "conditionId=" + conditionId +
                ", patient=" + patient +
                ", description='" + description + '\'' +
                '}';
    }
}
