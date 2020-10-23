package com.example.order;

import java.net.URI;
import java.util.Date;

import lombok.Getter;

@Getter
public class ParticipantLink {
    private URI uri;
    private Date expires;
}
