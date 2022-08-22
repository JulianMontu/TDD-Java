package com.platzi.javatest.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;
    //organizar el codigo repetido, al poner la anotacion before quedara mas legible
    @Before
    public  void setup(){
         paymentGateway = Mockito.mock(PaymentGateway.class);
         paymentProcessor = new PaymentProcessor(paymentGateway);

    }
    @Test
    public void payment_is_correct() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(100));
    }
    @Test
    public void payment_is_wrong() {
        //preparacion del escenario, objeto que queremos crear
        //PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        //PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        //llamada al metodo y comprobacion
        assertFalse(paymentProcessor.makePayment(100));
    }
}