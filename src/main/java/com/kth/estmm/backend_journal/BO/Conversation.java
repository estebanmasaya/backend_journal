package com.kth.estmm.backend_journal.BO;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conversation_id")
    long conversation_id;

    @ManyToOne()
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messageList;

    private LocalDateTime latestTimestamp;

    public Conversation() {
    }

    public Conversation(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.latestTimestamp = LocalDateTime.now();
        this.messageList = new ArrayList<>();
    }

    public boolean addMessage(String messageContent){
        this.latestTimestamp = LocalDateTime.now();
        Message message = new Message(this, messageContent, this.latestTimestamp);
        return messageList.add(message);
    }

    public long getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(long conversation_id) {
        this.conversation_id = conversation_id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public LocalDateTime getLatestTimestamp() {
        return latestTimestamp;
    }

    public void setLatestTimestamp(LocalDateTime latestTimestamp) {
        this.latestTimestamp = latestTimestamp;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "conversation_id=" + conversation_id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", messageList=" + messageList +
                ", timestamp=" + latestTimestamp +
                '}';
    }
}
