package com.kth.estmm.backend_journal.BO;


import jakarta.persistence.*;

import java.util.List;
@Entity
public class Doctor extends User{

    @OneToMany(mappedBy = "doctor")
    List<Encounter> doctorEncounters;

    public Doctor() {
    }

    public Doctor(String name, String email, String password) {
        super(name, email, password);
    }

    public List<Encounter> getDoctorEncounters() {
        return doctorEncounters;
    }

    public void setDoctorEncounters(List<Encounter> doctorEncounters) {
        this.doctorEncounters = doctorEncounters;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorEncounters=" + doctorEncounters +
                '}';
    }
}
