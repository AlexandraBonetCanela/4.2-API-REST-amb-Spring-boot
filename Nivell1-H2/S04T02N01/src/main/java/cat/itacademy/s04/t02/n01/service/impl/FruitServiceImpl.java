package cat.itacademy.s04.t02.n01.service;

import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceImpl {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
}
