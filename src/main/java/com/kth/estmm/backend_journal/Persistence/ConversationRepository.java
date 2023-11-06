package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.Conversation;
import org.springframework.data.repository.CrudRepository;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
}
