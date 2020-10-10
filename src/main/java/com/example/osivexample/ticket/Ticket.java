package com.example.osivexample.ticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id @GeneratedValue
    private Long id;
}
