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

  @GetMapping("/addDrink/{did}/ToPerson/{id}")
  public BoughtDrink setBoughtDrink(@PathVariable(name = "id") int id, @PathVariable(name = "did") int did) {
    BoughtDrink boughtDrink = new BoughtDrink();
    boughtDrink.setDrinkId(did);
    boughtDrink.setPersonId(id);
    boughtDrink.setDrink(drinkRepository.findById(did).get());
    boughtDrink.setPerson(personRepository.findById(id).get());
    return boughtDrinkRepository.save(boughtDrink);
  }


  @GetMapping("/removeDrink/{did}/FromPerson/{id}")
  public void removeBoughtDrink(@PathVariable(name = "did") int did, @PathVariable(name = "id") int id) {
    BoughtDrinkId boughtDrinkId = new BoughtDrinkId(id, did);
    boughtDrinkRepository.deleteById(boughtDrinkId);
  }


  @GetMapping("/findAllMappings")
  public Iterable<BoughtDrink> findAllMappings() {
    return boughtDrinkRepository.findAll();
  }
}
