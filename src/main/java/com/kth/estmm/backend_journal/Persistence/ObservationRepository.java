package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Observation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObservationRepository extends CrudRepository<Observation, Long> {
    public List<Observation> findAllByEncounter(Encounter encounter);
}
