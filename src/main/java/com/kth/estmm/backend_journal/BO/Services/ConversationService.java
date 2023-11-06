package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Conversation;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.ConversationRepository;
import com.kth.estmm.backend_journal.Persistence.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private UserRepository userRepository;


    public Conversation startNewConversation(long senderId, long receiverId, String messageContent) {
        User sender = userRepository.findById(senderId).orElseThrow(()-> new EntityNotFoundException("No sender found with id: " + senderId));
        User receiver = userRepository.findById(receiverId).orElseThrow(()-> new EntityNotFoundException("No receiver found with id: " + receiverId));
        Conversation conversation = new Conversation(sender, receiver);
        conversation.addMessage(messageContent);
        return conversationRepository.save(conversation);
    }
}
