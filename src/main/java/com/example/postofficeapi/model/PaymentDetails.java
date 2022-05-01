package com.example.postofficeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDetails {
    private String paymentId;
    private ClientModel client;
    private String description;
    private int cost;
    private boolean isPaid;
}
