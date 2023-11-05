package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.Persistence.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public boolean addPatient(String name, String email, String password) {
        Patient newPatient = new Patient(name, email, password);
        patientRepository.save(newPatient);
        return true;
    }
}
