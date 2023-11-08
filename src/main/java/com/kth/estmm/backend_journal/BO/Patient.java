package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Patient extends User{

    public Patient() {
    }

    public Patient(String name, String email, String password) {
        super(name, email, password, Role.PATIENT);

    }

    @Override
    public String toString() {
        return "Patient{}";
    }
}
