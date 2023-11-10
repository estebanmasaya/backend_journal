package com.kth.estmm.backend_journal.DTO;

import com.kth.estmm.backend_journal.BO.Condition;
import com.kth.estmm.backend_journal.BO.Role;

import java.util.List;

public class PatientInfoDTO {
    private String name;
    private String email;
    private Role role;
    private List<EncounterInfoDTO> encounters;
    private List<Condition> conditions;

    public PatientInfoDTO() {
    }

    public PatientInfoDTO(String name, String email, Role role, List<EncounterInfoDTO> encounters, List<Condition> conditions) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.encounters = encounters;
        this.conditions = conditions;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<EncounterInfoDTO> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<EncounterInfoDTO> encounters) {
        this.encounters = encounters;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
