package com.example.stock;

import lombok.Getter;

@Getter
public class StockAdjustment {
    private Long productId;
    private Status adjustmentType;
    private long quantity;
}
