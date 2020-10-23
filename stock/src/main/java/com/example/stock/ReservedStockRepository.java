package com.example.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedStockRepository extends JpaRepository<ReservedStock, Long> {
}
