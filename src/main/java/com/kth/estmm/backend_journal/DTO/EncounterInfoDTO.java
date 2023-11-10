package com.kth.estmm.backend_journal.DTO;

import com.kth.estmm.backend_journal.BO.Observation;
import com.kth.estmm.backend_journal.BO.User;

import java.time.LocalDateTime;
import java.util.List;

public class EncounterInfoDTO {
    private long encounterId;
    private LocalDateTime date;
    private User doctorOrStaff;
    private List<Observation> observations;

    public EncounterInfoDTO() {
    }

    public EncounterInfoDTO(long encounterId, LocalDateTime date, User doctorOrStaff, List<Observation> observations) {
        this.encounterId = encounterId;
        this.date = date;
        this.doctorOrStaff = doctorOrStaff;
        this.observations = observations;
    }

    public long getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(long encounterId) {
        this.encounterId = encounterId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}
