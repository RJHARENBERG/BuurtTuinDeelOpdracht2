package com.example.buurttuindeelopdracht2.Entiteiten;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private String borrowerId;
    private String StartDate;
    private String endDate;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
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

    public void assignTool(Tool tool) {
        this.tool = tool;
    }

}
