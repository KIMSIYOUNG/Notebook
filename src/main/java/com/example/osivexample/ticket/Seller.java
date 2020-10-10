package com.example.osivexample.ticket;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Seller {
    @Id @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "seller_id")
    private List<Ticket> tickets = new ArrayList<>();

}
