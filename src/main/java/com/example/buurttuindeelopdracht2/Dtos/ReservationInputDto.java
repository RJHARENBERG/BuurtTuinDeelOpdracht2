package com.example.buurttuindeelopdracht2.Dtos;

public class ReservationInputDto {

    private Long id;

    private Long borrowerId;

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
