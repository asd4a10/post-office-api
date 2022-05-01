package com.example.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentModel {
    private String paymentId;
    private String clientId;
    private String description;
    private int cost;
    private boolean isPaid;
}
