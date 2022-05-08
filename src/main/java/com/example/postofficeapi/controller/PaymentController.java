package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.feign.PaymentFeign;
import com.example.postofficeapi.model.ClientModel;
import com.example.postofficeapi.model.PaymentDetails;
import com.example.postofficeapi.model.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-office/payment")
public class PaymentController {
    @Autowired
    PaymentFeign paymentFeign;
    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/all")
    public Page<PaymentModel> getAllPayments(Pageable pageable) {
        return paymentFeign.getAllPayments(pageable);
    }

    @GetMapping
    public PaymentModel getPaymentByPaymentId(@RequestParam String paymentId) {
        return paymentFeign.getPaymentByPaymentId(paymentId);
    }

    @GetMapping("/client")
    public Page<PaymentModel> getPaymentsByClientId(@RequestParam String clientId, Pageable pageable) {
        return paymentFeign.getPaymentsByClientId(clientId, pageable);
    }

    @GetMapping("/client/total")
    public Integer getTotalByClientId(@RequestParam String clientId) {
        return paymentFeign.getTotalByClientId(clientId);
    }

    @PostMapping
    public PaymentModel createPayment(@RequestBody PaymentModel paymentModel) {
        return paymentFeign.createPayment(paymentModel);
    }

    @PutMapping
    public PaymentModel updatePayment(@RequestParam String paymentId,
                                      @RequestBody PaymentModel paymentModel) {
        return paymentFeign.updatePayment(paymentId, paymentModel);
    }

    @PutMapping("/pay")
    public PaymentModel makePaymentByPaymentId(@RequestParam String paymentId) {
        return paymentFeign.makePaymentByPaymentId(paymentId);
    }

    @PutMapping("/pay/all")
    public List<PaymentModel> makeAllPaymentsByClientId(@RequestParam String clientId) {
        return paymentFeign.makeAllPaymentsByClientId(clientId);
    }

    @DeleteMapping
    public String deletePaymentByPaymentId(@RequestParam String paymentId) {
        return paymentFeign.deletePaymentByPaymentId(paymentId);
    }

    @DeleteMapping("/client")
    public String deletePaymentsByClientId(@RequestParam String clientId) {
        return paymentFeign.deletePaymentsByClientId(clientId);
    }

    @GetMapping("/details")
    public PaymentDetails getPaymentDetailsById(@RequestParam String paymentId) {
        PaymentModel paymentModel = paymentFeign.getPaymentByPaymentId(paymentId);
        ClientModel clientModel = clientFeign.getClientById(paymentModel.getClientId());
        PaymentDetails details = new PaymentDetails(
                paymentId,
                clientModel,
                paymentModel.getDescription(),
                paymentModel.getCost(),
                paymentModel.isPaid());
        return details;
    }
}
