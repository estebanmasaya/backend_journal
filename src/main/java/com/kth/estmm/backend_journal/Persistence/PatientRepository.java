package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.User;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
