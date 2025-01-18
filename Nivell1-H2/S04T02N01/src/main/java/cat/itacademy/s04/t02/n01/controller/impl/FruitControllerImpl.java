package cat.itacademy.s04.t02.n01.controller.impl;

import cat.itacademy.s04.t02.n01.controller.FruitController;
import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.service.impl.FruitServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruit")
public class FruitControllerImpl implements FruitController {

    @Autowired
    private FruitServiceImpl fruitService;


    @Override
    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        log.info("Adding fruit {}", fruit);
        Fruit newFruit = fruitService.addFruit(fruit);
        return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        log.info("Updating fruit {}", fruit);
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable int id) {
        log.info("Deleting fruit with ID {}", id);
        fruitService.deleteFruit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruit(@PathVariable int id) {
        log.info("Fetching fruit with ID {}", id);
        Fruit fruit = fruitService.getFruit(id);
        return new ResponseEntity<>(fruit, HttpStatus.OK);
    }

    @Override
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        log.info("Fetching all fruits");
        List<Fruit> fruits = fruitService.getAllFruits();
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }
}