package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Staff extends User{

    @OneToMany(mappedBy = "doctorOrStaff")
    @JsonManagedReference
    private List<Encounter> encounters;


    public Staff() {
    }

    public Staff(String name, String email, String password) {
        super(name, email, password, Role.STAFF);
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "encounters=" + encounters +
                '}';
    }
}
