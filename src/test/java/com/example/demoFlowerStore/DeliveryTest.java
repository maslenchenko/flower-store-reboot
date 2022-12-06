package com.example.demoFlowerStore;

import com.example.demoFlowerStore.flower.service.DHLDeliveryStrategy;
import com.example.demoFlowerStore.flower.service.PostDeliveryStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryTest {

    @Test
    public void testPrice() {
        DHLDeliveryStrategy dhl = new DHLDeliveryStrategy();
        PostDeliveryStrategy post = new PostDeliveryStrategy();
        dhl.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "Ukraine", "sasha@gmail.com", "1", 3.0);
        post.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "+380638223883", "102", 10.0);
        Assertions.assertEquals(45.0, dhl.getPrice());
        Assertions.assertEquals(50.0, post.getPrice());
    }

    @Test
    public void testValidation() {
        DHLDeliveryStrategy dhl = new DHLDeliveryStrategy();
        PostDeliveryStrategy post = new PostDeliveryStrategy();
        dhl.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "Ukraine", "sasha@gmail.com", "3", 3.0);
        post.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "+380638223883", "102", 10.0);
        Assertions.assertEquals(true, dhl.validateDeliveryDetails());
        Assertions.assertEquals(true, post.validateDeliveryDetails());

        DHLDeliveryStrategy dhl1 = new DHLDeliveryStrategy();
        PostDeliveryStrategy post1 = new PostDeliveryStrategy();
        dhl1.collectDeliveryDetails("oleksandra", "Maslenchenko", "Kyiv", "Ukraine", "sasha@gmail.com", "abc", 3.0);
        post1.collectDeliveryDetails("Oleksandra", "maslenchenko", "Kyiv", "380638223883", "102", 10.0);
        Assertions.assertEquals(false, dhl1.validateDeliveryDetails());
        Assertions.assertEquals(false, post1.validateDeliveryDetails());

        DHLDeliveryStrategy dhl2 = new DHLDeliveryStrategy();
        PostDeliveryStrategy post2 = new PostDeliveryStrategy();
        dhl2.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyi86v", "Ukraine", "sasha@gmail.com", "637", 3.0);
        post2.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Ky83iv", "380638223883", "102", 10.0);
        Assertions.assertEquals(false, dhl2.validateDeliveryDetails());
        Assertions.assertEquals(false, post2.validateDeliveryDetails());

        DHLDeliveryStrategy dhl3 = new DHLDeliveryStrategy();
        PostDeliveryStrategy post3 = new PostDeliveryStrategy();
        dhl3.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "Ukraine", "sashagmail.com", "37", 3.0);
        post3.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "+380638223883", "1022222", 10.0);
        Assertions.assertEquals(false, dhl3.validateDeliveryDetails());
        Assertions.assertEquals(false, post3.validateDeliveryDetails());

        DHLDeliveryStrategy dhl4 = new DHLDeliveryStrategy();
        PostDeliveryStrategy post4 = new PostDeliveryStrategy();
        dhl4.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "Ukraine", "sasha@gmail.com", "24637", 3.0);
        post4.collectDeliveryDetails("Oleksandra", "Maslenchenko", "Kyiv", "+38063a223883", "102", 10.0);
        Assertions.assertEquals(false, dhl4.validateDeliveryDetails());
        Assertions.assertEquals(false, post4.validateDeliveryDetails());
    }
}