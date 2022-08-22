package com.platzi.javatest.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentResquest request);
}
