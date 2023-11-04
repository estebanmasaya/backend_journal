package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.EncounterRepository;
import com.kth.estmm.backend_journal.Persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EncounterService {


    @Autowired
    private EncounterRepository encounterRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean addEncounter(long patientId, long doctorId, LocalDateTime date) {
        User patient = userRepository.findById(patientId).get();
        User doctor = userRepository.findById(doctorId).get();

        Encounter encounter = new Encounter(doctor, patient, date);
        encounterRepository.save(encounter);
        return true;
    }
}
