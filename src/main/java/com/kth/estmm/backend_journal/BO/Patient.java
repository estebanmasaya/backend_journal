package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Patient extends User{

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Encounter> patientEncounters;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Condition> patientConditions;

    public Patient() {
    }

    public Patient(String name, String email, String password) {
        super(name, email, password, Role.PATIENT);
        this.patientEncounters = new ArrayList<>();
        this.patientConditions = new ArrayList<>();
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
