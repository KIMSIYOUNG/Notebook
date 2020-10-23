package com.example.stock;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping
    public ResponseEntity<ParticipantLink> tryStockAdjustment(@RequestBody StockAdjustment stockAdjustment) {
        ReservedStock reservedStock = stockService.reserveStock(stockAdjustment);
        ParticipantLink participantLink = buildParticipantLink(reservedStock.getId(), reservedStock.getCreatedAt());

        return new ResponseEntity<>(participantLink, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> confirmStockAdjustment(@PathVariable Long id) {
        try {
            stockService.confirmStock(id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ParticipantLink buildParticipantLink(Long id, LocalDate createdAt) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

        return new ParticipantLink(uri, createdAt);
    }
}
