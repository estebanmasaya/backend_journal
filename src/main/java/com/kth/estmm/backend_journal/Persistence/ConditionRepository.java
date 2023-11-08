package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Condition;
import com.kth.estmm.backend_journal.BO.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConditionRepository extends CrudRepository<Condition, Long> {
    public List<Condition> findAllByPatient (Patient patient);
}
