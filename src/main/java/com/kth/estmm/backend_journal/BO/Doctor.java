package com.kth.estmm.backend_journal.BO;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Doctor extends User {

    @OneToMany(mappedBy = "doctorOrStaff")
    @JsonManagedReference
    List<Encounter> encounters;

    public Doctor() {
    }

    public Doctor(String name, String email, String password) {
        super(name, email, password, Role.DOCTOR);
        encounters = new ArrayList<>();
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorEncounters=" + encounters +
                '}';
    }
}
