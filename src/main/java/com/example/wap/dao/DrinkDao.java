package com.example.wap.dao;

import com.example.wap.model.BoughtDrink;
import com.example.wap.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.wap.repository.BoughtDrinkRepository;
import com.example.wap.repository.DrinkRepository;

@RestController

public class DrinkDao {

  @Autowired
  DrinkRepository drinkRepository;

  @Autowired
  BoughtDrinkRepository boughtDrinkRepository;

  @GetMapping("/findAllDrinks")
  public Iterable<Drink> findAllDrinks() {
    return drinkRepository.findAll();
  }

  @GetMapping("/findDrink/{id}")
  public Drink findDrinkById(@PathVariable(name = "id") int id) {
    return drinkRepository.findById(id).get();
  }

  @GetMapping("removeDrink/{id}")
  public void removeDrinkById(@PathVariable(name = "id") int id) {
    Iterable<BoughtDrink> boughtDrinks = boughtDrinkRepository.findAll();
    for (BoughtDrink bd : boughtDrinks) {
      if (bd.getDrinkId() == id) {
        boughtDrinkRepository.delete(bd);
      }
    }
    drinkRepository.deleteById(id);
  }

  @GetMapping("/addDrink")
  public Drink addDrink() {
    Drink l = new Drink();
    return drinkRepository.save(l);
  }

  @GetMapping("/updateDrink/{id}/name/{name}")
  public Drink setDrinkName(@PathVariable(name = "id") int id,
      @PathVariable(name = "name") String name) {
    Drink drink = drinkRepository.findById(id).get();
    drink.setName(name);
    return drinkRepository.save(drink);
  }
  @GetMapping("/updateDrink/{did}/price/{price}")
  public Drink setDrinkPrice(@PathVariable("did") int did,
      @PathVariable("price") int price) {
    Drink drink = drinkRepository.findById(did).get();
    drink.setPrice(price);
    return drinkRepository.save(drink);
  }
  @GetMapping("/updateDrink/{did}/size/{size}")
  public Drink setDrinkSize(@PathVariable("did") int did,
      @PathVariable("size") int size) {
    Drink drink = drinkRepository.findById(did).get();
    drink.setSize(size);
    return drinkRepository.save(drink);
  }


  @GetMapping("/updateDrink/{did}/beer/{beer}")
  public Drink setDrinkBeer(@PathVariable("did") int did,
      @PathVariable("beer") boolean beer) {
    Drink drink = drinkRepository.findById(did).get();
    drink.setBeer(beer);
    return drinkRepository.save(drink);
  }


}

