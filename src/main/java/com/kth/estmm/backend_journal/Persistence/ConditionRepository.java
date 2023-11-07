package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Condition;
import org.springframework.data.repository.CrudRepository;

public interface ConditionRepository extends CrudRepository<Condition, Long> {
}
