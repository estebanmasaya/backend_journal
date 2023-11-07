package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
