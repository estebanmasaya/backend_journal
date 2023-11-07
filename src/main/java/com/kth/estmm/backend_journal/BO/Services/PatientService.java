package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.Persistence.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

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


}
