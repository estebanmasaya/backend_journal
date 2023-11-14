package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EncounterService {


    @Autowired
    private EncounterRepository encounterRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private StaffRepository staffRepository;

   /* public Encounter addEncounter(long patientId, long doctorOrStaffId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException(""));
        User doctorOrStaff;
        if(doctorRepository.existsById(doctorOrStaffId)){
            doctorOrStaff =doctorRepository.findById(doctorOrStaffId).get   ();
        }
        else if (staffRepository.existsById(doctorOrStaffId)){
            doctorOrStaff = staffRepository.findById(doctorOrStaffId).get();
        }
        else{
            throw new EntityNotFoundException("No Doctor or Staff found with id " + doctorOrStaffId);
        }

        Encounter encounter = new Encounter(patient, doctorOrStaff);
        return encounterRepository.save(encounter);
    }*/

/*    public List<Encounter> getEncountersByPatientId(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("no Patient found with id: " + patientId));
        return encounterRepository.findAllByPatient(patient);
    }*/
}
