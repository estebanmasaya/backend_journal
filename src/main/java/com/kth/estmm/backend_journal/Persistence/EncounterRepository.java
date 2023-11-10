package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Condition;
import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Observation;
import com.kth.estmm.backend_journal.BO.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EncounterRepository extends CrudRepository<Encounter, Long> {
    public List<Encounter> findAllByPatient (Patient patient);
    List<Encounter> findByPatient(Patient patient);
}
