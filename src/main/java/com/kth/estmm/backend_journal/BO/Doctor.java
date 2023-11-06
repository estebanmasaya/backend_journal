package com.kth.estmm.backend_journal.BO;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    List<Encounter> doctorEncounters;

    @OneToMany(mappedBy = "doctorOrStaff")
    @JsonManagedReference
    private List<Observation> observations;

    public Doctor() {
    }

    public Doctor(String name, String email, String password) {
        super(name, email, password, Role.DOCTOR);
    }

    public List<Encounter> getDoctorEncounters() {
        return doctorEncounters;
    }

    public void setDoctorEncounters(List<Encounter> doctorEncounters) {
        this.doctorEncounters = doctorEncounters;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorEncounters=" + doctorEncounters +
                '}';
    }
}
