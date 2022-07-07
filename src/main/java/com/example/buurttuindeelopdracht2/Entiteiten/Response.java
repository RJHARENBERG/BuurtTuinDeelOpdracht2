package com.example.buurttuindeelopdracht2.Entiteiten;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Response {

    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private String messengerId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "general_messages_id")
    private GeneralMessages generalMessages;

    public GeneralMessages getGeneralMessages() {
        return generalMessages;
    }

    public void setGeneralMessages(GeneralMessages generalMessages) {
        this.generalMessages = generalMessages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessengerId() {
        return messengerId;
    }

    public void setMessengerId(String messengerId) {
        this.messengerId = messengerId;
    }

    public void assignGeneralMessages(GeneralMessages generalMessages) {
        this.generalMessages = generalMessages;
    }
}
