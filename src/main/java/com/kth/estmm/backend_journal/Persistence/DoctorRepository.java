package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Doctor;
import com.kth.estmm.backend_journal.BO.Patient;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository  extends CrudRepository<Doctor, Long> {


}
