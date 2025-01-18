package cat.itacademy.s04.t02.n01.service.impl;

import cat.itacademy.s04.t02.n01.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n01.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import cat.itacademy.s04.t02.n01.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruit(Fruit fruit) {
        fruitRepository.findByName(fruit.getName()).ifPresent(dupFruit -> {
            throw new FruitAlreadyExistsException("The Fruit " + fruit.getName() + " already exists");
        });
        Fruit newFruit = Fruit.builder()
                .name("Apple")
                .kgQuantity(10)
                .build();
        return fruitRepository.save(newFruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        Fruit dbFruit = fruitRepository.findById(fruit.getId())
                .orElseThrow(()-> new FruitNotFoundException("Fruit with id " + fruit.getId() + " not found"));
        dbFruit.setName(fruit.getName());
        dbFruit.setKgQuantity(fruit.getKgQuantity());
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(int id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(()-> new FruitNotFoundException("Fruit with id " + id + " not found"));
        fruitRepository.delete(fruit);
    }

    @Override
    public Fruit getFruit(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(()-> new FruitNotFoundException("Fruit with id " + id + " not found"));
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
