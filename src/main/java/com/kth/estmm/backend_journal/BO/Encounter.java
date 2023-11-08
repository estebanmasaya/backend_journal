package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encounter_id")
    private long encounterId;
    @ManyToOne()
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_or_staff_id")
    @JsonBackReference
    private User doctorOrStaff;
    private LocalDateTime date;

    @OneToMany(mappedBy = "encounter")
    @JsonManagedReference
    private List<Observation> observations;


    public Encounter() {
    }



    public Encounter(Patient patient, User doctorOrStaff) {
        this.patient = patient;
        this.doctorOrStaff = doctorOrStaff;
        this.date = LocalDateTime.now();
        this.observations = new ArrayList<>();
    }

    public long getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(long encounterId) {
        this.encounterId = encounterId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctorOrStaff() {
        return doctorOrStaff;
    }

    public void setDoctorOrStaff(User doctorOrStaff) {
        this.doctorOrStaff = doctorOrStaff;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "encounterId=" + encounterId +
                ", patient=" + patient +
                ", doctorOrStaff=" + doctorOrStaff +
                ", date=" + date +
                ", observations=" + observations +
                '}';
    }
}
