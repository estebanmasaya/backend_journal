package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Staff extends User{

    @OneToMany(mappedBy = "doctorOrStaff")
    @JsonManagedReference
    private List<Observation> observations;


    public Staff() {
    }

    public Staff(String name, String email, String password) {
        super(name, email, password);
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "observations=" + observations +
                '}';
    }
}
