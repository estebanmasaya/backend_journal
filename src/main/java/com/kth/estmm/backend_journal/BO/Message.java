package com.kth.estmm.backend_journal.BO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long messageId;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    @JsonBackReference
    private Conversation conversation;
    private String messageContent;
    private LocalDateTime timestamp;
    private long senderId;
    private long receiverId;
    public Message() {
    }

    public Message(Conversation conversation, String messageContent, LocalDateTime timestamp, long senderId, long receiverId) {
        this.conversation = conversation;
        this.messageContent = messageContent;
        this.timestamp = timestamp;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public String getMessage_content() {
        return messageContent;
    }

    public void setMessage_content(String message_content) {
        this.messageContent = message_content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", conversation=" + conversation +
                ", message_content='" + messageContent + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
