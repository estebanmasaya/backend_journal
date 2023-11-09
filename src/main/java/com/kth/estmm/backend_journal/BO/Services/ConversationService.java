package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Conversation;
import com.kth.estmm.backend_journal.BO.Message;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.DTO.MessageDTO;
import com.kth.estmm.backend_journal.Persistence.ConversationRepository;
import com.kth.estmm.backend_journal.Persistence.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        conversation.addMessage(messageContent, senderId, receiverId);
        return conversationRepository.save(conversation);
    }

    public Conversation newMessage(long conversationId, String messageContent, long senderId, long receiverId) {
        Conversation conversation = conversationRepository.findById(conversationId).orElseThrow(()-> new EntityNotFoundException("No conversation found with id: " + conversationId));
        conversation.addMessage(messageContent, senderId, receiverId);
        return conversationRepository.save(conversation);
    }

    public void removeConversationById(long id){
        conversationRepository.deleteById(id);
    }

    public Conversation getConversationById(long id) {
        return conversationRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Conversation not found with id " + id));
    }

    public Iterable<MessageDTO> getMessagesById(long id) {
        Conversation conversation = conversationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conversation not found with id " + id));

        List<MessageDTO> messageDTOList = new ArrayList<>();

        for (Message message : conversation.getMessageList()) {
            MessageDTO messageDTO = new MessageDTO(
                    message.getMessageId(),
                    conversation.getConversation_id(),
                    message.getSenderId(),
                    message.getReceiverId(),
                    message.getMessage_content(),
                    message.getTimestamp()
            );
            messageDTOList.add(messageDTO);
        }

        return messageDTOList;
    }
    public Iterable<Conversation> getAllConversations(){
        return conversationRepository.findAll();
    }

    public Iterable<Conversation> getAllConversationsById(long Id) {
        List<Conversation> conversations = (List<Conversation>) conversationRepository.findAll();
        List<Conversation> resultConversations = new ArrayList<>();

        for (Conversation conversation : conversations) {
            if (conversation.getSender().getId() == Id || conversation.getReceiver().getId() == Id) {
                resultConversations.add(conversation);
            }
        }
        return resultConversations;
    }
}
