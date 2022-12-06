package com.example.demoFlowerStore.flower.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.example.demoFlowerStore.flower.store.FlowerColor.*;

@Configuration
public class FlowerConfig {

    @Bean
    CommandLineRunner commandLineRunner(FlowerRepository repository){
        return args -> {
            Flower tul = new Flower(10.0, RED, 40.0, FlowerType.TULIP);
            Flower chamo = new Flower(10.0, WHITE, 20.0, FlowerType.CHAMOMILE);
            Flower rose = new Flower(5.0, YELLOW, 50.0, FlowerType.ROSE);
            repository.saveAll(List.of(tul, chamo, rose));
        };

    };
}
