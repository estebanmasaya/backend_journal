package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Observation;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.DoctorRepository;
import com.kth.estmm.backend_journal.Persistence.ObservationRepository;
import com.kth.estmm.backend_journal.Persistence.PatientRepository;
import com.kth.estmm.backend_journal.Persistence.StaffRepository;
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

    public Observation addObservation(long patientId, long doctorOrStaffId, String description) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with id " + patientId));
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
        return observationRepository.save(new Observation(patient, doctorOrStaff, description));
    }

    public Iterable<Observation> getAllObservations() {
        return observationRepository.findAll();
    }
}
