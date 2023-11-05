package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Observation;
import org.springframework.data.repository.CrudRepository;

public interface ObservationRepository extends CrudRepository<Observation, Long> {
}
