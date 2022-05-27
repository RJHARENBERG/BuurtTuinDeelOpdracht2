package com.example.buurttuindeelopdracht2.Dtos;

public class ResponseInputDto {

    private Long id;

    private String Message;
    private Long MessengerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Long getMessengerId() {
        return MessengerId;
    }

    public void setMessengerId(Long messengerId) {
        MessengerId = messengerId;
    }
}
