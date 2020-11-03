package com.example.stock;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockService {
    private final ReservedStockRepository reservedStockRepository;
    private final StockRepository stockRepository;

    public ReservedStock reserveStock(StockAdjustment stockAdjustment) {
        ReservedStock reservedStock = new ReservedStock(stockAdjustment);
        reservedStockRepository.save(reservedStock);

        return reservedStock;
    }

    @Transactional
    public void confirmStock(Long id) {
        ReservedStock reservedStock = reservedStockRepository.findById(id)
            .orElseThrow(RuntimeException::new);

        if(reservedStock.getResources().getAdjustmentType().equals("REDUCE")) {
            Stock stock = stockRepository.findByProductId(reservedStock.getResources().getProductId())
                .orElseThrow(IllegalArgumentException::new);
            stock.decrease(reservedStock.getResources().getQuantity());
            stockRepository.save(stock);
        }
        reservedStock.changeStatus(Status.CONFIRMED);
        reservedStockRepository.save(reservedStock);
    }

    @Transactional
    public void cancelStock(Long id) {
        ReservedStock stock = reservedStockRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);
        stock.changeStatus(Status.CANCEL);
    }
}
