package com.example.demoFlowerStore;

import com.example.demoFlowerStore.flower.service.CreditCardPaymentStrategy;
import com.example.demoFlowerStore.flower.service.PayPalPaymentStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    public void testValidation() {
        PayPalPaymentStrategy p = new PayPalPaymentStrategy();
        p.collectPaymentDetails("sasha@gmail.com", "3627G$%shsh");
        Assertions.assertEquals(true, p.validatePaymentDetails());

        CreditCardPaymentStrategy c = new CreditCardPaymentStrategy();
        c.collectPaymentDetails("1113183617351735", "113", "11/11");
        Assertions.assertEquals(true, c.validatePaymentDetails());

        PayPalPaymentStrategy p1 = new PayPalPaymentStrategy();
        p1.collectPaymentDetails("sashagmail.com", "3627G$%shsh");
        Assertions.assertEquals(false, p1.validatePaymentDetails());

        CreditCardPaymentStrategy c1 = new CreditCardPaymentStrategy();
        c1.collectPaymentDetails("111318361735173", "113", "11/11");
        Assertions.assertEquals(false, c1.validatePaymentDetails());

        PayPalPaymentStrategy p2 = new PayPalPaymentStrategy();
        p2.collectPaymentDetails("sasha@gmail.com", "3627Gshsh");
        Assertions.assertEquals(false, p2.validatePaymentDetails());

        CreditCardPaymentStrategy c2 = new CreditCardPaymentStrategy();
        c2.collectPaymentDetails("1113183617351733", "13", "11/11");
        Assertions.assertEquals(false, c2.validatePaymentDetails());

        CreditCardPaymentStrategy c3 = new CreditCardPaymentStrategy();
        c3.collectPaymentDetails("1113183617351733", "131", "111/11");
        Assertions.assertEquals(false, c3.validatePaymentDetails());
    }
}
