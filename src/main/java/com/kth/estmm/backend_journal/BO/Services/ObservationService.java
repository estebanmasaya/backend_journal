package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Observation;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Observation addObservation(long encounterId, String description) {
        Encounter encounter = encounterRepository.findById(encounterId).orElseThrow(()-> new EntityNotFoundException("No encounter found with id: " + encounterId));
        return observationRepository.save(new Observation(encounter, description));
    }

    public Iterable<Observation> getAllObservations() {
        return observationRepository.findAll();
    }
}
