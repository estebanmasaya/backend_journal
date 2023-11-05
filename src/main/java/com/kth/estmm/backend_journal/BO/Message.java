package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long messageId;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;
    private String message_content;
    private LocalDateTime timestamp;


    public Message() {
    }

    public Message(Conversation conversation, String message_content, LocalDateTime timestamp) {
        this.conversation = conversation;
        this.message_content = message_content;
        this.timestamp = timestamp;
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
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
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
                ", message_content='" + message_content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
