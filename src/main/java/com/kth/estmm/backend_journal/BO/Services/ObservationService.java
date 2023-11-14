package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Observation;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {
    @Autowired
    private ObservationRepository observationRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private EncounterRepository encounterRepository;

    public Observation addObservationByEncounterId(long encounterId, String description) {
        Encounter encounter = encounterRepository.findById(encounterId).orElseThrow(()-> new EntityNotFoundException("No encounter found with id: " + encounterId));
        return observationRepository.save(new Observation(encounter, description));
    }

   /* public Observation addObservationAndEncounter(long patientId, long doctorOrStaffId, String description){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("no Patient found with id: " + patientId));
        User doctorOrStaff;
        if(doctorRepository.existsById(doctorOrStaffId)){
            doctorOrStaff =doctorRepository.findById(doctorOrStaffId).get();
        }
        else if (staffRepository.existsById(doctorOrStaffId)){
            doctorOrStaff = staffRepository.findById(doctorOrStaffId).get();
        }
        else{
            throw new EntityNotFoundException("No Doctor or Staff found with id " + doctorOrStaffId);
        }
        Encounter encounter = encounterRepository.save(new Encounter(patient, doctorOrStaff));
        return addObservationByEncounterId(encounter.getEncounterId(), description);
    }*/
    public Iterable<Observation> getAllObservations() {
        return observationRepository.findAll();
    }

    public List<Observation> getObservationsByEncounterId(long encounterId) {
        Encounter encounter = encounterRepository.findById(encounterId).orElseThrow(()-> new EntityNotFoundException("No encounter found with id: " + encounterId));
        return observationRepository.findAllByEncounter(encounter);
    }
}
