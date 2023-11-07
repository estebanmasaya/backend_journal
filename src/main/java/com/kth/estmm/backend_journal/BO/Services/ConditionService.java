package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Condition;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.Persistence.ConditionRepository;
import com.kth.estmm.backend_journal.Persistence.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionService {
    @Autowired
    ConditionRepository conditionRepository;
    @Autowired
    PatientRepository patientRepository;


    public Condition addCondition(long patientId, String description) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("No patient found with id: " + patientId));
        return conditionRepository.save(new Condition(patient, description));
    }
}
