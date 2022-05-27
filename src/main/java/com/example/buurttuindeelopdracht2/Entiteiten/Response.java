package com.example.buurttuindeelopdracht2.Entiteiten;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Response {

    @Id
    @GeneratedValue
    private Long id;

    private String Message;
    private Long MessengerId;



}
