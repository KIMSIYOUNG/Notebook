package com.example.stock;

import java.net.URI;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ParticipantLink {
    private URI uri;
    private LocalDate expires;
}
