package com.example.demoFlowerStore;


import com.example.demoFlowerStore.flower.store.Flower;
import com.example.demoFlowerStore.flower.store.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(method = RequestMethod.POST)
@RestController
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @GetMapping("/store")
    public List<Flower> returnFlowers(){
        return flowerService.getFlowers();
    }

    @PostMapping("/store/addFlower")
    public void createNewFlower(@RequestBody Flower flower){
        flowerService.addNewFlower(flower);
    }
}
