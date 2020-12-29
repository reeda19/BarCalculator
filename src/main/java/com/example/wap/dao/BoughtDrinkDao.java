package com.example.wap.dao;

import com.example.wap.model.BoughtDrink;
import com.example.wap.model.BoughtDrinkId;
import com.example.wap.repository.BoughtDrinkRepository;
import com.example.wap.repository.DrinkRepository;
import com.example.wap.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoughtDrinkDao {
  @Autowired
  DrinkRepository drinkRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  BoughtDrinkRepository boughtDrinkRepository;

  @GetMapping("/addPerson/{sched}/ToDrink/{id}")
  public BoughtDrink setBoughtDrink(@PathVariable(name = "id") int id, @PathVariable(name = "sched") int sched) {
    BoughtDrink boughtDrink = new BoughtDrink();
    boughtDrink.setDrinkId(id);
    boughtDrink.setPersonId(sched);
    boughtDrink.setDrink(drinkRepository.findById(id).get());
    boughtDrink.setPerson(personRepository.findById(sched).get());
    return boughtDrinkRepository.save(boughtDrink);
  }


  @GetMapping("/removePerson/{sched}/FromDrink/{id}")
  public void removeBoughtDrink(@PathVariable(name = "sched") int sched, @PathVariable(name = "id") int id) {
    BoughtDrinkId boughtDrinkId = new BoughtDrinkId(id, sched);
    boughtDrinkRepository.deleteById(boughtDrinkId);
  }


  @GetMapping("/findAllMappings")
  public Iterable<BoughtDrink> findAllMappings() {
    return boughtDrinkRepository.findAll();
  }
}
