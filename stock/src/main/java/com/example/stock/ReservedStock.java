package com.example.stock;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservedStock {

    @Id @GeneratedValue
    private Long id;

    private String resources;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate createdAt;

    public void changeStatus(Status status) {
        this.status = status;
    }

    public ReservedStock(StockAdjustment stockAdjustment) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.resources = objectMapper.writeValueAsString(stockAdjustment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
        this.createdAt = LocalDate.now();
    }

    public StockAdjustment getResources() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(this.resources, StockAdjustment.class);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
