package com.example.buurttuindeelopdracht2.Dtos;

public class ResponseInputDto {

    private Long id;

    private String message;
    private Long messengerId;

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
        message = message;
    }

    public Long getMessengerId() {
        return messengerId;
    }

    public void setMessengerId(Long messengerId) {
        messengerId = messengerId;
    }
}
