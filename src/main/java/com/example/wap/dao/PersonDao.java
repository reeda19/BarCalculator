package com.example.wap.dao;

import com.example.wap.model.BoughtDrink;
import com.example.wap.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.wap.repository.BoughtDrinkRepository;
import com.example.wap.repository.PersonRepository;

@RestController
public class PersonDao {
  
    @Autowired
    PersonRepository personRepository;

    @Autowired
    BoughtDrinkRepository boughtDrinkRepository;

    @GetMapping("/findAllPersons")
    public Iterable<Person> findAllPersons() {
      return personRepository.findAll();
    }

    @GetMapping("/findPerson/{id}")
    public Person findPersonById(@PathVariable(name = "id") int id) {
      return personRepository.findById(id).get();
    }

    @GetMapping("removePerson/{id}")
    public void removePersonById(@PathVariable(name = "id") int id) {
      Iterable<BoughtDrink> boughtDrinks = boughtDrinkRepository.findAll();
      for (BoughtDrink bd : boughtDrinks) {
        if (bd.getPersonId() == id) {
          boughtDrinkRepository.delete(bd);
        }
      }
      personRepository.deleteById(id);
    }

    @GetMapping("/addPerson")
    public Person addPerson() {
      Person l = new Person();
      return personRepository.save(l);
    }

    @GetMapping("/updatePerson/{id}/name/{name}")
    public Person setPersonName(@PathVariable(name = "id") int id,
        @PathVariable(name = "name") String name) {
      Person person = personRepository.findById(id).get();
      person.setName(name);
      return personRepository.save(person);
    }


  }

