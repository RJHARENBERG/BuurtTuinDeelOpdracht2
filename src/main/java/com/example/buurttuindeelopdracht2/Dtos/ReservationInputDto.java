package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.GeneralMessages;

public class ReservationInputDto {

    private Long id;

    private String borrowerId;
    private String StartDate;
    private String endDate;

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

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
