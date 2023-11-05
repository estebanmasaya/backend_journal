package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "observation_id")
    private long observationId;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_or_staff_id")
    @JsonBackReference
    private User doctorOrStaff;
    private LocalDateTime date;

    private String description;

    public Observation() {
    }

    public Observation(Patient patient, User doctorOrStaff, String description) {
        this.patient = patient;
        this.doctorOrStaff = doctorOrStaff;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public void setObservationId(long observationId) {
        this.observationId = observationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getObservationId() {
        return observationId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "observationId=" + observationId +

                ", description='" + description + '\'' +
                '}';
    }
}
