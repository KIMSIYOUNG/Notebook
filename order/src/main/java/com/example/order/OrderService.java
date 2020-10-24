package com.example.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final TccRestAdapter tccRestAdapter;

    public void placeOrder(Order order) {
        ParticipantLink stockLink = reduceStock(order);
        ParticipantLink paymentLink = payOrder(order);

        if (validate(stockLink, paymentLink)) {
            tccRestAdapter.confirmAll(stockLink.getUri(), paymentLink.getUri());
        } else {
            tccRestAdapter.cancelAll(stockLink.getUri(), paymentLink.getUri());
        }
    }

    private boolean validate(ParticipantLink stockLink, ParticipantLink paymentLink) {
        // some logic
        return true;
    }

    private ParticipantLink reduceStock(Order order) {
        String requestUri = "http://localhost:8081/api/stocks";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("adjustmentType", "REDUCE");
        requestBody.put("productId", order.getProductId());
        requestBody.put("quantity", order.getQuantity());

        return tccRestAdapter.doTry(requestUri, requestBody);
    }

    private ParticipantLink payOrder(Order order) {
        String requestUri = "http://localhost:8082/api/payments";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("orderId", order.getId());
        requestBody.put("paymentAmount", order.getPaymentAmount());

        return tccRestAdapter.doTry(requestUri, requestBody);
    }

}
