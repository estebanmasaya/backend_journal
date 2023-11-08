package com.kth.estmm.backend_journal.BO;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Doctor extends User {

    public Doctor() {
    }

    public Doctor(String name, String email, String password) {
        super(name, email, password, Role.DOCTOR);
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "doctorEncounters=" +
                '}';
    }
}
