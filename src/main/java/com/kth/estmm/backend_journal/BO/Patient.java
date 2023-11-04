package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Patient extends User{

    public Patient() {
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Encounter> patientEncounters;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conditions> patientConditions;
}
