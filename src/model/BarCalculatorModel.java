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
  public void addPerson(Person person) throws IllegalArgumentException {

  }

  @Override
  public void addDrinkToPerson(Drink drink, Person person) {

  }
}
