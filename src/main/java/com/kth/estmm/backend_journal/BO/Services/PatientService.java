package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Condition;
import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Observation;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.DTO.EncounterInfoDTO;
import com.kth.estmm.backend_journal.DTO.PatientInfoDTO;
import com.kth.estmm.backend_journal.Persistence.ConditionRepository;
import com.kth.estmm.backend_journal.Persistence.EncounterRepository;
import com.kth.estmm.backend_journal.Persistence.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EncounterRepository encounterRepository;
    @Autowired
    private ConditionRepository conditionRepository;

    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Patient getPatientById(long id) {
        return patientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Patient not found with id " + id));
    }
    public Patient addPatient(String name, String email, String password) {
        Patient newPatient = new Patient(name, email, password);
        return patientRepository.save(newPatient);
    }

    public Iterable<PatientInfoDTO> getAllPatientInfoById(long id) {
        Patient patient = patientRepository.findById(id).orElse(null);


        List<EncounterInfoDTO> encounterInfoDBOs = new ArrayList<>();
        List<Encounter> encounters = encounterRepository.findByPatient(patient);
        for (Encounter encounter : encounters) {
            List<Observation> observations = encounter.getObservations();
            EncounterInfoDTO encounterInfoDBO = new EncounterInfoDTO(
                    encounter.getEncounterId(),
                    encounter.getDate(),
                    encounter.getDoctorOrStaff(),
                    observations
            );
            encounterInfoDBOs.add(encounterInfoDBO);
        }

        List<Condition> conditions = conditionRepository.findByPatient(patient);

        PatientInfoDTO patientInfoDBO = new PatientInfoDTO(
                patient.getName(),
                patient.getEmail(),
                patient.getRole(),
                encounterInfoDBOs,
                conditions
        );

        List<PatientInfoDTO> result = new ArrayList<>();
        result.add(patientInfoDBO);

        return result;
    }

}
