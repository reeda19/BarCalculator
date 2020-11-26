package model;

import java.util.ArrayList;

public class BarCalculatorModel implements IBarCalculatorModel<Person, Drink> {

  ArrayList<Person> people;
  ArrayList<Drink> drinks;

  public BarCalculatorModel() {
    this.people = new ArrayList<>();
    this.drinks = new ArrayList<>();

  }


  @Override
  public void addPerson(String personName) throws IllegalArgumentException {
    Person person = new Person(personName);
    if (people.contains(person)) {
      throw new IllegalArgumentException("Person already exists");
    }
    people.add(person);
  }

  @Override
  public void addDrinkToPerson(Drink drink, Person person) throws IllegalArgumentException {
    ArrayList<Person> people = this.getPeople();
    if (people.contains(person)) {
      people.get(people.indexOf(person)).addDrink(drink);
    } else {
      throw new IllegalArgumentException("Person does not exist");
    }
  }
  

  public ArrayList<Person> getPeople() {
    return new ArrayList<Person>(people);
  }
}
