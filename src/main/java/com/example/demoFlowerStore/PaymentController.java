package com.example.demoFlowerStore;


import com.example.demoFlowerStore.flower.service.CreditCardPaymentStrategy;
import com.example.demoFlowerStore.flower.service.PayPalPaymentStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/payment")
@RestController
public class PaymentController {

    @GetMapping("/PayPal")
    public List<PayPalPaymentStrategy> returnPayPal(){
        List<PayPalPaymentStrategy> payPal = Arrays.asList(
                new PayPalPaymentStrategy("sasha@gmail.com", "3627G$%shsh"),
                new PayPalPaymentStrategy("maslenchenko@gmail.com", "sgwbwGS626$$!"),
                new PayPalPaymentStrategy("o.maslenchenko@ucu.edu.ua", "sgwbwGS62shw6$$!")
        );
        return payPal;
    }

    @GetMapping("/CreditCard")
    public List<CreditCardPaymentStrategy> returnCreditCard(){
        List<CreditCardPaymentStrategy> creditCard = Arrays.asList(
                new CreditCardPaymentStrategy("1113183617351735", "113", "11/11"),
                new CreditCardPaymentStrategy("4441183617351735", "144", "10/11"),
                new CreditCardPaymentStrategy("1113181730351735", "589", "11/12")
        );
        return creditCard;
    }
}
