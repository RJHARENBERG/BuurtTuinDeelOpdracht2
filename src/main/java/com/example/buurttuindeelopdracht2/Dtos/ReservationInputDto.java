package com.example.buurttuindeelopdracht2.Dtos;

import com.example.buurttuindeelopdracht2.Entiteiten.GeneralMessages;

public class ReservationInputDto {

    private Long id;

    private Long borrowerId;

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

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }
}
