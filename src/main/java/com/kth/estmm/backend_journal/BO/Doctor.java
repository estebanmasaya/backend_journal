package com.kth.estmm.backend_journal.BO;


import jakarta.persistence.*;

import java.util.List;
@Entity
public class Doctor extends User{

    public Doctor() {
    }


    @OneToMany(mappedBy = "doctor")
    List<Encounter> doctorEncounters;

}
