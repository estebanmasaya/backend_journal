package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Patient extends User{

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Encounter> patientEncounters;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Condition> patientConditions;

    @OneToMany(mappedBy = "patient")
    private List<Observation> observations;

    public Patient() {
    }

    public Patient(String name, String email, String password) {
        super(name, email, password);
        this.patientEncounters = new ArrayList<>();
    }

    public List<Encounter> getPatientEncounters() {
        return patientEncounters;
    }

    public void setPatientEncounters(List<Encounter> patientEncounters) {
        this.patientEncounters = patientEncounters;
    }

    public List<Condition> getPatientConditions() {
        return patientConditions;
    }

    public void setPatientConditions(List<Condition> patientConditions) {
        this.patientConditions = patientConditions;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientEncounters=" + patientEncounters +
                ", patientConditions=" + patientConditions +
                '}';
    }
}
