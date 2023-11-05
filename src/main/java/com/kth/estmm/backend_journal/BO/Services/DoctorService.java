package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Doctor;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.Persistence.DoctorRepository;
import com.kth.estmm.backend_journal.Persistence.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Iterable<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(long id) {
        return doctorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Doctor not found with id " + id));
    }
    public boolean addDoctor(String name, String email, String password) {
        Doctor newDoctor = new Doctor(name, email, password);
        doctorRepository.save(newDoctor);
        return true;
    }
}
