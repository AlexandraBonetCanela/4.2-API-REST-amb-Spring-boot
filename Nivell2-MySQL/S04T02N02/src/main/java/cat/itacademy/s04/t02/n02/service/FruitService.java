package cat.itacademy.s04.t02.n02.service;

import cat.itacademy.s04.t02.n02.model.Fruit;

import java.util.List;

public interface FruitService {

    Fruit addFruit(Fruit fruit);

    Fruit updateFruit(Fruit fruit);

    void deleteFruit(int id);

    Fruit getFruit(int id);

    List<Fruit> getAllFruits();
}
