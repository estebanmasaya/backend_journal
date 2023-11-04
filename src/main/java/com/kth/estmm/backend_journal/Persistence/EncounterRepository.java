package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Encounter;
import org.springframework.data.repository.CrudRepository;

public interface EncounterRepository extends CrudRepository<Encounter, Long> {
}
