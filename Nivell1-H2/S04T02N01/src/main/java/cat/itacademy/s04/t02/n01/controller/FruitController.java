package cat.itacademy.s04.t02.n01.controller;

import cat.itacademy.s04.t02.n01.model.Fruit;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FruitController {


    ResponseEntity<Fruit> addFruit(Fruit fruit);

    ResponseEntity<Fruit> updateFruit(Fruit fruit);

    ResponseEntity<Void> deleteFruit(int id);

    ResponseEntity<Fruit> getFruit(int id);

    ResponseEntity<List<Fruit>> getAllFruits();
}