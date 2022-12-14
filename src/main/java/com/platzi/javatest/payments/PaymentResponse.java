package com.platzi.javatest.payments;

public class PaymentResponse {
    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    enum PaymentStatus {
        OK, ERROR
    }

    private PaymentStatus status;

    public PaymentStatus getStatus() {
        return status;
    }


}
