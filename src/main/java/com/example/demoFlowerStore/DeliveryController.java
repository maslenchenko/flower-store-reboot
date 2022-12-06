package com.example.demoFlowerStore;


import com.example.demoFlowerStore.flower.service.DHLDeliveryStrategy;
import com.example.demoFlowerStore.flower.service.PostDeliveryStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/delivery")
@RestController
public class DeliveryController {

    @GetMapping("/DHL")
    public List<DHLDeliveryStrategy> returnDHL(){
        List<DHLDeliveryStrategy> DHL = Arrays.asList(
                new DHLDeliveryStrategy("Oleksandra", "Maslenchenko", "Kyiv", "Ukraine", "maslenchenko@gmail.com", "1", 3.0),
                new DHLDeliveryStrategy("Oleksandra", "Maslenchenko", "Lviv", "Ukraine", "sasha2003@gmail.com", "15", 7.0)
        );
        return DHL;
    }

    @GetMapping("/Post")
    public List<PostDeliveryStrategy> returnPost(){
        List<PostDeliveryStrategy> post = Arrays.asList(
                new PostDeliveryStrategy("Oleksandra", "Maslenchenko", "Kyiv", "+380638223883", "102", 10.0),
                new PostDeliveryStrategy("Oleksandra", "Maslenchenko", "Lviv", "+380638223302", "1", 13.0)
                );
        return post;
    }
}
