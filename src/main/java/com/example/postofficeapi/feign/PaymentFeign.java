package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.PaymentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("client-payment")
public interface PaymentFeign {
    @GetMapping("/payment/all")
    Page<PaymentModel> getAllPayments(Pageable pageable);

    @PostMapping("/payment")
    PaymentModel createPayment(PaymentModel paymentModel);

    @PutMapping("/payment")
    PaymentModel updatePayment(@RequestParam String paymentId,
                               PaymentModel paymentModel);

    @GetMapping("/payment")
    PaymentModel getPaymentByPaymentId(@RequestParam String paymentId);

    @GetMapping("/payment/client")
    Page<PaymentModel> getPaymentsByClientId(@RequestParam String clientId, Pageable pageable);

    @DeleteMapping("/payment")
    String deletePaymentByPaymentId(@RequestParam String paymentId);

    @DeleteMapping("/payment/client")
    String deletePaymentsByClientId(@RequestParam String clientId);

    @PutMapping("/payment/pay")
    PaymentModel makePaymentByPaymentId(@RequestParam String paymentId);

    @PutMapping("/payment/pay/all")
    List<PaymentModel> makeAllPaymentsByClientId(@RequestParam String clientId);

    @GetMapping("/payment/client/total")
    Integer getTotalByClientId(@RequestParam String clientId);
}
