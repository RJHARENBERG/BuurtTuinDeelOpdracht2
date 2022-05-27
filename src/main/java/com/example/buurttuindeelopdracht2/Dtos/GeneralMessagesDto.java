package com.example.buurttuindeelopdracht2.Dtos;

public class GeneralMessagesDto {

    private Long id;

    private String title;
    private String message;
//    private IMG

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
